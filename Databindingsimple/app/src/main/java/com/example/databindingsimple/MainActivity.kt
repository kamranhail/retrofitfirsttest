package com.example.databindingsimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databindingsimple.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  lateinit var viewmodal: MainViewModal
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewmodal=ViewModelProvider(this).get(MainViewModal::class.java)

        //we need to give owner of live data live data is aware of live data
        binding.lifecycleOwner=this


        val postt =Post("Title Kamran ","this is description ","https://wallpaper.dog/small/240501.jpg")
// we changed set value in XML  .text of tetview and we also changed button click listener
      //  viewmodal.QuoteLiveData.observe(this,{
         //   binding.twFirst.text=it


      //  })
        binding.post=postt
binding.viewmodal=viewmodal


    }
}