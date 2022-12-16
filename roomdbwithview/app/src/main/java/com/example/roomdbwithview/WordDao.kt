package com.example.roomdbwithview

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    // The flow always holds/caches latest version of data. Notifies its observers when the
    // data has changed.


    @Query("SELECT * FROM word_table ORDER BY id ASC")
    fun getAllphabetizedWordslist(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
      fun insert(word: Word)



   @Delete
     fun delete(word : Word)
}