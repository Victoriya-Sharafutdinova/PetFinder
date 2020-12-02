package com.example.petfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    private var adService: AdService = AdService.instance!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        addAd()
    }

    fun toMain (view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun addAd() {
        buttonAdd.setOnClickListener {
            val type = toggleButtonType.text.toString()
            val pet = editTextPet.text.toString()
            val name = editTextName.text.toString()
            val breed = editTextBreed.text.toString()
            val address = editTextAddress.text.toString()
            val date = calendarView.date.toString()
            val comment = editTextComment.text.toString()
            try {
                adService.addAd(
                    Type = type,
                    Pet = pet,
                    Name = name,
                    Breed = breed,
                    Address = address,
                    Date = date,
                    Comment = comment
                )
            } catch (ex: java.lang.Exception) {
                textView.text = "Ошибка добавления"
                return@setOnClickListener
            }
            finish()
            val toMain = Intent(this, MainActivity::class.java)
            startActivity(toMain)
        }

    }

}