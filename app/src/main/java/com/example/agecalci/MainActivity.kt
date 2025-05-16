package com.example.agecalci

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val yearEditText = findViewById<EditText>(R.id.yearEditText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val userDOB = yearEditText.text.toString().trim()
            val currentYear = Calendar.getInstance().get(Calendar.YEAR)

            // Input validation
            if (userDOB.isEmpty()) {
                Toast.makeText(this, "Please enter your birth year", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val birthYear = userDOB.toIntOrNull()
            if (birthYear == null) {
                Toast.makeText(this, "Enter a valid year (numbers only)", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (birthYear > currentYear) {
                Toast.makeText(this, "Year cannot be in the future", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Calculate and display age
            val age = currentYear - birthYear
            resultTextView.text = "Your age is $age years"
        }
    }
}
