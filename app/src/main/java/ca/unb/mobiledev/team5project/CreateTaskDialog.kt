package ca.unb.mobiledev.team5project

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CalendarView
import android.widget.CheckBox
import android.widget.RelativeLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class CreateTaskDialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_create)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.createDialog)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val saveTaskButton = findViewById<Button>(R.id.SaveTask)
        saveTaskButton.setOnClickListener{
            finish()
        }
        val cancelTaskButton = findViewById<Button>(R.id.CancelTask)
        cancelTaskButton.setOnClickListener{
            finish()
        }

        val calendar = findViewById<CalendarView>(R.id.calendarView)
        val calendarBack = findViewById<RelativeLayout>(R.id.relativeLayout3)
        val dateClickBox = findViewById<TextView>(R.id.selectDateBox)
        dateClickBox.setOnClickListener {
            calendarBack.visibility = View.VISIBLE
        }
        calendar.setOnDateChangeListener { calendarView, year, month, day ->
            val date = " $day/$month/$year"
            dateClickBox.text = date
            calendarBack.visibility = View.INVISIBLE
        }

        val deadlineDropDown = findViewById<Spinner>(R.id.DeadlineDrop)
        val adapter = ArrayAdapter.createFromResource(this, R.array.deadline_options, android.R.layout.simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        deadlineDropDown.adapter = adapter

        val timeDropDown = findViewById<Spinner>(R.id.timeSpinner)
        val timeAdapter = ArrayAdapter.createFromResource(this, R.array.time, android.R.layout.simple_spinner_dropdown_item)
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        timeDropDown.adapter = timeAdapter

        val remindCheckBox = findViewById<CheckBox>(R.id.reminderCheckBox)
        val reminderTime = findViewById<TextView>(R.id.DialogRemindTime)
        val reminderHour = findViewById<Spinner>(R.id.hour)
        val HourAdapter = ArrayAdapter.createFromResource(this, R.array.hour, android.R.layout.simple_spinner_dropdown_item)
        HourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        reminderHour.adapter = HourAdapter

        val reminderMinute = findViewById<Spinner>(R.id.Minute)
        val minuteAdapter = ArrayAdapter.createFromResource(this, R.array.minute, android.R.layout.simple_spinner_dropdown_item)
        minuteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        reminderMinute.adapter = minuteAdapter

        val reminderColon = findViewById<TextView>(R.id.TimeColon)
        remindCheckBox.setOnClickListener{
            if(remindCheckBox.isChecked){
                reminderTime.visibility = View.VISIBLE
                reminderHour.visibility = View.VISIBLE
                reminderColon.visibility = View.VISIBLE
                reminderMinute.visibility = View.VISIBLE
                timeDropDown.visibility = View.VISIBLE
            } else {
                reminderTime.visibility = View.INVISIBLE
                reminderHour.visibility = View.INVISIBLE
                reminderColon.visibility = View.INVISIBLE
                reminderMinute.visibility = View.INVISIBLE
                timeDropDown.visibility = View.INVISIBLE
            }
        }
    }

    companion object {
        // String for LogCat documentation
        const val TAG = "Create Task"
    }
}