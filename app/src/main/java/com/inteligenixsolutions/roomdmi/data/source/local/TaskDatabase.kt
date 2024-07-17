package com.inteligenixsolutions.roomdmi.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.inteligenixsolutions.roomdmi.data.source.Task

@Database(entities = [Task::class], version = 1 , exportSchema = false)
abstract class TaskDatabase:RoomDatabase() {

    abstract fun taskDao():TaskDao



    companion object{
        private var database: TaskDatabase?=null

        @Synchronized
        fun getInstance(context: Context):TaskDatabase{


            if (database ==null){
                database=Room.databaseBuilder(context,TaskDatabase::class.java,"Task_table").build()
                return database as TaskDatabase
            }
            return database as TaskDatabase
        }


    }

}