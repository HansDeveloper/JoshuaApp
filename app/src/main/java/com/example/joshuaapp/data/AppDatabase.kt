package com.example.joshuaapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import com.example.joshuaapp.application.ApplicationController
import com.example.joshuaapp.data.dao.UserDao
import com.example.joshuaapp.data.entities.AccessTokenEntity
import com.example.joshuaapp.data.entities.UserEntity


@Database(entities = [AccessTokenEntity::class,
UserEntity::class],
    version = 2,
    exportSchema = false)

abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao() : UserDao

    companion object{

        @Volatile private var instance : AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase{
            return instance ?: synchronized(this){
                instance ?: buildDatabase(context).also{ instance = it}
            }
        }

        private fun buildDatabase(context: Context) : AppDatabase{
            return Room.databaseBuilder(context,
                AppDatabase::class.java,
                ApplicationController.propertiesReader.getDatabaseName()).build()
        }
    }
}