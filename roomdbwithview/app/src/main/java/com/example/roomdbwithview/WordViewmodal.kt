package com.example.roomdbwithview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewmodal(application: Application) : AndroidViewModel(application) {

   val allwords : LiveData<List<Word>>
    private val  repository: WordRepository
    init {
val databasedao = WordDatabase.getDatabase(application).getWordDao()
         repository=WordRepository(databasedao)
        allwords=repository.allWords

    }



     fun  deleteWord(word : Word)=viewModelScope.launch (Dispatchers.IO){

repository.delete(word)
    }
    fun  insertWord(word : Word)=viewModelScope.launch (Dispatchers.IO){

        repository.insert(word)
    }
}