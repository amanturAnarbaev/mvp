package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.CounterModel
import com.example.myapplication.model.View.CounterView
import com.example.myapplication.model.presenter.Presenter
import com.example.myapplication.model.presenter.showToast

class MainActivity : AppCompatActivity(), CounterView {
    private lateinit var binding: ActivityMainBinding

    val model = CounterModel()
    private val presenter = Presenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.attachView(this)

        onClick()

    }

    private fun onClick() {

        binding.counter.setOnClickListener {
            presenter.increament()

            toast()
            textColor()


        }
        binding.decriment.setOnClickListener {
            presenter.decreament()
            toast()
            textColor()


        }
    }

    override fun updateCounterView(model: Int) {
        binding.tvCounter.text = model.toString()
    }

    override fun changeColor(color: Int) {
        binding.tvCounter.setTextColor(color)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    private fun textColor() {
        if (binding.tvCounter.text.equals("15")) {
            presenter.changeColor()
        }

    }

    private fun toast() {
        if (binding.tvCounter.text.equals("10")) {
            presenter.getMessage()
        }

    }


}