package com.dan.mvvm.domain

import com.dan.mvvm.data.QuoteRepository
import javax.inject.Inject


class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke() = repository.getAllQuotes()
}