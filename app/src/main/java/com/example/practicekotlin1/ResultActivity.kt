package com.example.practicekotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    private val textViewBmi: TextView by lazy {
        findViewById(R.id.textViewBmi)
    }

    private val textViewResult: TextView by lazy {
        findViewById(R.id.textViewResult)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        val bmi = weight / (height * 0.01).pow(2.0)
        val result = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상 체중"
            else -> "저체중"
        }

        textViewBmi.text = bmi.toString()
        textViewResult.text = result
    }
}