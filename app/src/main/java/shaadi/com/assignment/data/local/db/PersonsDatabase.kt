package shaadi.com.assignment.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import shaadi.com.assignment.data.local.dao.PersonDao
import shaadi.com.assignment.data.local.entity.Person

@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class PersonsDatabase:RoomDatabase() {

    abstract fun getPersonDao():PersonDao

}