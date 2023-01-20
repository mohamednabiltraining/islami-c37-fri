package com.route.islamic37fri.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic37fri.Hadeth
import com.route.islamic37fri.databinding.ItemHadethTitleBinding

class HadethTitlesRecyclerAdapter(val items: List<Hadeth>) :
    RecyclerView.Adapter<HadethTitlesRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemHadethTitleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.title.text = items[position].title
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val viewBinding: ItemHadethTitleBinding) :
        RecyclerView.ViewHolder(viewBinding.root)
}