package shaadi.com.assignment.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import shaadi.com.assignment.data.local.dao.PersonDao
import shaadi.com.assignment.data.local.db.PersonsDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object LocalDBModule {

    @Singleton
    fun providesDBInstance(@ApplicationContext context: Context):PersonsDatabase {
        return Room.databaseBuilder(
            context,
            PersonsDatabase::class.java,
            "persons_db"
            ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    fun providesDBDao(database: PersonsDatabase):PersonDao {
        return database.getPersonDao()
    }

}