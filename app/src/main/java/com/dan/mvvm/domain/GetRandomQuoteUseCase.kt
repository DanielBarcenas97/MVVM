package com.dan.mvvm.domain

import com.dan.mvvm.data.model.QuoteModel
import com.dan.mvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}