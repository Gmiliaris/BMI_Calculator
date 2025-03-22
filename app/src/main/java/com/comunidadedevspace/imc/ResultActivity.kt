package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_BMI_RESULT = "ResultActivity.KEY_BMI"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        window.statusBarColor = ContextCompat.getColor(this, R.color.primary_900)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result = intent.getFloatExtra(KEY_BMI_RESULT, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassification = findViewById<TextView>(R.id.tv_classification)

        tvResult.text = result.toString()
        val classification: String = when {
            result <= 18.5f -> "THIN"
            result in 18.6f..24.9f -> "NORMAL"
            result in 25f..29.9f -> "OVERWEIGHT"
            result in 30f..39.9f -> "OBESITY"
            else -> "SEVERE OBESITY"
        }

        tvClassification.text = classification
    }
}
