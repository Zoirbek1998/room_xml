package com.example.room.room_2_tutorial.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.room.room_2_tutorial.database.dao.RegionDao
import com.example.room.room_2_tutorial.database.dao.StudentsDao
import com.example.room.room_2_tutorial.database.entity.Region
import com.example.room.room_2_tutorial.database.entity.Students

@Database(entities = [Students::class, Region::class], version = 1)
abstract class AppDatabases : RoomDatabase() {

    abstract fun studentDao(): StudentsDao
    abstract fun regionDao(): RegionDao

    companion object {
        private var INSTANSE: AppDatabases? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabases {
            if (INSTANSE == null) {
                INSTANSE = Room.databaseBuilder(context, AppDatabases::class.java, "my_db2")
                    .allowMainThreadQueries()
//                    .addMigrations(MIGRATION_1_2)
                    .build()
            }

            return INSTANSE!!
        }

//        val MIGRATION_1_2 = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE student ADD COLUMN call TEXT NOT NULL DEFAULT ''")
//            }
//        }

    }

}