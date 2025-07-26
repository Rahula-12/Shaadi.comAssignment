package shaadi.com.assignment.data.repository

import androidx.lifecycle.map
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import androidx.paging.map
import shaadi.com.assignment.data.local.dao.PersonDao
import shaadi.com.assignment.data.mapper.toPerson
import shaadi.com.assignment.data.remotemediator.PersonRemoteMediator
import shaadi.com.assignment.domain.Repository
import javax.inject.Inject

class PersonRepository @Inject constructor(
    private val personRemoteMediator: PersonRemoteMediator,
    private val personDao: PersonDao
) : Repository{

    @OptIn(ExperimentalPagingApi::class)
   override fun getPersonsData() = Pager(
        config = PagingConfig(pageSize = 10),
        remoteMediator = personRemoteMediator,
        pagingSourceFactory = { personDao.getAllPersons()}
    ).liveData.map {
        it.map { personEntity->personEntity.toPerson() }
    }

    override suspend fun updateStatus(status:Int,id:Int) {
        val person=personDao.getPersonById(id)
        when(status) {
            0->{
                val updatedPerson=person?.copy(status="Rejected")
                updatedPerson?.let {
                    personDao.updatePerson(it)
                }

            }
            else-> {
                val updatedPerson=person?.copy(status="Accepted")
                updatedPerson?.let {
                    personDao.updatePerson(it)
                }
            }
        }
    }

}