package com.example.jediproject.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import com.example.firstaplication.MainActivity
import com.example.jediproject.R

class CorrectDeleteDialog {
    fun newInstance (context: Context, activity: Activity) : AlertDialog {
        val dialog: AlertDialog.Builder = AlertDialog.Builder(context)
        dialog.setTitle(R.string.alert)
        dialog.setMessage(R.string.correct_delete_text)
        dialog.setPositiveButton(R.string.ok) { wich, dialog->(activity as MainActivity).friends()
        }

        dialog.setCancelable(false)
        return dialog.create()
    }
}