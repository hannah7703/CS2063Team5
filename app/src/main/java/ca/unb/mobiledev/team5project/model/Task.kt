package ca.unb.mobiledev.team5project.model

import java.sql.Time
import java.util.Date

data class Task(var title: String,
                var deadline: String,
                var repeat: Boolean,
                var startDate: Date?,
                var reminder: Boolean,
                var reminderTime: Time?,
                var state: Boolean) //Completed or not
