package com.example.roomdbwithview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(private val context : Context,private val listener : IWordRVadapter) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    val allWords = ArrayList<Word>()
    inner class WordViewHolder(itemtview :View):RecyclerView.ViewHolder(itemtview)
    {
    val titltext=itemtview.findViewById<TextView>(R.id.tv_title)
    val delbtn=itemtview.findViewById<ImageButton>(R.id.iv_delete)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val viewHolder= WordViewHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false))
viewHolder.delbtn.setOnClickListener{
listener.onItemClicked(allWords[viewHolder.adapterPosition])
}
        return viewHolder

    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
         val  currenWor=allWords[position]
        holder.titltext.text=currenWor.word
    }

    override fun getItemCount(): Int {
       return allWords.size
    }

    fun updateList (newlist :List<Word> )
    {
        allWords.clear()
        allWords.addAll(newlist)
        //here we populate the things
        notifyDataSetChanged()

    }


    interface  IWordRVadapter
    {
        fun onItemClicked(word : Word)

    }

}