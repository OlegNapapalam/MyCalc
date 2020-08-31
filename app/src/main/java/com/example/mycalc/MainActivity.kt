package com.example.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var res: ArrayList<String> = ArrayList()
    private var sum: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_1.setOnClickListener { setTextCalcHead(btn_1.text as String) }
        btn_2.setOnClickListener { setTextCalcHead(btn_2.text as String) }
        btn_3.setOnClickListener { setTextCalcHead(btn_3.text as String) }
        btn_4.setOnClickListener { setTextCalcHead(btn_4.text as String) }
        btn_5.setOnClickListener { setTextCalcHead(btn_5.text as String) }
        btn_6.setOnClickListener { setTextCalcHead(btn_6.text as String) }

        btn_sum.setOnClickListener {
            res.add(sum)

            setTextCalcHead(btn_sum.text as String)
        }

        btn_result.setOnClickListener {
            var i:Int = 0
            res.add(sum)

            for (key in res) {
                i += key.toInt()
            }
            sum=i.toString()
            calc_head.text = i.toString()
            res.clear()
        }


        btn_clean.setOnClickListener {
            val str = calc_head.text.toString()
            if (str.isNotEmpty()) {
                calc_head.text = str.substring(0, str.length - 1)
            }
        }

    }

    private fun setTextCalcHead(str: String) {
        sum = if (str != "+") sum + str
        else ""

        calc_head.append(str)
    }

}