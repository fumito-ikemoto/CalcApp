package jp.techacademy.fumito.ikemoto.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

enum class Calculation
{
    Sum,
    Minus,
    Times,
    Divided
}

class MainActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sumButton.setOnClickListener(this)
        minusButton.setOnClickListener(this)
        timesButton.setOnClickListener(this)
        dividedButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id)
        {
            R.id.sumButton -> transitResult(Calculation.Sum)
            R.id.minusButton -> transitResult(Calculation.Minus)
            R.id.timesButton -> transitResult(Calculation.Times)
            R.id.dividedButton -> transitResult(Calculation.Divided)
            else -> return
        }
    }

    private fun transitResult(calc : Calculation)
    {
        //空文字判定
        if(editText1.text.toString().isEmpty() || editText2.text.toString().isEmpty())
        {
            return
        }

        val intent = Intent(this, ResultActivity::class.java)
        //結果表示のための値準備
        val num1: Double = editText1.text.toString().toDouble()
        val num2: Double = editText2.text.toString().toDouble()
        intent.putExtra("num1", num1)
        intent.putExtra("num2", num2)
        intent.putExtra("calc", calc)
        startActivity(intent)
    }
}
