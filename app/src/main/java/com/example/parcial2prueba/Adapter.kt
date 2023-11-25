package com.example.parcial2prueba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val frutas: List<DetailFruit>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    lateinit var onItemClickListener: (DetailFruit) -> Unit

    inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.tv_itemList)

        fun bind(fruit: DetailFruit) {
            textView.text = fruit.name

            view.setOnClickListener{
                onItemClickListener(fruit)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return frutas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = frutas[position]
        holder.bind(fruit)
    }
}