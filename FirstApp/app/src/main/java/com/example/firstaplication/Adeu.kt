package com.example.firstaplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Adeu : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adeulayout)
        val myBtn = findViewById<Button>(R.id.Back)
        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val calcul = findViewById<Button>(R.id.calcul)
        val result = findViewById<TextView>(R.id.sortida)

        myBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {}
            startActivity(intent)        }


        calcul.setOnClickListener{
            if(number1.text.isEmpty() or number2.text.isEmpty()) result.setText("ERROR")
            else {
               result.setText((number1.text.toString().toInt() + number2.text.toString().toInt()).toString())
            }

        }



    }

}
