package com.mehedi.esappdev2205.class23_room

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.mehedi.esappdev2205.databinding.FragmentAddNoteBinding
import java.util.Calendar

class AddNoteFragment : Fragment(), AdapterView.OnItemSelectedListener {

    lateinit var binding: FragmentAddNoteBinding

    private val priorityList = listOf("Select your Priority", "High", "Medium", "Low")

    private var time: String? = null
    private var selectedDate: String? = null
    private var priority: String? = null


    lateinit var database: NoteDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)

        database =
            Room.databaseBuilder(
                requireActivity(),
                NoteDatabase::class.java,
                "Note-db"
            ).allowMainThreadQueries()
                .build()


        var spinnerAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, priorityList)

        binding.priorityMenu.adapter = spinnerAdapter

        binding.priorityMenu.onItemSelectedListener = this@AddNoteFragment



        binding.datePickerBtn.setOnClickListener {
            pickADate()
        }

        binding.timePickerBtn.setOnClickListener {

            pickATime()

        }


        binding.submitBtn.setOnClickListener {
            var titleStr = binding.noteTitleEDt.text.toString()
            var timeStr = time ?: "00:00"
            var dateStr = selectedDate ?: "0/0/00"
            var priorityStr = priority ?: priorityList[3]

            var note =
                Note(
                    title = titleStr,
                    time = timeStr,
                    date = dateStr,
                    priority = priorityStr
                )

            database.getNoteDao().insertData(note)


        }





        return binding.root
    }


    private fun pickATime() {

        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        val timePickerDialog =
            TimePickerDialog(
                requireContext(),
                { _, hourOfDay, minute ->

                    time = "$hourOfDay : $minute"
                    binding.timePickerBtn.text = time


                }, hour, minute, false
            )

        timePickerDialog.show()


    }

    private fun pickADate() {

        val c = Calendar.getInstance()

        val date = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)

        val dialog = DatePickerDialog(
            requireActivity(),
            { _, year, month, dayOfMonth ->
                selectedDate = "$dayOfMonth/$month/$year"
                binding.datePickerBtn.text = selectedDate
            },
            year, month, date
        )
        dialog.show()


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        priority = priorityList[position]

        Toast.makeText(
            requireContext(),
            priority,
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


}