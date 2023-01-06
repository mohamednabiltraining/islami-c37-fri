package com.route.islamic37fri.suraDetails

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic37fri.Constants
import com.route.islamic37fri.R

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var chapterName: TextView
    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        recyclerView = findViewById(R.id.recycler_view)
        chapterName = findViewById(R.id.chapter_name)
        val suraName: String = intent.getStringExtra(Constants.EXTRA_SURA_NAME) ?: ""
        val index = intent.getIntExtra(Constants.EXTRA_SURA_INDEX, 0)
        val verses = readSuraFile(index)
        adapter = VersesAdapter(verses)
        recyclerView.adapter = adapter
        chapterName.text = suraName

    }

    fun readSuraFile(index: Int): List<String> {
        val file_name = "" + (index + 1) + ".txt"// "${index+1}.txt"// index+1+".txt"
        val fileContent = application.assets.open(file_name).bufferedReader().use {
            it.readText()
        }
        val verses = fileContent.split("\n");
        return verses;
    }

    fun back(view: View) {
//        onBackPressed()
        finish()
    }
}