package com.example.petfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun add (view: View?) {
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    }
    fun toMyList (view: View?) {
        val intent = Intent(this, MyListActivity::class.java)
        startActivity(intent)
    }
}