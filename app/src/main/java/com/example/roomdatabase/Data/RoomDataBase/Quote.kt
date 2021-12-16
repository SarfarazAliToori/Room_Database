package com.example.roomdatabase.Data.RoomDataBase

import androidx.appcompat.widget.ActivityChooserView
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote_table")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val text: String,
    val author: String
)
