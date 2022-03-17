package com.example.practicekotlin1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val editTextHeight: EditText by lazy {
        findViewById(R.id.editTextHeight)
    }

    private val editTextWeight: EditText by lazy {
        findViewById(R.id.editTextWeight)
    }

    private val buttonCheck: Button by lazy {
        findViewById(R.id.buttonCheck)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initCheckButton()
    }

    private fun initCheckButton() {
        buttonCheck.setOnClickListener {
            if (editTextHeight.text.isEmpty() || editTextWeight.text.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 부분이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height = editTextHeight.text.toString().toInt()
            val weight = editTextWeight.text.toString().toInt()

            val intent = Intent(this, ResultActivity:: class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)
        }
    }
}