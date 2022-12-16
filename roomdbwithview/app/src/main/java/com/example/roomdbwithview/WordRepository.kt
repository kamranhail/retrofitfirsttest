package com.example.roomdbwithview

import androidx.lifecycle.LiveData

class WordRepository(private val worddao :WordDao) {

    val allWords: LiveData<List<Word>> = worddao.getAllphabetizedWordslist()

    suspend fun insert (word :Word)
    {
        worddao.insert(word)


    }


    suspend fun delete (word :Word)
    {
        worddao.delete(word)


    }
}