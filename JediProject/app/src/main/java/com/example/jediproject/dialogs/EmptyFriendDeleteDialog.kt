package com.example.jediproject.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import com.example.firstaplication.MainActivity
import com.example.jediproject.R

class EmptyFriendDeleteDialog {
    fun newInstance (context: Context, activity: Activity) : AlertDialog {
        val dialog: AlertDialog.Builder = AlertDialog.Builder(context)
        dialog.setTitle(R.string.error_delete_friend_tittle)
        dialog.setMessage(R.string.error_delete_friend_text)
        dialog.setPositiveButton(R.string.ok) { wich, dialog->(activity as MainActivity).deleteFriends()
        }

        dialog.setCancelable(false)
        return dialog.create()
    }
}