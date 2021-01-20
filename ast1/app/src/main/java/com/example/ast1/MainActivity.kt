package com.example.ast1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.ast1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var count = 10;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            toastButton.setOnClickListener { toast() }
            countUpButton.setOnClickListener{ countUp() }
            countDownButton.setOnClickListener{ countDown() }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.let{
            count = it.get("count") as Int
            refreshCount()
        }
    }

    private fun toast() {
        Toast.makeText(this, count.toString(), Toast.LENGTH_SHORT).show()
    }
    private fun countUp() {
        count++
        refreshCount()
    }
    private fun countDown() {
        count--
        refreshCount()
    }

    private fun refreshCount() {
        binding.countText?.text = count.toString()
    }
}