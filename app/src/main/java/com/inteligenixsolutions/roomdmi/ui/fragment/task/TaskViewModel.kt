package com.inteligenixsolutions.roomdmi.ui.fragment.task

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.inteligenixsolutions.roomdmi.data.source.local.repository.DefaultDataSourceRepository

class TaskViewModel(application: Application):AndroidViewModel(application) {

    val repository: DefaultDataSourceRepository =
        DefaultDataSourceRepository.getInstance(application)


    val getAllTask=repository.getAllTask

}