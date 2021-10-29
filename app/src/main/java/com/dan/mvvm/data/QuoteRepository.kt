package com.dan.mvvm.data

import com.dan.mvvm.data.model.QuoteModel
import com.dan.mvvm.data.model.QuoteProvider
import com.dan.mvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}