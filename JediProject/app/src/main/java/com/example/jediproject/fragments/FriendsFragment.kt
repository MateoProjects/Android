package com.example.jediproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstaplication.MainActivity
import com.example.jediproject.R
import com.example.jediproject.classes.*
import io.realm.Realm


class FriendsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var  adapter : FriendAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val realm: Realm = Realm.getDefaultInstance()
        adapter = FriendAdapter(this::onFriendClick, context = context!!)
        val view =  inflater.inflate(R.layout.fragment_friends, container, false)
        super.onCreate(savedInstanceState)
        recyclerView = view!!.findViewById(R.id.recyclearViewFriends)
        recyclerView.layoutManager = LinearLayoutManager(context!!)
        recyclerView.addItemDecoration(DividerItemDecoration(context!!, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
        adapter.setData(friendDB.getAll())
        val text = view.findViewById<TextView>(R.id.text_friends_buit)
        val image = view.findViewById<ImageView>(R.id.no_friends)
        val addFriend = view.findViewById<Button>(R.id.AddFriend)
        val deletfriend = view.findViewById<Button>(R.id.DeleteFriend)

        // ---- Enablers Listeners ---- //
        addFriend.setOnClickListener {
            (activity as MainActivity).addFriends()
        }
        deletfriend.setOnClickListener {
            (activity as MainActivity).deleteFriends()
        }
        // ---- End listeners ---- //

        // ---- Comprovacio size friends ---- //
        if(friendDB.getAll().isEmpty()) {
            text.visibility = View.VISIBLE
            image.visibility = View.VISIBLE
        }

        else {
            text.visibility = View.INVISIBLE
            image.visibility = View.INVISIBLE
        }
        realm.where(Friend::class.java)
            .findAllAsync()
            .addChangeListener { Friend ->
                println(Friend)
            }

        // ---- end comprovacio ---- //
        return view
    }

    fun onFriendClick(friend:Friend) {
        (activity as MainActivity).viewFriend(friend)
    }

}