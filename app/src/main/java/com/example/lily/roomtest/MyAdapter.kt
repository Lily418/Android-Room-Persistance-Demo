package com.example.lily.roomtest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Lily Hoskin on 25/10/2017.
 */
class MyAdapter() : RecyclerView.Adapter<MyViewHolder>() {

    private val items = mutableListOf<Person>()

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = items[position].name
        holder.textView.tag = items[position].uid
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MyViewHolder(layoutInflater.inflate(R.layout.item_person, parent, false))
    }

    override fun getItemCount(): Int = items.size

    fun addPerson(p : Person) {
        items.add(p)
        notifyItemInserted(items.size -1)
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView: TextView by lazy {
        itemView.findViewById<TextView>(R.id.name)
    }

}