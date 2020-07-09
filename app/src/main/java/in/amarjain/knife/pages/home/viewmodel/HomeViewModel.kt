package `in`.amarjain.knife.pages.home.viewmodel

import `in`.amarjain.knife.pages.home.model.HomeRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeViewModel(repository: HomeRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            val asa = repository.searchImages("birds")
        }
    }
}