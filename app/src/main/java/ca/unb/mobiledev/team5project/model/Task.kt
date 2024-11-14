package ca.unb.mobiledev.team5project.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.Date


@Entity(tableName = "task_table")
class Task {
    @PrimaryKey(true) var id = 0
    var title: String? = null
    var deadline: String? = null
    var repeat: Boolean = false
//    var startDate: Date? = null // Will need to create converters for date/time fields
    var reminder: Boolean = false
//    var reminderTime: Time? = null
    var completed: Boolean = false
}
