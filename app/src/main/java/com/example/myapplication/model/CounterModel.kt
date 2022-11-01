package com.example.myapplication.model

class CounterModel {
    private var counter= 0

    fun increament (){
        counter++

    }
    fun decreament (){
        counter--

    }
    fun getCounter():Int{
        return counter
    }
}