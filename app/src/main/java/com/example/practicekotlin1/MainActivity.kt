package com.example.practicekotlin1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() { // AppCompatActivity 상속

    /*
    '?'와 '!'의 차이점
    '?'는 Null 값이 될 수 있다는 것을 의미하고
    '!'는 Null 값이 될 수 없다는 것을 의미함. (값을 무조건 반환한다.)
     */

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
        buttonCheck.setOnClickListener {  //Kotlin의 경우 인터페이스를 람다 형식으로 치환하여 바로 사용할 수 있다.
            if (editTextHeight.text.isEmpty() || editTextWeight.text.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 부분이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height: Int = editTextHeight.text.toString().toInt()
            val weight: Int = editTextWeight.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)
        }
    }
}