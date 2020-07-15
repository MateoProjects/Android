package com.example.firstaplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculadoraFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calculadora, container, false)
        super.onCreate(savedInstanceState)
        val myBtn = view.findViewById<Button>(R.id.Back)
        val number1 = view.findViewById<EditText>(R.id.number1)
        val number2 = view.findViewById<EditText>(R.id.number2)
        val calcul = view.findViewById<Button>(R.id.calcul)
        val result = view.findViewById<TextView>(R.id.sortida)

        myBtn.setOnClickListener {
            (activity as MainActivity).mainActivity()
        }


        calcul.setOnClickListener{
            if(number1.text.isEmpty() or number2.text.isEmpty()) result.setText("ERROR")
            else {
                result.setText((number1.text.toString().toInt() + number2.text.toString().toInt()).toString())
            }

        }
        return  view
    }


}