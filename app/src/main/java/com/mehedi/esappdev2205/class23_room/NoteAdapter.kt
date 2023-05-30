package com.mehedi.esappdev2205.class23_room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.esappdev2205.databinding.ItemNoteBinding

class NoteAdapter(
    var noteEditListener: NoteEditListener,
    var noteDeleteListener: NoteDeleteListener
) : ListAdapter<Note, NoteAdapter.NoteViewHolder>(comparator) {

    interface NoteEditListener {
        fun onNoteEdit(note: Note)

    }

    interface NoteDeleteListener {
        fun onNoteDelete(note: Note)

    }


    class NoteViewHolder(var binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)


    companion object {


        var comparator = object : DiffUtil.ItemCallback<Note>() {
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {

                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.noteId == newItem.noteId
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        getItem(position).let {
            holder.binding.apply {
                noteTitle.text = it.title
                noteDate.text = it.date
                noteTime.text = it.time
            }

            holder.itemView.setOnClickListener { _ ->
                noteEditListener.onNoteEdit(it)

            }

            holder.binding.noteDeleteBtn.setOnClickListener { _ ->

                noteDeleteListener.onNoteDelete(it)
            }


        }


    }


}