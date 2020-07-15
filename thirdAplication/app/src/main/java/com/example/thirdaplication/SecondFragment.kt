package com.example.thirdaplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val button = view.findViewById<Button>(R.id.ButtonFirst)
        button.setOnClickListener{
            (activity as MainActivity).firstFragment()

        }

        if(arguments != null && arguments!!.getString("KEY").toString().isNotBlank()) {
            Toast.makeText(view.context, arguments!!.getString("KEY").toString() , Toast.LENGTH_SHORT).show()
        }

            return view
    }


}

