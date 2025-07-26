package shaadi.com.assignment.domain

import androidx.lifecycle.LiveData
import androidx.paging.PagingData

interface Repository {

    fun getPersonsData(): LiveData<PagingData<Person>>

    suspend fun updateStatus(status:Int,id:Int)
}