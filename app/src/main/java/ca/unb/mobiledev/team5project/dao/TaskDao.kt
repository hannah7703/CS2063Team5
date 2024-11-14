package ca.unb.mobiledev.team5project.dao

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ca.unb.mobiledev.team5project.model.Task

/**
 * This DAO object validates the SQL at compile-time and associates it with a method
 */
@Dao
interface TaskDao {
    @Insert
    fun insert(task: Task)

    @Query("SELECT id, title, deadline, repeat, reminder, completed FROM task_table")
    fun retrieve(): List<Task>
}
