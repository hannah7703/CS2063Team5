package ca.unb.mobiledev.team5project.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.Date


@Entity(tableName = "task")
class Task {
    @PrimaryKey(true) var id = 0
    var title: String? = null
    var deadline: String? = null
    var repeat: Boolean = false
    var startDate: Date? = null
    var reminder: Boolean = false
    var reminderTime: Time? = null
    var completed: Boolean = false
}
