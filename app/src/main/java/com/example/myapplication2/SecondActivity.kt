package com.example.myapplication2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.myapplication2.MainActivity.Companion.observable
import com.example.myapplication2.databinding.ActivityMainBinding
import com.example.myapplication2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observable.subscribe {
            binding.textView.text = it.toString()
        }
    }
}