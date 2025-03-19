package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_BMI_RESULT = "ResultActivity.KEY_BMI"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result = intent.getFloatExtra(KEY_BMI_RESULT, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassification = findViewById<TextView>(R.id.tv_classification)

        tvResult.text = result.toString()
        val classification: String = if (result <= 18.5f){
            "THIN"
        } else if (result > 18.5f && result <= 24.9f){
             "NORMAL"
        } else if (result > 25f && result <=29.9f){
             "OVERWEIGHT"
        } else if (result >30f && result <=39.9f){
             "OBESITY"
        }else {
             "SEVERE OBESITY"
        }

        tvClassification.text = classification
    }
}