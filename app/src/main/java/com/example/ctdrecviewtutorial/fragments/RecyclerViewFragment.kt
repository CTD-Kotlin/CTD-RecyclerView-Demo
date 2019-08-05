package com.example.ctdrecviewtutorial.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.ctdrecviewtutorial.R
import com.example.ctdrecviewtutorial.adapter.NoteRecylcerViewAdapter
import com.example.ctdrecviewtutorial.database.MyViewModel
import kotlinx.android.synthetic.main.fragment_recycler_view.*

class RecyclerViewFragment : Fragment() {

    val viewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = NoteRecylcerViewAdapter { position ->
            val bundle = bundleOf(getString(R.string.position_key) to position)
            findNavController().navigate(R.id.action_recyclerViewFragment_to_detailViewFragment, bundle)
        }

        val myLayoutManager = LinearLayoutManager(requireContext())
        recyclerView.apply {
            this.layoutManager = myLayoutManager
            this.adapter = adapter
        }

        viewModel.myNotes.observe(this, Observer {
            it?.let { noteList ->
                Log.d(javaClass.name, "number of notes = ${noteList.size}")
                adapter.submitList(ArrayList(noteList))
            }
        })

        floatingActionButton.setOnClickListener {
            viewModel.addNote()
        }
    }

}
