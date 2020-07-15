package com.example.secondapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ViewPersona(val EsborrarPersona: Unit) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_persona)
        val textNom = findViewById<TextView>(R.id.NomExtend)
        val textCognom = findViewById<TextView>(R.id.cognomExtend)
        val textAltura = findViewById<TextView>(R.id.AlturaExtend)
        val textEdat = findViewById<TextView>(R.id.Edat)
        val mail = findViewById<TextView>(R.id.mailExtend)
        val casat = findViewById<TextView>(R.id.casatExtend)
        val persona = intent.extras!!.get("KeyPersona") as Persona
        val esborrar = findViewById<Button>(R.id.ButtonDelete)
        textNom.setText(persona.nombre)
        textEdat.setText(persona.Edat.toString())
        textCognom.setText(persona.Apellido)
        textAltura.setText(persona.Altura.toString())
        textEdat.setText(persona.Edat.toString())
        mail.setText(persona.mail)
        casat.setText(persona.Casat.toString())
        esborrar.setOnClickListener {
            EsborrarPersona(persona)
        }
    }



}

