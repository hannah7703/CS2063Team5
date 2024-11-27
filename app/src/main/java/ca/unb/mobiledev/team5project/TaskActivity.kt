package ca.unb.mobiledev.team5project

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.unb.mobiledev.team5project.model.Statistics
import ca.unb.mobiledev.team5project.model.Task
import ca.unb.mobiledev.team5project.ui.CompletedTaskAdapter
import ca.unb.mobiledev.team5project.ui.TaskViewModel
import ca.unb.mobiledev.team5project.util.ListMaker
import com.google.android.material.bottomnavigation.BottomNavigationView
import ca.unb.mobiledev.team5project.ui.TaskAdapter


class TaskActivity : AppCompatActivity() {
    lateinit var statistics: Statistics
    lateinit var ListMaker: ListMaker
    lateinit var foodCount: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tasks)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tasks)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavBar.selectedItemId = R.id.tasks
        bottomNavBar?.setOnItemSelectedListener { item ->
            val menuItemId = item.itemId

            when (menuItemId) {
                R.id.store -> {
                    val intent = Intent(this, StoreActivity::class.java)
                    try {
                        startActivity(intent)
                    } catch (ex: ActivityNotFoundException) {
                        Log.e(TAG, "Unable to start the activity")
                    }
                }
                R.id.achievements -> {
                    val intent = Intent(this, AchieveActivity::class.java)
                    try {
                        startActivity(intent)
                    } catch (ex: ActivityNotFoundException) {
                        Log.e(TAG, "Unable to start the activity")
                    }
                }
                R.id.tank -> {
                    val intent = Intent(this, TankActivity::class.java)
                    try {
                        startActivity(intent)
                    } catch (ex: ActivityNotFoundException) {
                        Log.e(TAG, "Unable to start the activity")
                    }
                }
                R.id.fish -> {
                    val intent = Intent(this, FishActivity::class.java)
                    try {
                        startActivity(intent)
                    } catch (ex: ActivityNotFoundException) {
                        Log.e(TAG, "Unable to start the activity")
                    }
                }
            }

            return@setOnItemSelectedListener true
        }

        ListMaker = ListMaker(this)
        ListMaker.executeStatistics()
        statistics = ListMaker.getStatistics()
        foodCount = findViewById(R.id.foodCount)
        foodCount.text = statistics.Fishfood.toString()
        if(statistics.Username?.isEmpty() == true){
            val intent = Intent(this, UsernameDialog::class.java)
            try {
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        val title = findViewById<TextView>(R.id.textView)
        title.text = "${statistics.Username}'s Tasks"

        val createTaskButton = findViewById<Button>(R.id.createTaskBtn)
        createTaskButton.setOnClickListener {
           val intent = Intent(this, CreateTaskDialog::class.java)
            try {
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }

        updateLists()
    }

    override fun onResume() {
        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavBar.selectedItemId = R.id.tasks
        ListMaker.executeStatistics()
        statistics = ListMaker.getStatistics()
        foodCount.text = statistics.Fishfood.toString()
        val title = findViewById<TextView>(R.id.textView)
        title.text = "${statistics.Username}'s Tasks"
        updateLists()
        super.onResume()
    }

    private fun completeTask(name: String) {
        val taskViewModel by viewModels<TaskViewModel>()
        taskViewModel.completeTask(name)
    }

    private fun updateLists() {
        val taskViewModel by viewModels<TaskViewModel>()

        val dailyRecyclerView = findViewById<RecyclerView>(R.id.dailyTasksRecyclerView)
        dailyRecyclerView.layoutManager = LinearLayoutManager(this)
        val dayList = taskViewModel.retrieveDailyTasks()
        val dailyTaskAdapter = TaskAdapter(taskViewModel, dayList)
        dailyRecyclerView.adapter = dailyTaskAdapter
        dailyTaskAdapter.notifyDataSetChanged()

        val weeklyRecyclerView = findViewById<RecyclerView>(R.id.weeklyTasksRecyclerView)
        weeklyRecyclerView.layoutManager = LinearLayoutManager(this)
        val weekList = taskViewModel.retrieveWeeklyTasks()
        val weeklyTaskAdapter = TaskAdapter(taskViewModel, weekList)
        weeklyRecyclerView.adapter = weeklyTaskAdapter
        weeklyTaskAdapter.notifyDataSetChanged()

        val monthlyRecyclerView = findViewById<RecyclerView>(R.id.monthlyTasksRecyclerView)
        monthlyRecyclerView.layoutManager = LinearLayoutManager(this)
        val monthList = taskViewModel.retrieveMonthlyTasks()
        val monthlyTaskAdapter = TaskAdapter(taskViewModel, monthList)
        monthlyRecyclerView.adapter = monthlyTaskAdapter
        monthlyTaskAdapter.notifyDataSetChanged()

        // Need diff adapter for this I think
        val completedRecyclerView = findViewById<RecyclerView>(R.id.completedTasksRecyclerView)
        completedRecyclerView.layoutManager = LinearLayoutManager(this)
        val completedList = taskViewModel.retrieveCompletedTasks()
        val completedTaskAdapter = CompletedTaskAdapter(completedList)
        completedRecyclerView.adapter = completedTaskAdapter
        completedTaskAdapter.notifyDataSetChanged()
    }

    companion object {
        // String for LogCat documentation
        const val TAG = "Task Activity"
    }
}