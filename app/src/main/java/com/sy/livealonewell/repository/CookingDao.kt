package com.sy.livealonewell.repository


import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.sy.livealonewell.Cooking

@Dao
interface CookingDao {

    @Insert
    fun insertCooking(item: Cooking)

    @Delete
    fun deletedCooking(item: Cooking)

    @Query("SELECT*FROM Cooking")
    fun getCooking(): List<Cooking>

    @Query("SELECT *FROM Cooking WHERE menu = :menu")
    fun getStudent(menu: String):Cooking?
}