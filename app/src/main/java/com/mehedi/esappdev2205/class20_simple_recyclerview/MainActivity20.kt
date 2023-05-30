package com.mehedi.esappdev2205.class20_simple_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mehedi.esappdev2205.R
import com.mehedi.esappdev2205.databinding.ActivityMain20Binding

class MainActivity20 : AppCompatActivity() {


    var nameList = listOf(
        "Hossain",
        "Tariqul",
        "Rasel",
        "Al mamun",
        "Bayezid",
        "Hossain",
        "Tariqul",
        "Rasel",
        "Al mamun",
        "Bayezid",
        "Hossain",
        "Tariqul",
        "Rasel",
        "Al mamun",
        "Bayezid"
    )

    lateinit var adapter: NameAdapter

    lateinit var binding: ActivityMain20Binding
 //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain20Binding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NameAdapter()
        adapter.submitList(nameList)
        binding.nameRcv.adapter = adapter


    }
}