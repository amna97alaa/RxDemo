package com.example.myapplication2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.core.Observable
import com.example.myapplication2.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val TAG="Amna"
    var clickCount by Delegates.notNull<Int>()
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i(TAG,"oncreate")
        clickCount=0
        binding.navigate.setOnClickListener {
            observable.take(1).subscribe {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
        }
        binding.add.setOnClickListener {
            clickCount++
            observable.onNext(clickCount)

        }
    }
   companion object{
       var observable=BehaviorSubject.create<Int>()
   }
}