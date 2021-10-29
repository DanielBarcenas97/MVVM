package com.dan.mvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dan.mvvm.data.model.QuoteModel
import com.dan.mvvm.data.model.QuoteProvider
import com.dan.mvvm.domain.GetQuotesUseCase
import com.dan.mvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    var getQuotesUseCase = GetQuotesUseCase()
    val isLoading = MutableLiveData<Boolean>()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }



    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }
}