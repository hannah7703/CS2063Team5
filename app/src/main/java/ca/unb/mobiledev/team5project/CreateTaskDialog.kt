package ca.unb.mobiledev.team5project

import ca.unb.mobiledev.team5project.model.Task
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CalendarView
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.sql.Date
import java.sql.Time
import java.time.LocalDate


class CreateTaskDialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_create)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.createDialog)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var startdate: Date? = null
        var reminder = false
        var reminderTime: Time? = null
        val titleBox = findViewById<EditText>(R.id.TaskTitleEdit)
        val calendar = findViewById<CalendarView>(R.id.calendarView)
        val calendarBack = findViewById<RelativeLayout>(R.id.relativeLayout3)
        val dateClickBox = findViewById<TextView>(R.id.selectDateBox)
        val selectTime = findViewById<Button>(R.id.button2)
        dateClickBox.setOnClickListener {
            calendarBack.visibility = View.VISIBLE
        }
        calendar.setOnDateChangeListener { calendar, year, month, day ->
            var displayMonth = month+1
            val date = "$day/$displayMonth/$year"
            dateClickBox.text = " $date"
            val saveDate = "$year-$displayMonth-$day"
            startdate = Date.valueOf(saveDate)
            calendarBack.visibility = View.INVISIBLE
        }

        val deadlineDropDown = findViewById<Spinner>(R.id.DeadlineDrop)
        val adapter = ArrayAdapter.createFromResource(this, R.array.deadline_options, android.R.layout.simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        deadlineDropDown.adapter = adapter

        val reminderTimeDialog = findViewById<TextView>(R.id.DialogRemindTime)
        val remindCheckBox = findViewById<CheckBox>(R.id.reminderCheckBox)

        val selectTimeBox = findViewById<TextView>(R.id.selectTimeBox)
        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        selectTimeBox.setOnClickListener {
            calendarBack.visibility = View.VISIBLE
            timePicker.visibility = View.VISIBLE
            selectTime.visibility = View.VISIBLE
            calendar.visibility = View.INVISIBLE
        }
        selectTime.setOnClickListener{
            var hour = timePicker.hour
            var minute = timePicker.minute
            var reminder = "$hour:$minute:00"
            reminderTime = Time.valueOf(reminder)
            var am_pm = ""
            // AM_PM decider logic
            when {hour == 0 -> { hour += 12
                am_pm = "AM"
            }
                hour == 12 -> am_pm = "PM"
                hour > 12 -> { hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm = "AM"
            }
            var displayHour = if (hour < 10) "0" + hour else hour
            val displayMin = if (minute < 10) "0" + minute else minute
            // display format of time
            val time = " $displayHour:$displayMin $am_pm"
            selectTimeBox.text = time
            calendarBack.visibility = View.INVISIBLE
            timePicker.visibility = View.INVISIBLE
            selectTime.visibility = View.INVISIBLE
            calendar.visibility = View.VISIBLE
        }

        remindCheckBox.setOnClickListener{
            if(remindCheckBox.isChecked){
                selectTimeBox.visibility = View.VISIBLE
                reminderTimeDialog.visibility = View.VISIBLE
                reminder = true
            } else {
                selectTimeBox.visibility = View.INVISIBLE
                reminderTimeDialog.visibility = View.INVISIBLE
                reminder = false
            }
        }

        val repeatCheckbox = findViewById<CheckBox>(R.id.repeatCheck)
        val saveTaskButton = findViewById<Button>(R.id.SaveTask)
        saveTaskButton.setOnClickListener{
            val title = titleBox.text.toString()
            val deadline = deadlineDropDown.selectedItem.toString()
            var repeat = repeatCheckbox.isChecked
            if (!remindCheckBox.isChecked){
                reminderTime = null
            }
            if (title.isEmpty() or dateClickBox.text.equals(" Tap to select")) {
                Toast.makeText(this, "You must fill all fields!", Toast.LENGTH_SHORT).show()
            } else {
                // Commented this out for now until the database insert() actually works...
//                val newTask = Task(title, deadline, repeat, startdate, reminder, reminderTime, false)
//                finish()
            }
        }
        val cancelTaskButton = findViewById<Button>(R.id.CancelTask)
        cancelTaskButton.setOnClickListener{
            finish()
        }
    }

    companion object {
        // String for LogCat documentation
        const val TAG = "Create Task"
    }
}