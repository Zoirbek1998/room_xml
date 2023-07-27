package com.example.room.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true) // -> bu bizga id orniga id yaratib beradi databaseda 1,2,3,4 qilib. Biz hohlasak id ni ozini berib yuborsak boladi
    val id: Int = 0,
    val name: String,
    val age: Int,
    @ColumnInfo(name = "phone_number") // bu esa jadvalga nomini togri qilib yozib beradi
    val phoneNumber: String, //-> roomda bazaga jadval yozayotgan paytida bu tog'ri key bolmidi. Bu -> phone_number togri
    val email: String,
    val call: String
)
