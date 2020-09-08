package com.example.mycalc

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var res: ArrayList<String> = ArrayList()
    private var sum: String = "0"
    private var textIn: String = ""
    val liveData = MutableLiveData<String>()

    fun btnSum() {
        res.add(sum)
        textIn += "+"
        liveData.postValue(textIn)
        sum = "0"
    }

    fun btnRes() {
        var i: Long = 0
        res.add(sum)
        if (res.isNotEmpty()){
        for (key in res) {
            i += key.toLong()
        }
        sum = i.toString()
        textIn = i.toString()
        liveData.postValue(textIn)
        res.clear()}
        else liveData.postValue("0")
    }


    fun btnClean() {
        res.clear()
        sum = ""
        textIn = ""
        liveData.postValue("0")
    }


    fun setTextCalcHead(str: String) {
        sum += str
        textIn += str
        liveData.postValue(textIn)
    }
}