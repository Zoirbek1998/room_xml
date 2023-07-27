package com.example.room.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.room.database.entity.Student

@Dao
interface StudentDao {

    @Query("select * from student")
    fun getAllStudent(): List<Student>

    @Insert //(onConflict = OnConflictStrategy.REPLACE)
    fun addStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Update
    fun editStudent(student: Student)

    @Query("select * from student where id = :id")
    fun getStudentById(id:Int):Student

    @Query("select * from student where name like '%' || :word ||'%'")
    fun getStudentByName(word:String) : List<Student> // -> student nomi bilan qidirish

}