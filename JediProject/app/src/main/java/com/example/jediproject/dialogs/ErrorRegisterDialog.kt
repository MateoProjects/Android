package com.example.jediproject.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import com.example.firstaplication.MainActivity
import com.example.jediproject.R

class ErrorRegisterDialog {
    fun newInstance (context: Context, activity: Activity) : AlertDialog {
        val dialog: AlertDialog.Builder = AlertDialog.Builder(context)
        dialog.setIcon(R.drawable.exit_icon)
        dialog.setTitle(R.string.error_register)
        dialog.setMessage(R.string.error_register_message)
        dialog.setPositiveButton(R.string.ok) { wich, dialog->(activity as MainActivity).register()
        }

        dialog.setCancelable(false)
        return dialog.create()
    }
}