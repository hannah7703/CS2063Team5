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

    fun insertTask(name: String, deadline: String?, repeat: Boolean, startDate: String?, reminder: Boolean, reminderTime: String?, completed: Boolean) {
        val newTask = Task()
        newTask.title = name
        newTask.deadline = deadline
        newTask.repeat = repeat
        newTask.startDate = startDate
        newTask.reminder = reminder
        newTask.reminderTime = reminderTime
        newTask.completed = completed
        AppDatabase.databaseWriterExecutor.execute { taskDao!!.insert(newTask) }
    }

    fun retrieveAllTasks(): List<Task> {
        val dataReadFuture: Future<List<Task>> = AppDatabase.databaseWriterExecutor.submit(
            Callable{
                taskDao!!.retrieveAll()
            }
        )
        return dataReadFuture.get()
    }

    fun retrieveDailyTasks(currDate: String): List<Task> {
        val dataReadFuture: Future<List<Task>> = AppDatabase.databaseWriterExecutor.submit(
            Callable{
                taskDao!!.retrieveDaily(currDate)
            }
        )
        return dataReadFuture.get()
    }

    fun retrieveWeeklyTasks(currDate: String, weekDate: String): List<Task> {
        val dataReadFuture: Future<List<Task>> = AppDatabase.databaseWriterExecutor.submit(
            Callable{
                taskDao!!.retrieveWeekly(currDate, weekDate)
            }
        )
        return dataReadFuture.get()
    }

    fun retrieveMonthlyTasks(currDate: String, monthDate: String): List<Task> {
        val dataReadFuture: Future<List<Task>> = AppDatabase.databaseWriterExecutor.submit(
            Callable{
                taskDao!!.retrieveMonthly(currDate, monthDate)
            }
        )
        return dataReadFuture.get()
    }

    fun retrieveCompletedTasks(currDate: String): List<Task> {
        val dataReadFuture: Future<List<Task>> = AppDatabase.databaseWriterExecutor.submit(
            Callable{
                taskDao!!.retrieveCompleted(currDate)
            }
        )
        return dataReadFuture.get()
    }

    fun completeTask(name: String) {
        AppDatabase.databaseWriterExecutor.execute { taskDao!!.completeTask(name) }
    }
}