package com.route.islamic37fri.home.hadeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic37fri.Hadeth
import com.route.islamic37fri.databinding.FragmentHadethBinding

class HadethFragment : Fragment() {

    lateinit var viewBinding: FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentHadethBinding.inflate(
            inflater,
            container, false
        )
        return viewBinding.root
    }

    lateinit var adapter: HadethTitlesRecyclerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethFile();
        adapter = HadethTitlesRecyclerAdapter(allAhadeth)
        viewBinding.hadethRecycler.adapter = adapter

    }

    val allAhadeth = mutableListOf<Hadeth>()
    fun readHadethFile() {
        val fileContent = activity?.assets?.open("ahadeth.txt")?.bufferedReader().use {
            it?.readText()
        }
        if (fileContent == null) return;
        val ahadethContents = fileContent.trim().split("#")
//        for(String singleHadethContent : ahadethContents){
//
//        }
        ahadethContents.forEach { singleHadethContent ->
//            val indexOfFirstLine = singleHadethContent.indexOf('\n')
            //          val title = singleHadethContent.substring(0,indexOfFirstLine)
            val title = singleHadethContent.trim().substringBefore('\n');
            val content = singleHadethContent.trim().substringAfter('\n')
            val hadeth = Hadeth(title, content)
            allAhadeth.add(hadeth)
        }
    }

}