package com.example.kspplugin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes")
data class Joke(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String
)
