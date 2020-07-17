package com.example.jediproject.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.firstaplication.MainActivity
import com.example.jediproject.R
import com.example.jediproject.dialogs.ErrorRegisterDialog
import com.google.android.material.textfield.TextInputEditText


class RegisterFragment : Fragment() {
    private  var textRegister: TextInputEditText? = null
    private  var ButtonRegister : Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        ButtonRegister = view.findViewById(R.id.ButtonRegister)
        textRegister = view.findViewById(R.id.registerInput)
        setListener()
        return view
    }



    fun setListener() {
        ButtonRegister?.setOnClickListener {
            val name = textRegister?.findViewById<TextInputEditText>(R.id.registerInput)?.text
            if(name.isNullOrBlank()) {
               ErrorRegisterDialog()
                   .newInstance(view!!.context, activity!!).show()
            }

            else {
                val sharedPref = this.activity?.getPreferences(Context.MODE_PRIVATE)
                sharedPref?.edit()?.putString("NAME" , name.toString())?.apply()
                (activity as MainActivity).mainActivity()            }
        }
    }
}


