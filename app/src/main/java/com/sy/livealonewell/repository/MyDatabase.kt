package com.sy.livealonewell.repository

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.sy.livealonewell.Cooking

@Database(entities = [Cooking::class], version =1)
abstract class MyDatabase: RoomDatabase(){

    abstract val CookingDao: CookingDao

    companion object {
        fun getInstance(context: Context): MyDatabase{
            return Room.databaseBuilder(context,
                MyDatabase::class.java,
                "mydb.db")
                .build()
        }
    }
}