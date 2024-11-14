package ca.unb.mobiledev.team5project.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import ca.unb.mobiledev.team5project.model.Task
import ca.unb.mobiledev.team5project.repository.TaskRepository

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val taskRepository: TaskRepository = TaskRepository(application)

    fun insert(name: String) {
        Log.e("Task Activity", "I made it here")
        taskRepository.insertTask(name)
    }

    fun search(): List<Task> { // This will eventually be several search functions (searchDailyTasks, etc...)
        return taskRepository.searchTasks()
    }
}