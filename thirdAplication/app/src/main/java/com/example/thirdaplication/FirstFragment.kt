package com.example.thirdaplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //var  view = supportFragmentManager.beginTransaction().replace(R.id.fragmentSecond, SecondFragment()).commit()
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val button = view.findViewById<Button>(R.id.ButtonSecond)
        button.setOnClickListener {
            (activity as MainActivity).secondFragment(fragmentParameter(view.findViewById<EditText>(R.id.textEditFirstFragment).text.toString()))
        }
        return view
    }


    fun fragmentParameter(string: String) : SecondFragment {
        val fragment: SecondFragment = SecondFragment()
        val arguments = Bundle()
        arguments.putString("KEY" , string)
        fragment.arguments = arguments
        return fragment
    }

}