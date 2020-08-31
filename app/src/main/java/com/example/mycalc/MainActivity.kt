package com.example.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_1.setOnClickListener { setTextCalcHead("1") }
        btn_2.setOnClickListener { setTextCalcHead("2") }
        btn_3.setOnClickListener { setTextCalcHead("3") }
        btn_4.setOnClickListener { setTextCalcHead("4") }
        btn_5.setOnClickListener { setTextCalcHead("5") }
        btn_6.setOnClickListener { setTextCalcHead("6") }

        btn_sum.setOnClickListener { setTextCalcHead("+") }
        btn_clean.setOnClickListener {
            val str = calc_head.text.toString()
            if (str.isNotEmpty()) {
                calc_head.text = str.substring(0, str.length - 1)
            }
        }
        btn_result.setOnClickListener {
            try {
                val ex = ExpressionBuilder(calc_head.text.toString()).build()
                val result = ex.evaluate()
                calc_head.text = result.toString()

            } catch (e: Exception) {
                Log.d("Error:", "${e.message}")
            }
        }
    }

    private fun setTextCalcHead(str: String) {
        calc_head.append(str);
    }

}