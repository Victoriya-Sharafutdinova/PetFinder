package com.example.petfinder.dao

import androidx.room.*
import com.example.petfinder.entity.Ad

@Dao
interface AdDao {
    @Query("SELECT * FROM ad")
    fun getAll(): List<Ad>

    @Query("SELECT * FROM ad WHERE adId = :id")
    fun getById(id: Long): Ad?

    @Insert
    fun insert(ad: Ad)

    @Update
    fun update(ad: Ad)

    @Delete
    fun delete(ad: Ad)
}