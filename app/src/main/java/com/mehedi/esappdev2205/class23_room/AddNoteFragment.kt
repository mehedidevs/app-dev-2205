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
import com.mehedi.esappdev2205.databinding.FragmentAddNoteBinding
import java.util.Calendar

class AddNoteFragment : Fragment(), AdapterView.OnItemSelectedListener {

    lateinit var binding: FragmentAddNoteBinding

    val priorityList = listOf("Select your Priority", "High", "Medium", "Low")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)

        var spinnerAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, priorityList)

        binding.priorityMenu.adapter = spinnerAdapter



        binding.datePickerBtn.setOnClickListener {
            pickADate()
        }

        binding.timePickerBtn.setOnClickListener {

            pickATime()

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

                    var time = "$hour : $hourOfDay"
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
                var selectedDate = "$dayOfMonth/$month/$year"
                binding.datePickerBtn.text = selectedDate
            },
            year, month, date
        )
        dialog.show()


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(
            requireContext(),
            priorityList[position],
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


}