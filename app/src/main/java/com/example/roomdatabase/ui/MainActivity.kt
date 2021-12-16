package com.example.roomdatabase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase.Data.RoomDataBase.Quote
import com.example.roomdatabase.Data.RoomDataBase.QuoteDao
import com.example.roomdatabase.Data.RoomDataBase.QuoteDatabase
import com.example.roomdatabase.R
import com.example.roomdatabase.Ropostitory.QuoteRepository
import com.example.roomdatabase.ViewModel.MainViewModel
import com.example.roomdatabase.ViewModel.MainViewModelFactory
import com.example.roomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainBinding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDoa()
        val repository = QuoteRepository(dao)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.getQuotes().observe(this, Observer {
            mainBinding.quotes = it.toString()
        })

        mainBinding.btnAddQuote.setOnClickListener {

            val quote = Quote(0, "Hello World", "Faraz")
                mainViewModel.insertQuotes(quote)
        }
    }
}