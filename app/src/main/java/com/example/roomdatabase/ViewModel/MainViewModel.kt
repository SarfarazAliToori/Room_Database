package com.example.roomdatabase.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.coroutineScope
import com.example.roomdatabase.Data.RoomDataBase.Quote
import com.example.roomdatabase.Ropostitory.QuoteRepository
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainViewModel( val repository: QuoteRepository) : ViewModel() {

    fun getQuotes(): LiveData<List<Quote>> {
        return repository.getQuotes()
    }

    fun insertQuotes(quote: Quote) {
        GlobalScope.launch(Dispatchers.IO) {
              repository.insertQuote(quote)
        }
    }
}
