package com.example.petfinder

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.fragment.app.DialogFragment

class DialogComplaint: DialogFragment() {

    @NonNull
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        builder.setTitle("Внимание!")
        builder.setMessage("Вы действительно хотите оставить жалобу?")
        builder.setPositiveButton("Да") { _: DialogInterface, i: Int ->
            val intent = Intent(context, LostActivity::class.java)
            startActivity(intent)
        }
        builder.setNegativeButton("Отмена", null)
        return builder.create()

    }

}