package com.example.myapplication.model.presenter

import com.example.myapplication.model.CounterModel
import com.example.myapplication.model.TextColorModel
import com.example.myapplication.model.ToastModel
import com.example.myapplication.model.View.CounterView

class Presenter {
    val model = CounterModel()
    val toastModel = ToastModel()
    val colorModel = TextColorModel()
    private lateinit var view: CounterView

    fun increament() {
        model.increament()

        view.updateCounterView(model.getCounter())
    }

    fun decreament() {
        model.decreament()
        view.updateCounterView(model.getCounter())
    }

    fun attachView(view: CounterView) {
        this.view = view
    }

    fun changeColor() {

        view.changeColor(colorModel.getColor())
    }

    fun getMessage(): String {
        view.showToast(toastModel.getMessage())
        return toastModel.getMessage()
    }


}