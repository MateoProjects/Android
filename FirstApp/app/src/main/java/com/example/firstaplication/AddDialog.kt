package com.example.firstaplication

import android.app.Dialog
import android.content.Context
import android.widget.Button
import android.widget.TextView

class AddDialog {

        companion object {
            fun buildDialog(
                context: Context
            ): Dialog {

                val dialog = Dialog(context)
                dialog.setContentView(R.layout.dialoglayoutwin)
                val okButton = dialog.findViewById<Button>(R.id.ok)
                okButton.setOnClickListener {
                    dialog.dismiss()
                }

                return dialog
            }
        }

}