package com.example.thirdaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstFragment()
    }

    fun secondFragment(fragment: SecondFragment) {

        supportFragmentManager.beginTransaction().replace(R.id.MainActivity,fragment).commit()
    }

    fun firstFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity, FirstFragment()).commit()
    }



}