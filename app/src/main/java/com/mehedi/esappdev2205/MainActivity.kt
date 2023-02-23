package com.mehedi.esappdev2205

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mehedi.esappdev2205.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.showBtn.setOnClickListener {
            var msg: String = binding.userInput.text.toString()
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_LONG).show()
            binding.image1.setImageResource(R.drawable.biden)
            binding.showBtn.text = msg
        }

    }
}