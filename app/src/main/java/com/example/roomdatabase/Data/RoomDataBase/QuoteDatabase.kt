package com.example.roomdatabase.Data.RoomDataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDoa(): QuoteDao

    companion object {
        private var INSTENCE: QuoteDatabase? = null

        fun getDatabase(context: Context): QuoteDatabase {
            if (INSTENCE == null) {
                synchronized(this) {
                    INSTENCE = Room.databaseBuilder(context,
                        QuoteDatabase::class.java,
                        "quotes"
                    )
                        .createFromAsset("quotes_database.db")
                        .build()
                }
            }
            return INSTENCE!!
        }
    }
}