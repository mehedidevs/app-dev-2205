package com.mehedi.esappdev2205.class17

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mehedi.esappdev2205.R
import com.mehedi.esappdev2205.databinding.ActivityMainC17Binding

class MainActivityC17 : AppCompatActivity() {

    lateinit var binding: ActivityMainC17Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainC17Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}