package com.example.firstaplication

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast

class BackDialog {

    fun newInstance (context: Context , activity: CartaView) : AlertDialog {
        val dialog: AlertDialog.Builder = AlertDialog.Builder(context)
        dialog.setIcon(R.drawable.exit_icon)
        dialog.setTitle(R.string.Exit)
        dialog.setMessage(R.string.TextBack)
        dialog.setPositiveButton(R.string.YES)  { wich, dialog->
            activity.finish()
        }

        // pending
        dialog.setNegativeButton(R.string.NO) { wich, dialog->
            Toast.makeText(context, "Denegado" , Toast.LENGTH_LONG).show()
        }
        dialog.setCancelable(false)
        return dialog.create()
    }
}