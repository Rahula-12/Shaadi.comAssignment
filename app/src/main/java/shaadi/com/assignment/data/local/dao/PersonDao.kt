package shaadi.com.assignment.data.local.dao

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import shaadi.com.assignment.data.local.entity.Person

@Dao
interface PersonDao{

    @Insert
    suspend fun insert(person: Person)

    @Query("Select * from Person")
    fun getAllPersons():LiveData<PagingData<Person>>

    @Query("Delete from Person")
    suspend fun clearAll()

}
