package com.example.secondapp

import android.annotation.SuppressLint
import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var  recyclerView:RecyclerView
    private val adapter : PersonaAdapter = PersonaAdapter(context = this , onPersonClick = this::bindPersonOnClick)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerViewTest)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.setData(listOf(Persona("ramon" , "mateo", 25 , 1.85F),
                               Persona("Nav" , "mat", 19 , 1.45F),
                               Persona("Eduard" , "Garcia" , 22, 1.7F)))

    }

    fun bindPersonOnClick(person:Persona){
        Toast.makeText(this , "Hola " + person.nombre , Toast.LENGTH_LONG).show()
    }
}