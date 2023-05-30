package com.mehedi.esappdev2205.class23_room

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.mehedi.esappdev2205.R
import com.mehedi.esappdev2205.databinding.FragmentHome2Binding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHome2Binding
    lateinit var database: NoteDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHome2Binding.inflate(inflater, container, false)
        database =
            Room.databaseBuilder(
                requireActivity(),
                NoteDatabase::class.java,
                "Note-db"
            ).allowMainThreadQueries()
                .build()


        var notes: List<Note> =   database.getNoteDao().getAllNote()






        binding.addNote.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment2_to_addNoteFragment)

        }






        return binding.root
    }


}