package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.room.adapter.StudentAdapter
import com.example.room.database.AppDatabase
import com.example.room.database.entity.Student
import com.example.room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // 1- o'rganish darsiga tegishli
//    private lateinit var list: ArrayList<Student>
//    private lateinit var studentAdapter: StudentAdapter
//val appDatabase: AppDatabase by lazy {
//    AppDatabase.getInstance(this)
//}


    // 2- o'rganish darsiga tegishli

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1- o'rganish darsiga tegishli
//        list = ArrayList(appDatabase.studentDao().getAllStudent())
//        studentAdapter = StudentAdapter(list)
//        binding.rv.adapter = studentAdapter
//     binding.saveBtn.setOnClickListener {
//            binding.apply {
//                val student = Student(
//                    name = nameEt.text.toString(),
//                    age = ageEt.text.toString().toInt(),
//                    phoneNumber = phoneEt.text.toString(),
//                    email = "zoirbek@gmail.com",
//                    call = "7777"
//                )
//                appDatabase.studentDao().addStudent(student)
//                list.add(student)
//                studentAdapter.notifyItemInserted(list.size)
//            }
//        }

        // 2- o'rganish darsiga tegishli


    }
}