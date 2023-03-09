package com.mehedi.esappdev2205

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import com.mehedi.esappdev2205.databinding.ActivityPlayBinding
import java.util.concurrent.TimeUnit

class PlayActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlayBinding
    var quizList = listOf<Quiz>(
        Quiz(
            "i love you",
            "basi",
            "basi na",
            "jani na",
            "bolbo na",
            "basi"
        ),
        Quiz(
            "Victory day of bangladesh",
            "16 dec",
            "26 mar",
            "21 feb",
            "14 feb",
            "16 dec"
        ),
        Quiz(
            "Independence day of bangladesh",
            "16 dec",
            "26 mar",
            "21 feb",
            "14 feb",
            "26 mar"
        ),
        Quiz(
            "International mother language day of bangladesh",
            "16 dec",
            "26 mar",
            "21 feb",
            "14 feb",
            "21 feb"
        ),
        Quiz(
            "Valentine day of the universe",
            "16 dec",
            "26 mar",
            "21 feb",
            "14 feb",
            "14 feb"
        )
    )

    var updateQuestionNO = 1
    var milisLeftSec = 30000L

    var qIndex = 0

    var countDownTimer: CountDownTimer? = null

    var hasFinished = false

    private var skip = 0
    var correct = 0
    var wrong = 0
//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initQuestion()

        binding.countTv.text = "$updateQuestionNO/${quizList.size}"
        startCountdownTimer()
        binding.nextButton.setOnClickListener {

            showNextQuestion()
        }


    }

    private fun initQuestion() {
        val quiz = quizList[qIndex]
        binding.apply {
            questionTV.text = quiz.question
            option1.text = quiz.option1
            option2.text = quiz.option2
            option3.text = quiz.option3
            option4.text = quiz.option4
        }


    }


    private fun showNextQuestion() {
        checkAnswer()

        binding.apply {

            if (updateQuestionNO < quizList.size) {
                updateQuestionNO++
                countTv.text = "$updateQuestionNO/${quizList.size}"
            }


            if (qIndex <= quizList.size - 1) {
                initQuestion()
            } else {
                hasFinished = true

            }

            quizGroup.clearCheck()


        }


    }

    private fun checkAnswer() {

        binding.apply {

            if (quizGroup.checkedRadioButtonId == -1) {
                skip++

            } else {
                val checkButton = findViewById<RadioButton>(quizGroup.checkedRadioButtonId)

                var checkAnswer = checkButton.text.toString()

                if (checkAnswer == quizList[qIndex].rightAnswer) {
                    correct++
                    scoreTv.text = "Score : $correct"
                    countDownTimer?.cancel()
                    showAlertDialog("Right Answer")


                } else {
                    wrong++
                    countDownTimer?.cancel()
                    showAlertDialog("Wrong Answer")

                }


            }
            if (qIndex <= quizList.size - 1) {
                qIndex++
            } else {
                showAlertDialog("Finished")


            }


        }


    }

    private fun startCountdownTimer() {
        countDownTimer = object : CountDownTimer(milisLeftSec, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                milisLeftSec = millisUntilFinished


                val second = TimeUnit.MILLISECONDS.toSeconds(milisLeftSec).toInt()

                binding.timerTv.text = "Time Left : $second"


            }

            override fun onFinish() {
                showNextQuestion()
            }

        }.start()


    }

    fun showAlertDialog(message: String) {

        val builder = AlertDialog.Builder(this)
        builder.setTitle(message)

        builder.setPositiveButton("OK", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {

                if (message == "Finished") {

                    countDownTimer?.cancel()

                    var intent = Intent(this@PlayActivity, ResultActivity::class.java)

                    intent.putExtra("skip", skip)
                    intent.putExtra("right", correct)
                    intent.putExtra("wrong", wrong)
                    intent.putExtra("numofqs", quizList.size)




                    startActivity(intent)

                }



                countDownTimer?.start()

            }

        })


        val alertDialog = builder.create()
        alertDialog.show()


    }


}