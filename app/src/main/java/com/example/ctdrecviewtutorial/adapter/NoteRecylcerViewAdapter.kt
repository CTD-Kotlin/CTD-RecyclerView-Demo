package com.example.ctdrecviewtutorial.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ctdrecviewtutorial.models.Note

class NoteRecylcerViewAdapter : ListAdapter<Note, NoteViewHolder>(NoteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
    }

}

class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

}

class NoteDiffCallback : DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
    }

}