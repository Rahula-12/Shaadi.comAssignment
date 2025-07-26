package shaadi.com.assignment.data.remotemediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import shaadi.com.assignment.data.local.db.PersonsDatabase
import shaadi.com.assignment.data.local.entity.PersonEntity
import shaadi.com.assignment.data.mapper.toPerson
import shaadi.com.assignment.data.network.apiservice.PersonAPIService
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PersonRemoteMediator @Inject constructor(
    private val apiService: PersonAPIService,
    private val database: PersonsDatabase
) : RemoteMediator<Int, PersonEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PersonEntity>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> 1
            LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
            LoadType.APPEND -> {
                val lastItem = state.lastItemOrNull()
                if (lastItem == null) 1 else (lastItem.id / state.config.pageSize) + 1
            }
        }

        return try {
            val response = apiService.getPersonData(page, state.config.pageSize)
            val personDTO = response.results
            val personData=personDTO.map {
                it.toPerson()
            }
            for(person in personData) {
                val personExist=database.getPersonDao().getPersonByUUID(person.uuid)
                if(personExist==null) {
                    database.withTransaction {
//                        if (loadType == LoadType.REFRESH) database.getPersonDao().clearAll()
                        database.getPersonDao().insertPerson(person)
                    }
                }
            }
            MediatorResult.Success(endOfPaginationReached = response.info.page == 10000)
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}
