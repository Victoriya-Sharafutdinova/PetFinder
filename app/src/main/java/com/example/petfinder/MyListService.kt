package com.example.petfinder

import android.content.Context
import com.example.petfinder.AppDatabase
import com.example.petfinder.entity.Ad
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MyListService (context: Context) {

    var appDatabase : AppDatabase? = AppDatabase.getInstance(context)
    var myListItems: ArrayList<MyListItem> = ArrayList()

    companion object {
        var instance: MyListService? = null
        fun getInstance(context: Context): MyListService? {
            if (instance == null){
                instance = MyListService(context)
            }
            return instance
        }
    }

    fun fillData() {
        myListItems = ArrayList()
        runBlocking {
            val reader = GlobalScope.launch {
                val list = appDatabase?.adDao()?.getAll()
                if (list != null) {
                    list.forEach {
                        myListItems.add(
                            MyListItem(
                                it.name,
                                it.address,
                                R.drawable.dog
                            )
                        )
                    }
                }
            }
            reader.join()
        }
    }


}