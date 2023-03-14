package com.mehedi.esappdev2205.upto15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mehedi.esappdev2205.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var skip = intent.getIntExtra("skip", 0)
        var correct = intent.getIntExtra("right", 0)
        var wrong = intent.getIntExtra("wrong", 0)
        var numOfQuestion = intent.getIntExtra("numofqs", 0)

        binding.showResult.text = "Number of Question : $numOfQuestion \n" +
                "skip : $skip\n" +
                "correct : $correct\n" +
                "wrong $wrong"


    }
}