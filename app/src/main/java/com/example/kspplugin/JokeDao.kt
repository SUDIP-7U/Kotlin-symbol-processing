package com.example.kspplugin

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface JokeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(joke: Joke)

    @Query("SELECT * FROM jokes ORDER BY id DESC")
    fun getAllJokes(): LiveData<List<Joke>>
}
