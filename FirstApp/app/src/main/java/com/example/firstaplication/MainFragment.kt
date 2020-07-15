package com.example.firstaplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*


class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val myBtn = view.findViewById<Button>(R.id.myBtn)
        val swap = view.findViewById<Button>(R.id.swap)
        val image = view.findViewById<ImageView>(R.id.imageView2)
        val galery = view.findViewById<Button>(R.id.Galery)
        var bool: Boolean = false

        val estadistiques = view.findViewById<Button>(R.id.estadisticas)

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
            (activity as MainActivity).cardGame()
        }

        estadistiques.setOnClickListener{
            (activity as MainActivity).estadistiques()
        }

        myBtn.setOnClickListener {
            (activity as MainActivity).calculadora()
        }

        return view


    }



}