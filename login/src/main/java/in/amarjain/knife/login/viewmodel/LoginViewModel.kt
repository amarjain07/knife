package `in`.amarjain.knife.login.viewmodel

import `in`.amarjain.knife.login.model.LoginRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {
    fun init() {
        viewModelScope.launch {
            try {
                val response = repository.login("amar.jain07@gmail.com", "amar@123")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}