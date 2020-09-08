package com.example.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_1.setOnClickListener { viewModel.setTextCalcHead(btn_1.text.toString()) }
        btn_2.setOnClickListener { viewModel.setTextCalcHead(btn_2.text.toString()) }
        btn_3.setOnClickListener { viewModel.setTextCalcHead(btn_3.text.toString()) }
        btn_4.setOnClickListener { viewModel.setTextCalcHead(btn_4.text.toString()) }
        btn_5.setOnClickListener { viewModel.setTextCalcHead(btn_5.text.toString()) }
        btn_6.setOnClickListener { viewModel.setTextCalcHead(btn_6.text.toString()) }
        btn_sum.setOnClickListener { viewModel.btnSum() }
        btn_result.setOnClickListener { viewModel.btnRes() }
        btn_clean.setOnClickListener { viewModel.btnClean() }

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        viewModel.liveData.observe(this, { it: String -> calc_head.text = it })
    }
}

