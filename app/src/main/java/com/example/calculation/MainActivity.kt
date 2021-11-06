package com.example.calculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand: Double = 0.0
    private var operation: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberClick(clickedView: View) {
        if (clickedView is TextView) {
            var result = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if (result == "0") {
                result = " "
            }
            resultTextView.text = result + number
        }

    }

    fun operationClick(clickedView: View) {
        if (clickedView is TextView) {
            val result: String = resultTextView.text.toString()

            if (result.isNotEmpty()) {
                this.operand = result.toDouble()
            }

            this.operation = clickedView.text.toString()

            resultTextView.text = " "

        }
    }

    fun equalsClick(clickedView: View) {
        if (clickedView is TextView) {
            val secondOperandText = resultTextView.text.toString()
            var secondOperand: Double = 0.0

            if (secondOperandText.isNotEmpty()) {
                secondOperand = secondOperandText.toDouble()

            }
            when (operation) {
                "+" -> resultTextView.text = (operand + secondOperand).toString()
                "-" -> resultTextView.text = (operand - secondOperand).toString()
                "*" -> resultTextView.text = (operand * secondOperand).toString()
                "/" -> resultTextView.text = (operand / secondOperand).toString()
                "X²"-> resultTextView.text = ( operand * operand).toString()
            }

        }

    }

    fun deleteClick(clickedView: View) {
        val text = resultTextView.text.toString()
        if (text.isNotEmpty()) {
            resultTextView.text = text.dropLast(1)
        }
    }

}