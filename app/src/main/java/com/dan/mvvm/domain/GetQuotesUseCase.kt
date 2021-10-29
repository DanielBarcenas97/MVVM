package com.dan.mvvm.domain

import com.dan.mvvm.data.QuoteRepository
import com.dan.mvvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel> = repository.getAllQuotes()


}