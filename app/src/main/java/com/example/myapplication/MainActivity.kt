package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.CounterModel
import com.example.myapplication.model.View.CounterView
import com.example.myapplication.model.presenter.Presenter

class MainActivity : AppCompatActivity(), CounterView {
    private lateinit var binding: ActivityMainBinding
    private var count = 0
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
            if (binding.tvCounter.text.equals("10")) {
                Toast.makeText(this@MainActivity, "Поздравляем", Toast.LENGTH_SHORT).show()
            }
            else if(binding.tvCounter.text.equals("15")){
                textColor()
            }

        }
        binding.decriment.setOnClickListener {
            presenter.decreament()
            if (binding.tvCounter.text.equals("10")) {
                Toast.makeText(this@MainActivity, "Поздравляем", Toast.LENGTH_SHORT).show()
            }
            else if(binding.tvCounter.text.equals("15")){
                textColor()
            }

        }
    }

    override fun updateCounterView(model: Int) {
        binding.tvCounter.text = model.toString()
    }

    override fun changeColor(color: Int) {
        binding.tvCounter.setTextColor(color)
    }

    private fun textColor() {
        presenter.changeColor()


    }

}