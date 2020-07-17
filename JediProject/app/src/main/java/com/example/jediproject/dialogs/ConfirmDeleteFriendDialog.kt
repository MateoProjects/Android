package com.example.jediproject.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import com.example.firstaplication.MainActivity
import com.example.jediproject.R
import com.example.jediproject.classes.Friend
import com.example.jediproject.classes.estadistiquesDb
import com.example.jediproject.classes.friendDB
import io.realm.Realm
import kotlin.system.exitProcess

class ConfirmDeleteFriendDialog(friend: Friend) {
    val realm: Realm = Realm.getDefaultInstance()
    val friend = friend
    fun newInstance (context: Context, activity: Activity) : AlertDialog {
        val dialog: AlertDialog.Builder = AlertDialog.Builder(context)
        dialog.setTitle(R.string.alert)
        dialog.setMessage(R.string.text_delete_friend)
        dialog.setPositiveButton(R.string.ok) { wich, dialog -> deleteFriend(activity) }
        dialog.setNegativeButton(R.string.no) { dialog, wichButton-> dialog.dismiss()
        }

        dialog.setCancelable(true)
        return dialog.create()

    }
        fun deleteFriend(activity: Activity) {
            friendDB.deleteFriend(friend.name, friend.Cognom)
            (activity as MainActivity).friends()
        }
}


