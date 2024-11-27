package ca.unb.mobiledev.team5project.dao

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ca.unb.mobiledev.team5project.model.Task

/**
 * This DAO object validates the SQL at compile-time and associates it with a method
 */
@Dao
interface TaskDao {
    @Insert
    fun insert(task: Task)

    @Query("SELECT id, title, deadline, repeat, startDate, reminder, reminderTime, completed FROM task_table")
    fun retrieveAll(): List<Task>

    @Query("SELECT id, title, deadline, repeat, startDate, reminder, reminderTime, completed FROM task_table WHERE deadline = 'Day' AND startDate = :currDate AND completed = 0")
    fun retrieveDaily(currDate: String): List<Task>

    @Query("SELECT id, title, deadline, repeat, startDate, reminder, reminderTime, completed FROM task_table WHERE deadline = 'Week' AND startDate>= :currDate AND startDate < :weekDate AND completed = 0")
    fun retrieveWeekly(currDate: String, weekDate: String): List<Task>

    @Query("SELECT id, title, deadline, repeat, startDate, reminder, reminderTime, completed FROM task_table WHERE deadline  = 'Month' AND startDate >= :currDate AND startDate < :monthDate AND completed = 0")
    fun retrieveMonthly(currDate: String, monthDate: String): List<Task>

    @Query("SELECT id, title, deadline, repeat, startDate, reminder, reminderTime, completed FROM task_table WHERE completed = 1 AND startDate >= :currDate")
    fun retrieveCompleted(currDate: String): List<Task>

    @Query("UPDATE task_table SET completed = 1 WHERE title = :taskName")
    fun completeTask(taskName: String)
}
