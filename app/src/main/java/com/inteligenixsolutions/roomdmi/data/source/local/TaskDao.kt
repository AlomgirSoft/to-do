package com.inteligenixsolutions.roomdmi.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.inteligenixsolutions.roomdmi.data.source.Task

@Dao
interface TaskDao {
    @Insert
    fun insertTask(task: Task)

    @Query("SELECT*FROM Task")
    fun getAllTask():LiveData<List<Task>>
}