package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import android.text.Html
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.tv_BMI)
        textView.text = HtmlCompat.fromHtml(getString(R.string.bmi_text), HtmlCompat.FROM_HTML_MODE_LEGACY)
        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)

        btnCalculate.setOnClickListener {
            val WeightStr: String = edtWeight.text.toString()
            val HeightStr: String = edtHeight.text.toString()

            if (WeightStr ==""|| HeightStr == ""){
                Snackbar
                    .make(
                    edtWeight,
                    "Fill in all the fields",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {
                val weight = WeightStr.toFloat()
                val height = HeightStr.toFloat()
                val heightQ2 = height * height
                val score = weight / heightQ2

                val intent = Intent( this, ResultActivity::class.java)
                intent.putExtra(KEY_BMI_RESULT, score)
                startActivity(intent)
            }
        }

    }
}