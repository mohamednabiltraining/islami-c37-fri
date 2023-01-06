package com.route.islamic37fri.home.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic37fri.R

class QuranChaptersAdapter(val titles: List<String>) :
    RecyclerView.Adapter<QuranChaptersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chapter_name, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.setText(titles[position])
//        if(onItemClickListener!=null){
//            holder.itemView.setOnClickListener {
//                onItemClickListener?.onItemClick(position,titles[position])
//            }
//        }
        onItemClickListener?.let {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position, titles[position])
            }
        }
        if (holder.adapterPosition == titles.size - 1) {
            holder.itemView.findViewById<View>(R.id.separator)
                .visibility = View.GONE
        }
    }

    var onItemClickListener: OnItemClickListener? = null

    override fun getItemCount(): Int = titles.size

    interface OnItemClickListener {
        fun onItemClick(pos: Int, item: String)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView

        init {
            title = itemView.findViewById(R.id.title)
        }
    }
}