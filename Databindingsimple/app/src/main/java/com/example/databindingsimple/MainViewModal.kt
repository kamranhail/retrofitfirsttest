package com.example.databindingsimple

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModal : ViewModel() {
    var counter: Int = 0
    var Str_main: String = "this is main text"

    val QuoteLiveData = MutableLiveData("this is view modal live data")
    fun setcounter() {
        counter++


    }

   public fun UpdateQuote() {
        QuoteLiveData.value = "live data value is chaged "
    }
}