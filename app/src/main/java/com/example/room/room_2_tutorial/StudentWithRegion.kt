package com.example.room.room_2_tutorial

import androidx.room.Embedded
import androidx.room.Relation
import com.example.room.room_2_tutorial.database.entity.Region
import com.example.room.room_2_tutorial.database.entity.Students

data class StudentWithRegion(
    @Embedded val students: Students,
    @Relation(
        entity = Region::class,
        parentColumn = "region_id",
        entityColumn = "id"
    )
    val region:Region
)