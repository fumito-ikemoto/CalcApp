package jp.techacademy.fumito.ikemoto.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_result.*
import kotlin.math.log

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val num1 = intent.getDoubleExtra("num1", 0.0)
        val num2 = intent.getDoubleExtra("num2", 0.0)
        val calc = intent.getSerializableExtra("calc")

        var result = 0.0
        when(calc)
        {
            Calculation.Sum -> result = num1 + num2
            Calculation.Minus -> result = num1 - num2
            Calculation.Times -> result = num1 * num2
            Calculation.Divided -> result = num1 / num2
        }

        resultText.text = result.toString()
    }
}