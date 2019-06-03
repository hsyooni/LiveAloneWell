package com.sy.livealonewell

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cooking")
data class Cooking (
    @PrimaryKey val menu: String,
    val time: Int,
    val supplies: String,
    val recipe: String
)


