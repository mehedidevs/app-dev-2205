package com.mehedi.esappdev2205

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.mehedi.esappdev2205.databinding.ActivityPlayBinding
import java.util.concurrent.TimeUnit

class PlayActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlayBinding
    var quizList = listOf<Quiz>(
        Quiz("i love you", "basi", "basi na", "jani na", "bolbo na", "basi"),
        Quiz("Victory day of bangladesh", "16 dec", "26 mar", "21 feb", "14 feb", "16 dec"),
        Quiz("Independence day of bangladesh", "16 dec", "26 mar", "21 feb", "14 feb", "26 mar"),
        Quiz(
            "International mother language day of bangladesh",
            "16 dec",
            "26 mar",
            "21 feb",
            "14 feb",
            "21 feb"
        ),
        Quiz("Valentine day of the universe", "16 dec", "26 mar", "21 feb", "14 feb", "14 feb"),


        )

    var updateQuestionNO = 1
    var milisLeftSec = 30000L

    var countDownTimer: CountDownTimer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.countTv.text = "$updateQuestionNO/${quizList.size}"
        startCountdownTimer()


    }

    private fun startCountdownTimer() {
        countDownTimer = object : CountDownTimer(milisLeftSec, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                milisLeftSec = millisUntilFinished
                val second = TimeUnit.MILLISECONDS.toSeconds(milisLeftSec).toInt()

                binding.timerTv.text = "Time Left : $second"


            }

            override fun onFinish() {

            }

        }.start()


    }
}