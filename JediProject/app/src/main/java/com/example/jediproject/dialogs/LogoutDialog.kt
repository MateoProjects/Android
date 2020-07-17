package com.example.jediproject.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import com.example.firstaplication.MainActivity
import com.example.jediproject.R

class LogoutDialog {
    fun newInstance (context: Context, activity: Activity) : AlertDialog {
        val dialog: AlertDialog.Builder = AlertDialog.Builder(context)
        dialog.setIcon(R.drawable.exit_icon)
        dialog.setTitle(R.string.logout)
        dialog.setMessage(R.string.logout_message)
        dialog.setPositiveButton(R.string.si) { wich, dialog->
            val sharedPref = (activity as MainActivity).getPreferences(Context.MODE_PRIVATE)
            sharedPref?.edit()?.putString("NAME" , "default_value")?.apply()
            (activity as MainActivity).register()
        }
        dialog.setNegativeButton(R.string.no) { dialog, wichButton -> dialog.dismiss()
        }
        dialog.setCancelable(false)
        return dialog.create()
    }
}