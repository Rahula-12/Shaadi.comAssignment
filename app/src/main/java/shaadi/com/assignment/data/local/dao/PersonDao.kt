package shaadi.com.assignment.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import shaadi.com.assignment.data.local.entity.PersonEntity

@Dao
interface PersonDao{

    @Query("SELECT * FROM personentity")
    fun getAllPersons(): PagingSource<Int, PersonEntity>

    @Query("Delete from PersonEntity")
    suspend fun clearAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: PersonEntity)

    @Update
    suspend fun updatePerson(person: PersonEntity)

    @Query("SELECT * from personentity where id=:id")
    suspend fun getPersonById(id:Int):PersonEntity?

    @Query("SELECT * from personentity where uuid=:uuid")
    suspend fun getPersonByUUID(uuid:String):PersonEntity?

}
