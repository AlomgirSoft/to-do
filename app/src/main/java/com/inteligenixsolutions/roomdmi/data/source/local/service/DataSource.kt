package com.inteligenixsolutions.roomdmi.data.source.local.service

import androidx.lifecycle.LiveData
import com.inteligenixsolutions.roomdmi.data.source.Task

interface DataSource {

   suspend fun saveData(task: Task)


    fun getAllTask():LiveData<List<Task>>
}