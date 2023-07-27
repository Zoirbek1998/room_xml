package com.example.room.room_2_tutorial.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.database.entity.Student
import com.example.room.databinding.ItemRegionBinding
import com.example.room.databinding.ItemStudentBinding
import com.example.room.room_2_tutorial.database.entity.Region

class RegionAdapter(context: Context, val list: ArrayList<Region>) :
    ArrayAdapter<Region>(context, R.layout.item_region) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemRegionBinding:ItemRegionBinding
        if (convertView ==null){
            itemRegionBinding  = ItemRegionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        }else{
            itemRegionBinding = ItemRegionBinding.bind(convertView)
        }
        itemRegionBinding.nameTv.text = list[position].name
        return itemRegionBinding.root
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemRegionBinding:ItemRegionBinding
        if (convertView ==null){
            itemRegionBinding  = ItemRegionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        }else{
            itemRegionBinding = ItemRegionBinding.bind(convertView)
        }
        itemRegionBinding.nameTv.text = list[position].name
        return itemRegionBinding.root
    }

    override fun getCount(): Int {
        return list.size
    }



}