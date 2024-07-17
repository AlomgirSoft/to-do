package com.inteligenixsolutions.roomdmi.data.source.local.service

import androidx.lifecycle.LiveData
import com.inteligenixsolutions.roomdmi.data.source.Task
import com.inteligenixsolutions.roomdmi.data.source.local.TaskDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSourceImp(
    val  taskDao: TaskDao,
    val isDispatcher: CoroutineDispatcher=Dispatchers.IO


): DataSource {
    override suspend fun saveData(task: Task) {
       withContext(isDispatcher){
           taskDao.insertTask(task)
       }
    }

    override fun getAllTask(): LiveData<List<Task>> {
        return taskDao.getAllTask()
    }


}