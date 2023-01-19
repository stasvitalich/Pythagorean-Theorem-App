package com.example.pythagoreantheorem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.pythagoreantheorem.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding


    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

    }

    fun onClick(view: View) {
        if (!isEmpty()) {
            var result = calculate()
            bindingClass.resultText.text = result
        }
    }

    private fun isEmpty(): Boolean {
        bindingClass.apply {
            if (valueAtext.text.isNullOrEmpty()) valueAtext.error = "The field must be filled in"
            if (valueBtext.text.isNullOrEmpty()) valueBtext.error = "The field must be filled in"
            return (valueAtext.text.isNullOrEmpty() || valueBtext.text.isNullOrEmpty())
        }
    }

    private fun calculate(): String {

        var a: Double
        var b: Double

        bindingClass.apply {
            a = valueAtext.text.toString().toDouble()
            b = valueBtext.text.toString().toDouble()

            var c = sqrt(a.pow(2) + b.pow(2))
            var roundedC = round(c * 1000) / 1000
            var result = roundedC.toString()
            return "C ≈ $result"
        }
    }


}

