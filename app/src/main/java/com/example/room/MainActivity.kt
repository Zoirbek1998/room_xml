package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.room.adapter.StudentAdapter
import com.example.room.database.AppDatabase
import com.example.room.database.entity.Student
import com.example.room.databinding.ActivityMainBinding
import com.example.room.room_2_tutorial.StudentWithRegion
import com.example.room.room_2_tutorial.adapter.RegionAdapter
import com.example.room.room_2_tutorial.adapter.StudentsAdapter
import com.example.room.room_2_tutorial.database.AppDatabases
import com.example.room.room_2_tutorial.database.entity.Region
import com.example.room.room_2_tutorial.database.entity.Students

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // 1- o'rganish darsiga tegishli
//    private lateinit var list: ArrayList<Student>
//    private lateinit var studentAdapter: StudentAdapter
//val appDatabase: AppDatabase by lazy {
//    AppDatabase.getInstance(this)
//}


    // 2- o'rganish darsiga tegishli
    lateinit var appDatabases: AppDatabases
    lateinit var regionList: ArrayList<Region>
    lateinit var studentsList: ArrayList<StudentWithRegion>
    private lateinit var regionAdapter: RegionAdapter
    private lateinit var studetsAdatper: StudentsAdapter
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

        appDatabases = AppDatabases.getInstance(this)
        regionList = ArrayList(appDatabases.regionDao().getRegions())
        regionAdapter = RegionAdapter(this, regionList)

        studentsList = ArrayList(appDatabases.studentDao().getStudentsWithRegion())
        studetsAdatper = StudentsAdapter(studentsList)

//        appDatabases.regionDao().addRegion(Region(name = "Toshkent"))
//        appDatabases.regionDao().addRegion(Region(name = "Samarqand"))
//        appDatabases.regionDao().addRegion(Region(name = "Andijon"))
//        appDatabases.regionDao().addRegion(Region(name = "Farg'ona"))
//        appDatabases.regionDao().addRegion(Region(name = "Namangan"))
//        appDatabases.regionDao().addRegion(Region(name = "Buxoro"))

        binding.apply {
            spinner.adapter = regionAdapter
            rv.adapter = studetsAdatper
            saveBtn.setOnClickListener {
                val name = nameEt.text.toString()
                val age = ageEt.text.toString().toInt()
                val region = regionList[spinner.selectedItemPosition]
                val students = Students(
                    name = name,
                    age = age,
                    regionId = region.id
                )
               val id =  appDatabases.studentDao().addStudent(students)
                students.id = id.toInt()
                studentsList.add(StudentWithRegion(region = region, students = students))
                studetsAdatper.notifyItemInserted(studentsList.size)
            }

            deleteBtn.setOnClickListener {
                appDatabases.regionDao().deleteRegion(2)
            }
        }


    }
}