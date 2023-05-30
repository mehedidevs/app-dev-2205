package com.mehedi.esappdev2205.class23_room

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mehedi.esappdev2205.R
import com.mehedi.esappdev2205.databinding.FragmentHome2Binding


class HomeFragment : Fragment(), NoteAdapter.NoteDeleteListener, NoteAdapter.NoteEditListener {

    lateinit var binding: FragmentHome2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHome2Binding.inflate(inflater, container, false)


        NoteDatabase.getDB(requireContext()).getNoteDao().getAllNote()?.let {

            var adapter: NoteAdapter = NoteAdapter(this, this)
            adapter.submitList(it)

            binding.noteRCV.adapter = adapter


        }






        binding.addNote.setOnClickListener {


    findNavController().navigate(R.id.action_homeFragment2_to_addNoteFragment)

        }






        return binding.root
    }

    override fun onNoteEdit(note: Note) {

        val bundle = Bundle()
        bundle.putInt(AddNoteFragment.NOTE_ID, note.noteId)
        findNavController().navigate(R.id.action_homeFragment2_to_addNoteFragment, bundle)


    }

    override fun onNoteDelete(note: Note) {

    }


}