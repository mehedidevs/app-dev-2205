package com.mehedi.esappdev2205

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import com.mehedi.esappdev2205.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.modeSwitch.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                Toast.makeText(this, " agreeCheckBox Checked", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "agreeCheckBox Not Checked", Toast.LENGTH_SHORT).show()
            }


        }

        binding.agreeCheckBox.setOnCheckedChangeListener { _, isChecked ->

            if (!isChecked) {
                Toast.makeText(this, "modeSwitch Checked", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "modeSwitch Not Checked", Toast.LENGTH_SHORT).show()
            }


        }


    }
}