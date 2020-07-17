package com.example.jediproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.firstaplication.MainActivity
import com.example.jediproject.R
import com.example.jediproject.classes.estadistiquesDb
import com.example.jediproject.classes.friendDB
import com.example.jediproject.dialogs.CorrectDeleteDialog
import com.example.jediproject.dialogs.EmptyFriendDeleteDialog
import com.example.jediproject.dialogs.friendNotEexist
import com.google.android.material.textfield.TextInputEditText


class DeleteFriendFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_delete_friend, container, false)
        val name = view.findViewById<TextInputEditText>(R.id.nom_delete_input)
        val cognom = view.findViewById<TextInputEditText>(R.id.cognom_delete_input)
        val deleteButton = view.findViewById<Button>(R.id.deletefriend_button)
        deleteButton.setOnClickListener {
            if(name.text.isNullOrBlank() or cognom.text.isNullOrBlank()) {
                EmptyFriendDeleteDialog().newInstance(view!!.context, activity!!).show()
            }
            else if (friendDB.deleteFriend(name.text.toString(), cognom.text.toString())== false) {
                friendNotEexist().newInstance(view!!.context, activity!!).show()
            }

            else {
                CorrectDeleteDialog().newInstance(view!!.context, activity!!).show()
            }
        }
        return view
    }


}