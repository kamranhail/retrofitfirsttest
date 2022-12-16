package com.example.roomdbwithview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),WordAdapter.IWordRVadapter {
    lateinit var viewmodal: WordViewmodal
    lateinit  var rcview : RecyclerView
    lateinit  var etimput : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
rcview=findViewById(R.id.rv_main)
        etimput=findViewById(R.id.et_title)
        rcview.layoutManager=LinearLayoutManager(this)
        val adaptr=WordAdapter(this,this)

        rcview.adapter=adaptr
        viewmodal=ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(WordViewmodal::class.java)

        viewmodal.allwords.observe(this, Observer {list ->
list?.let {
    adaptr.updateList(it)
}



        })



    }

    override   fun onItemClicked(word : Word)
    {
viewmodal.deleteWord(word)
        Toast.makeText(this,"$word deleted",Toast.LENGTH_LONG).show()
    }
// it is called from xml submit data

    fun SubmitData(view: View) {

        val notetext=etimput.text.toString()
        if (notetext.isNotEmpty())
        {

            viewmodal.insertWord(Word(notetext))

            Toast.makeText(this,"$notetext inserted",Toast.LENGTH_LONG).show()
        }

    }
}