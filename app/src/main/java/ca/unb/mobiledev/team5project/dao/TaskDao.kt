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

    @Query("SELECT id, title, deadline, repeat, reminder, completed FROM task_table")
    fun retrieveAll(): List<Task>

    @Query("SELECT id, title, deadline, repeat, reminder, completed FROM task_table WHERE deadline >= :currDate AND completed = 0")
    fun retrieveDaily(currDate: String): List<Task>

    @Query("SELECT id, title, deadline, repeat, reminder, completed FROM task_table WHERE deadline >= :currDate AND deadline < :weekDate AND completed = 0")
    fun retrieveWeekly(currDate: String, weekDate: String): List<Task>

    @Query("SELECT id, title, deadline, repeat, reminder, completed FROM task_table WHERE deadline >= :currDate AND deadline < :monthDate AND completed = 0")
    fun retrieveMonthly(currDate: String, monthDate: String): List<Task>

    @Query("SELECT id, title, deadline, repeat, reminder, completed FROM task_table WHERE completed = 1 AND deadline >= :currDate")
    fun retrieveCompleted(currDate: String): List<Task>

    @Query("UPDATE task_table SET completed = false WHERE title = :taskName")
    fun completeTask(taskName: String)
}
