package ca.unb.mobiledev.team5project.ui

import android.app.Activity
import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import ca.unb.mobiledev.team5project.model.Task
import ca.unb.mobiledev.team5project.repository.TaskRepository
import ca.unb.mobiledev.team5project.util.ListMaker
import java.time.LocalDate
import java.time.Period

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val taskRepository: TaskRepository = TaskRepository(application)
    private val context = application.applicationContext

    fun insert(name: String, deadline: String?, repeat: Boolean, startDate: String?, reminder: Boolean, reminderTime: String?, completed: Boolean) {
        taskRepository.insertTask(name, deadline, repeat, startDate, reminder, reminderTime, completed)
    }

    fun retrieveAllTasks(): List<Task> {
        return taskRepository.retrieveAllTasks()
    }

    fun retrieveDailyTasks(): List<Task> {
        val currDate = LocalDate.now()
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

    fun completeTask(name: String, completed: Boolean) {
        taskRepository.completeTask(name, completed)
        val listMaker = ListMaker(context)
        listMaker.executeStatistics()
        val statistics = listMaker.getStatistics()
        if(completed){
            listMaker.updateStatistics("Task Completed", statistics.TaskCompleted, true, 1)
            statistics.TaskCompleted++
            //Give rewards
            if (statistics.FishCollected == 0 || statistics.TaskCompleted % 5 == 0) {
                listMaker.updateStatistics("Fish Collected", statistics.FishCollected, true, 1)
                listMaker.executeFish()
                val fishList = listMaker.fishList
                for (fish in fishList){
                    if(!fish.owned){
                        listMaker.updateFish(fish.type!!, true, "owned")
                        Toast.makeText(context, "You earned the ${fish.type}!", Toast.LENGTH_SHORT).show()
                        break
                    }
                }
            } else if (statistics.TaskCompleted % 3 == 0) {
                listMaker.updateStatistics("Fish food", statistics.Fishfood, true, 10)
                Toast.makeText(context, "You earned 10 fish food!", Toast.LENGTH_SHORT).show()
            } else {
                listMaker.updateStatistics("Fish food", statistics.Fishfood, true, 5)
                Toast.makeText(context, "You earned 5 fish food!", Toast.LENGTH_SHORT).show()
            }
        } else {
            listMaker.updateStatistics("Task Completed", statistics.TaskCompleted, false, 1)
            statistics.TaskCompleted--
        }
    }
}