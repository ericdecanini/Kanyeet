package com.ericdecanini.kanyeet

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val kanyeRepository = KanyeRepository()

    val quoteLiveData = MutableLiveData<String>()

    init {
        fetchQuote()
    }

    fun fetchQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            val quote = kanyeRepository.getQuote()
            quoteLiveData.postValue(quote)
        }
    }
}
