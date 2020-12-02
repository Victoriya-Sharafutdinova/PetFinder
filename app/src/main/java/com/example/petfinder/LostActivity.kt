package com.example.petfinder

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class LostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lost)

        var adService = AdService.getInstance(this)
        var myListService = MyListService.getInstance(this)
    }
    fun complaintOpen (view: View?) {
        val intent = Intent(this, ComplaintActivity::class.java)
        startActivity(intent)
    }

    fun toMain (view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}