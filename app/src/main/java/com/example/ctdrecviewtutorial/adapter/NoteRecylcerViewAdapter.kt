package com.example.ctdrecviewtutorial.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ctdrecviewtutorial.R
import com.example.ctdrecviewtutorial.models.Note

class NoteRecylcerViewAdapter : ListAdapter<Note, NoteViewHolder>(NoteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.note = getItem(position)
    }

}

class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var note: Note? = null
    set(value) {
        field = value
        note?.let {
            itemView.findViewById<TextView>(R.id.textViewVHTitle).text = it.title
            val content = itemView.findViewById<TextView>(R.id.textViewVHPreview)
            content.text = it.content
            content.visibility = if (it.isPrivate) View.GONE else View.VISIBLE
            itemView.findViewById<TextView>(R.id.textViewVHDate).text = it.timeStamp.toString()
        }

    }
}

class NoteDiffCallback : DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.timeStamp == newItem.timeStamp
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.title == newItem.title && oldItem.content == newItem.content && oldItem.timeStamp == newItem.timeStamp
    }

}