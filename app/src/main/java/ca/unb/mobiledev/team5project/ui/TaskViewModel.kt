package ca.unb.mobiledev.team5project.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import ca.unb.mobiledev.team5project.model.Task
import ca.unb.mobiledev.team5project.repository.TaskRepository
import java.time.LocalDate
import java.time.Period

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val taskRepository: TaskRepository = TaskRepository(application)

    fun insert(name: String, deadline: String?, repeat: Boolean, startDate: String?, reminder: Boolean, reminderTime: String?, completed: Boolean) {
        taskRepository.insertTask(name, deadline, repeat, startDate, reminder, reminderTime, completed)
    }

    fun retrieveAllTasks(): List<Task> {
        return taskRepository.retrieveAllTasks()
    }

    fun retrieveDailyTasks(): List<Task> {
        val currDate = LocalDate.now()
        val weekDate = currDate.plus(Period.of(0, 0, 7))
        return taskRepository.retrieveDailyTasks(currDate.toString())
    }

    fun retrieveWeeklyTasks(): List<Task> {
        val currDate = LocalDate.now()
        val weekDate = currDate.plus(Period.of(0, 0, 7))
        return taskRepository.retrieveWeeklyTasks(currDate.toString(), weekDate.toString())
    }

    fun retrieveMonthlyTasks(): List<Task> {
        val currDate = LocalDate.now()
        val monthDate = currDate.plus(Period.of(0, 1, 0))
        return taskRepository.retrieveMonthlyTasks(currDate.toString(), monthDate.toString())
    }

    fun retrieveCompletedTasks(): List<Task> {
        val currDate = LocalDate.now().toString()
        return taskRepository.retrieveCompletedTasks(currDate)
    }

    fun completeTask(name: String) {
        taskRepository.completeTask(name)
    }
}