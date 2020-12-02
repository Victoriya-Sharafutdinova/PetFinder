package com.example.petfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ComplaintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaint)
    }

    fun toLost (view: View?) {
        val intent = Intent(this, LostActivity::class.java)
        startActivity(intent)
    }
}