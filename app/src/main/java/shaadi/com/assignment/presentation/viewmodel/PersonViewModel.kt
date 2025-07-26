package shaadi.com.assignment.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import shaadi.com.assignment.domain.Repository
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val personRepository: Repository
):ViewModel() {

    val personData=personRepository.getPersonsData()

     fun acceptOrReject(status:Int,id:Int) {
         viewModelScope.launch {
             personRepository.updateStatus(status,id)
         }

    }

}