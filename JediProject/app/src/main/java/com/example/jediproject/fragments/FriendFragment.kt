package com.example.jediproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.firstaplication.MainActivity
import com.example.jediproject.R
import com.example.jediproject.classes.Friend
import com.example.jediproject.dialogs.ConfirmDeleteFriendDialog

class FriendFragment(friend: Friend) : Fragment() {

    val friend = friend
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_friend, container, false)
        val nom = view.findViewById<TextView>(R.id.nom_view_friend)
        val cognom = view.findViewById<TextView>(R.id.cognom_view_friend)
        val edat = view.findViewById<TextView>(R.id.edat_view_friend)
        val joc = view.findViewById<TextView>(R.id.videojoc_view_friend)
        val buttonBack = view.findViewById<Button>(R.id.back_to_list_friends)
        val buttonDelete = view.findViewById<Button>(R.id.delete_friend_view)
        nom.text = friend.name
        cognom.text = friend.Cognom
        edat.text = friend.edat.toString()
        joc.text = friend.videojoc

        buttonBack.setOnClickListener {
            (activity as MainActivity).friends()
        }

        buttonDelete.setOnClickListener {
            ConfirmDeleteFriendDialog(friend).newInstance(view.context, activity!!).show()
        }


        return view
    }


}