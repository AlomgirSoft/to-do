package com.inteligenixsolutions.roomdmi.ui.fragment.add_task_fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.inteligenixsolutions.roomdmi.R
import com.inteligenixsolutions.roomdmi.data.source.local.repository.DefaultDataSourceRepository
import com.inteligenixsolutions.roomdmi.data.source.Task
import kotlinx.coroutines.launch

class AddTaskViewModel(application: Application) : AndroidViewModel(application) {

    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    val repository: DefaultDataSourceRepository =
        DefaultDataSourceRepository.getInstance(application)

    private val _navigateToTaskFragment = MutableLiveData<Boolean>()
    val navigateToTaskFragment: LiveData<Boolean> get() = _navigateToTaskFragment

    private val _snackBar = MutableLiveData<Int>()
    val snackbar: LiveData<Int> get() = _snackBar

    private var titleChar = 6


    fun saveData() {

        val title = title.value
        val description = description.value

        val task = Task(title = title, description = description)
        if (isValidTask(title, description)){
            createItem(task)
        }



    }

    private fun isValidTask(title: String?, description: String?): Boolean {
        if (title.isNullOrEmpty() || description.isNullOrEmpty()) {
            _snackBar.postValue(R.string.Place_input_your_file)
            return false
        }

        if (title.length < titleChar) {
            _snackBar.postValue(R.string.title_more_then_6_char)
            return false
        }
        return true

    }

    private fun createItem(task: Task) {
        viewModelScope.launch {
            repository.saveTask(task)
            _navigateToTaskFragment.postValue(true)

        }


    }

    fun doneNavigating() {
        _navigateToTaskFragment.value = false
    }

}