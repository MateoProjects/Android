package com.example.firstaplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myBtn = findViewById<Button>(R.id.myBtn)
        val swap = findViewById<Button>(R.id.swap)
        val image = findViewById<ImageView>(R.id.imageView2)
        val galery = findViewById<Button>(R.id.Galery)
        var bool: Boolean = false
        myBtn.setOnClickListener {
            val intent = Intent(this, Adeu::class.java)
            startActivity(intent)
        }

        swap.setOnClickListener {
            if(bool) {
                image.setImageResource(R.drawable.mount1)
                bool = !bool

            }
            else {
                image.setImageResource(R.drawable.mount2)
                bool = !bool
            }
        }

        galery.setOnClickListener{
            val intent = Intent(this , CartaView::class.java)
            startActivity(intent)
        }
    }



}