package com.example.room.room_2_tutorial.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.room.room_2_tutorial.database.entity.Region

@Dao
interface RegionDao {

    @Insert
    fun addRegion(region: Region)

    @Query("select * from region")
    fun getRegions(): List<Region>

    @Query("select * from region where id = :id")
    fun getRegionById(id:Int):Region

    @Query("delete from region where id = :id")
    fun deleteRegion(id:Int)

}