package com.example.roomdatabase.Ropostitory

import androidx.lifecycle.LiveData
import com.example.roomdatabase.Data.RoomDataBase.Quote
import com.example.roomdatabase.Data.RoomDataBase.QuoteDao

class QuoteRepository(private val quoteDao: QuoteDao) {

    fun getQuotes() : LiveData<List<Quote>> {
        return quoteDao.getQuotes()
    }

    suspend fun insertQuote(quote: Quote) {
        quoteDao.insertQuote(quote)
    }
}