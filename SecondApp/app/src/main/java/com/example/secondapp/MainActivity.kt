package com.example.secondapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var  recyclerView:RecyclerView
    private val adapter : PersonaAdapter = PersonaAdapter(context = this , onPersonClick = this::bindPersonOnClick)
    private lateinit var personasEmptyView: LinearLayout
    val list =  listOf(Persona("ramon" , "mateo", 25 , 1.85F , "Ramon" , Casat = false),
        Persona("Nav" , "mat", 19 , 1.45F, "Ramon" , false),
        Persona("Eduard" , "Garcia" , 22, 1.7F, "Ramon" , false))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerViewTest)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter.setData(list)
        personasEmptyView = findViewById(R.id.personasEmpty)
        val button = findViewById<View>(R.id.more)
        button.setOnClickListener() {
            val intent = Intent(this , AddPerson::class.java)
            startActivity(intent)
        }
        updatePersonList()
    }

    private fun updatePersonList() {
        if(list.isEmpty()) {
            personasEmptyView.visibility = View.VISIBLE
        }
        else {
            personasEmptyView.visibility = View.INVISIBLE
        }
    }

    fun bindPersonOnClick(person:Persona){
        Toast.makeText(this , "Hola " + person.nombre , Toast.LENGTH_SHORT).show()
        val intent = Intent(this , ViewPersona(EsborrarPersona(person))::class.java)
        intent.putExtra("KeyPersona" , person)
        startActivity(intent)
    }

    fun EsborrarPersona(person: Persona) {

    }







}