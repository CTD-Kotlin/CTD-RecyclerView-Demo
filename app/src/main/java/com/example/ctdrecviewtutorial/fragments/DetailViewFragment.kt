package com.example.ctdrecviewtutorial.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer

import com.example.ctdrecviewtutorial.R
import com.example.ctdrecviewtutorial.database.MyViewModel
import kotlinx.android.synthetic.main.fragment_detail_view.*

class DetailViewFragment : Fragment() {

    private val viewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        buttonDeleteNote.setOnClickListener {

        }

        viewModel.myNotes.observe(this, Observer {
            it?.let { noteList ->

            }
        })

    }
}
