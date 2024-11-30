package ca.unb.mobiledev.team5project

import android.os.Bundle
import android.util.Log
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
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.unb.mobiledev.team5project.ui.TaskViewModel
import ca.unb.mobiledev.team5project.util.ListMaker
import java.sql.Date
import java.sql.Time


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
        var reminderTime: Time? = null
        val titleBox = findViewById<EditText>(R.id.TaskTitleEdit)
        val calendar = findViewById<CalendarView>(R.id.calendarView)
        val calendarBack = findViewById<RelativeLayout>(R.id.relativeLayout3)
        val dateClickBox = findViewById<TextView>(R.id.selectDateBox)
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

        val saveTaskButton = findViewById<Button>(R.id.SaveTask)
        saveTaskButton.setOnClickListener{
            val title = titleBox.text.toString()
            val deadline = deadlineDropDown.selectedItem.toString()
            if (title.isEmpty() or dateClickBox.text.equals(" Tap to select")) {
                Toast.makeText(this, "You must fill all fields!", Toast.LENGTH_SHORT).show()
            } else {
                val listMaker = ListMaker(this)
                listMaker.executeStatistics()
                val statistics = listMaker.getStatistics()
                listMaker.updateStatistics("Task Made", statistics.TaskMade,true, 1)
                val taskViewModel by viewModels<TaskViewModel>()
                taskViewModel.insert(title, deadline, false,
                    startdate.toString(), false, reminderTime.toString(), false)
                finish()
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