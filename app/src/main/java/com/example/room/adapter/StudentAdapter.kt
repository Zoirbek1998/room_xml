package com.example.room.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room.database.entity.Student
import com.example.room.databinding.ItemStudentBinding

class StudentAdapter(val list: ArrayList<Student>) : RecyclerView.Adapter<StudentAdapter.Vh>() {
    inner class Vh(val itemStudentBinding: ItemStudentBinding) :
        RecyclerView.ViewHolder(itemStudentBinding.root) {
        fun onBind(student: Student, position: Int) {
            itemStudentBinding.apply {
                nameTv.text = student.name
                ageTv.text = student.age.toString()
                phoneTv.text = student.phoneNumber
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        return holder.onBind(list[position], position)
    }

}