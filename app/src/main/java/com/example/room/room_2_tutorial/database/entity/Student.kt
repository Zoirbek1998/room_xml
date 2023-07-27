package com.example.room.room_2_tutorial.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Region::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("region_id"),
            onDelete = ForeignKey.CASCADE

//        CASCADE => bunda men biron bir idga tegishli narsani ochir degan buyruq bersam bu osha idga bog'langan barchasini ochirib beradi
//        NO_ACTION => bunda men biron bir idga tegishli narsani ochir degan buyruq bersam bu ochirib bermaydi inkor qiliadi
        )
    ]
)
data class Students(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String,
    val age: Int,
    @ColumnInfo(name = "region_id")
    val regionId: Int,

    )
