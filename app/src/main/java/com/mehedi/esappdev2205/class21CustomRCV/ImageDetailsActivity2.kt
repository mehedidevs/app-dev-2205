package com.mehedi.esappdev2205.class21CustomRCV

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import coil.load

import com.mehedi.esappdev2205.databinding.ActivityImageDetails2Binding

class ImageDetailsActivity2 : AppCompatActivity() {


    private lateinit var binding: ActivityImageDetails2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityImageDetails2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val image = intent.getSerializableExtra("img") as Image


      //  binding.fullImage.load(intent.getStringExtra("img"))
        binding.fullImage.load(image?.imageUrl)

        binding.imageName.text = intent.getStringExtra("name")


    }

}