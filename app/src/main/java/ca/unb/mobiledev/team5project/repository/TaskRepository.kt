package ca.unb.mobiledev.team5project.repository

import android.app.Application
import android.util.Log
import ca.unb.mobiledev.team5project.dao.TaskDao
import ca.unb.mobiledev.team5project.db.AppDatabase
import ca.unb.mobiledev.team5project.db.AppDatabase.Companion.getDatabase
import ca.unb.mobiledev.team5project.model.Task
import java.util.concurrent.Callable
import java.util.concurrent.Future

class TaskRepository(application: Application) {
    private val taskDao: TaskDao? = getDatabase(application).taskDao()

    fun insertTask(name: String?) {
        Log.e("Task Activity", "I made it here")
        val newTask = Task()
        newTask.title = name
        AppDatabase.databaseWriterExecutor.execute { taskDao!!.insert(newTask) }
    }

    fun searchTasks(): List<Task> { //This should eventually be broken out into multiple search functions for tasks (daily, weekly, completed, etc.)
        val dataReadFuture: Future<List<Task>> = AppDatabase.databaseWriterExecutor.submit(
            Callable{
                taskDao!!.retrieve()
            }
        )
        return dataReadFuture.get()
    }
}