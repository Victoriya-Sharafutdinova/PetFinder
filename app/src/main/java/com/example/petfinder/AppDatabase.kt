package com.example.petfinder

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.petfinder.dao.AdDao
import com.example.petfinder.entity.Ad

@Database(entities = [Ad::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun adDao(): AdDao

    companion object {
        var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null){
                synchronized(AppDatabase::class){
                    instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "petfinder")
                        .build()
                }
            }
            return instance
        }

        fun destroyDataBase(){
            instance = null
        }
    }
}