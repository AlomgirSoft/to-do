package com.inteligenixsolutions.roomdmi.data.source.local.repository

import android.app.Application
import com.inteligenixsolutions.roomdmi.data.source.Task
import com.inteligenixsolutions.roomdmi.data.source.local.service.LocalDataSourceImp
import com.inteligenixsolutions.roomdmi.data.source.local.TaskDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DefaultDataSourceRepository(application: Application) {

    lateinit var localDataSource: LocalDataSourceImp
    val isDispatcher: CoroutineDispatcher = Dispatchers.IO


    init {

        localDataSource = LocalDataSourceImp(TaskDatabase.getInstance(application).taskDao())

    }

    companion object {
        private var defaultDataSourceRepository: DefaultDataSourceRepository? = null

        fun getInstance(application: Application): DefaultDataSourceRepository {

            if (defaultDataSourceRepository == null) {

                defaultDataSourceRepository = DefaultDataSourceRepository(application)
                return defaultDataSourceRepository as DefaultDataSourceRepository
            }
            return defaultDataSourceRepository as DefaultDataSourceRepository
        }


    }


    suspend fun saveTask(task: Task) {

        withContext(isDispatcher) {
            localDataSource.saveData(task)
        }




    }
    val getAllTask= localDataSource.getAllTask()

}