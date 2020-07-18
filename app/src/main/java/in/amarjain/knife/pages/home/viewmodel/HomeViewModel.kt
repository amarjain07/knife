package `in`.amarjain.knife.pages.home.viewmodel

import `in`.amarjain.knife.pages.home.model.HomeRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {
    fun init() {
        viewModelScope.launch {
            try {
                val response = repository.searchImages("birds")
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}