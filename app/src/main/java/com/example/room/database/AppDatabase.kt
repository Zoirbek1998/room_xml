package com.example.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.room.database.dao.StudentDao
import com.example.room.database.entity.Student

@Database(entities = [Student::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao

    companion object {
        private var INSTANSE: AppDatabase? = null

        @Synchronized //-> teng kelgan oqimlarni muximligiga qarab 1ta 1ta ishlatib beradi
        fun getInstance(context: Context): AppDatabase {
            if (INSTANSE == null) {
                INSTANSE = Room.databaseBuilder(context, AppDatabase::class.java, "my_db")
                    .allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2)
//                    .fallbackToDestructiveMigration() -> bunda migratsiyadan foydalanmasdan ish amalga oshiriladi yani table qoshib versiya kotarilganda database ochirib boshqattan yozadi
                    .build()
            }

            return INSTANSE!!
        }

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE student ADD COLUMN call TEXT NOT NULL DEFAULT ''")
            }
        }

    }

}