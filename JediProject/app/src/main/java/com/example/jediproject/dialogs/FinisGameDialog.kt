package com.example.jediproject.dialogs
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import com.example.firstaplication.MainActivity
import com.example.jediproject.R

class FinisGameDialog {

    fun newInstance (context: Context, activity: Activity) : AlertDialog {
        val dialog: AlertDialog.Builder = AlertDialog.Builder(context)
        dialog.setIcon(R.drawable.exit_icon)
        dialog.setTitle(R.string.win)
        dialog.setMessage(R.string.replay_game)
        dialog.setPositiveButton(R.string.ok) {wich, dialog->
            (activity as MainActivity).cardGame()
        }

        dialog.setNegativeButton(R.string.no) { wich, dialog->
            (activity as MainActivity).mainActivity()
        }
        dialog.setCancelable(false)
        return dialog.create()
    }
}
