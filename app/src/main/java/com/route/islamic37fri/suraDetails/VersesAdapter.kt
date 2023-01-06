package com.route.islamic37fri.suraDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic37fri.R

class VersesAdapter(val verses: List<String>) : RecyclerView.Adapter<VersesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_verse, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.content.setText(verses[position])
    }

    override fun getItemCount(): Int = verses.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView

        init {
            content = itemView.findViewById(R.id.content)
        }
    }
}