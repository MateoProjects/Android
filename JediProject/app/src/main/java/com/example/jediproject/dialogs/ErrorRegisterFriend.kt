package com.example.jediproject.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import com.example.firstaplication.MainActivity
import com.example.jediproject.R
import kotlinx.android.synthetic.main.fragment_friends.*

class ErrorRegisterFriend {

    fun newInstance (context: Context, activity: Activity) : AlertDialog {
        val dialog: AlertDialog.Builder = AlertDialog.Builder(context)
        dialog.setTitle(R.string.error_register)
        dialog.setMessage(R.string.error_register_friend)
        dialog.setPositiveButton(R.string.ok) { wich, dialog->(activity as MainActivity).addFriends()
        }

        dialog.setCancelable(false)
        return dialog.create()
    }
}