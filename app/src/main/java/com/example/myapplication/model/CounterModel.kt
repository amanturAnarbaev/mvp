package com.example.myapplication.model

import android.content.Context
import android.widget.Toast

class CounterModel {
    private var counter = 0



    fun increament() {
        counter++

    }

    fun decreament() {
        counter--

    }

    fun getCounter(): Int {
        return counter
    }




//    fun showToast(message: String) {
//        val context : Context
//    }
//
//    fun Context.showToast(message: String) {
//        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
//    }
}



