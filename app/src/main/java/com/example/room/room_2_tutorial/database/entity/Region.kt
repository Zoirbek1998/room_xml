package com.example.room.room_2_tutorial.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Region(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    val name: String
)