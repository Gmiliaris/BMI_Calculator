package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

                println("Gustavo" + score)
            }
        }

    }
}