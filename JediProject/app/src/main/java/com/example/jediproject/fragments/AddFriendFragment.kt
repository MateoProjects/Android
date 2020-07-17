package com.example.jediproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.firstaplication.MainActivity
import com.example.jediproject.R
import com.example.jediproject.classes.Friend
import com.example.jediproject.classes.friendDB
import com.example.jediproject.dialogs.ErrorRegisterFriend
import com.google.android.material.textfield.TextInputEditText


class AddFriendFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_friend, container, false)
        val nom = view.findViewById<TextInputEditText>(R.id.nom_input)
        val cognom = view.findViewById<TextInputEditText>(R.id.cognom_input)
        val edat = view.findViewById<TextInputEditText>(R.id.edat_input)
        val videojoc = view.findViewById<TextInputEditText>(R.id.videojoc_input)
        val button_reg = view.findViewById<Button>(R.id.register_friend_button)

        button_reg.setOnClickListener {

            if(nom.text.isNullOrBlank() or cognom.text.isNullOrBlank() or edat.text.isNullOrBlank() or videojoc.text.isNullOrBlank()) {
                ErrorRegisterFriend().newInstance(view!!.context, activity!!).show()
            }

            else {
                friendDB.addFriend(Friend(nom.text.toString(), cognom.text.toString() , edat.text.toString().toInt() , videojoc.text.toString()))
                (activity as MainActivity).friends()
            }

        }

        return view
    }


}