package com.example.petfinder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MyListActivity : AppCompatActivity() {
    lateinit var myListAdapter: MyListAdapter
    private var myListService: MyListService = MyListService.instance!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_list)

        super.getSupportActionBar()?.hide()

        myListService.fillData()
        myListAdapter = MyListAdapter(this, myListService.myListItems)

        val lvMyList: ListView = findViewById(R.id.lvAds) as ListView
        lvMyList.setAdapter(myListAdapter)
    }
    fun toMain (view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun ad (view: View?) {
        val intent = Intent(this, LostActivity::class.java)
        startActivity(intent)
    }
}