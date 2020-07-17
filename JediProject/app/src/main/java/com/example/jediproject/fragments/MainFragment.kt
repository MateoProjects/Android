package com.example.jediproject.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.firstaplication.MainActivity
import com.example.jediproject.R


class MainFragment : Fragment() {

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val sharedPref = this.activity?.getPreferences(Context.MODE_PRIVATE)
        val buttonStart = view.findViewById<Button>(R.id.ButtonStartMain)
        val string =view.findViewById<TextView>(R.id.textMainPresentation)
        val name = sharedPref!!.getString("NAME" , "")
        string.text = string.text.toString().plus(" ").plus(name.toString())
        buttonStart.setOnClickListener {
            (activity as MainActivity).cardGame()
        }
        return view
    }


}