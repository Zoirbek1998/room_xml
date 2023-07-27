package com.example.room.room_2_tutorial.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.room.room_2_tutorial.StudentWithRegion

import com.example.room.room_2_tutorial.database.entity.Region
import com.example.room.room_2_tutorial.database.entity.Students


@Dao
interface StudentsDao {
    @Insert
    fun addStudent(students: Students):Long

    @Query("select * from students")
    fun getStudents(): List<Students>

    @Query("select * from students where id = :id")
    fun getStudentsById(id:Int):Students

    @Transaction
    @Query("select * from students,region where students.region_id = region.id")
    fun getStudentsWithRegion():List<StudentWithRegion>

}
