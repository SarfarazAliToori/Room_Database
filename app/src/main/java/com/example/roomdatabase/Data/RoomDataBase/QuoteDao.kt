package com.example.roomdatabase.Data.RoomDataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote_table")
    fun getQuotes(): LiveData<List<Quote>>

    @Insert
    fun insertQuote(quote: Quote)
}