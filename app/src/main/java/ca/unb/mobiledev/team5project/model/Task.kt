package ca.unb.mobiledev.team5project.model

import java.sql.Time
import java.util.Date

data class Task(val title: String,
                val deadline: String,
                val repeat: Boolean,
                val startDate: Date,
                val reminder: Boolean,
                val reminderTime: Time?,
                val state: Boolean) //Completed or not
