package ca.unb.mobiledev.team5project

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.unb.mobiledev.team5project.TaskActivity.Companion
import com.google.android.material.bottomnavigation.BottomNavigationView

class AchieveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_achieve)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.achieve)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavBar.selectedItemId = R.id.achievements
        bottomNavBar?.setOnItemSelectedListener { item ->
            val menuItemId = item.itemId

            when (menuItemId) {
                R.id.store -> {
                    val intent = Intent(this, StoreActivity::class.java)
                    try {
                        startActivity(intent)
                    } catch (ex: ActivityNotFoundException) {
                        Log.e(TaskActivity.TAG, "Unable to start the activity")
                    }
                    finish()
                }
                R.id.tasks -> {
                    finish()
                }
                R.id.tank -> {
                    val intent = Intent(this, TankActivity::class.java)
                    try {
                        startActivity(intent)
                    } catch (ex: ActivityNotFoundException) {
                        Log.e(TaskActivity.TAG, "Unable to start the activity")
                    }
                    finish()
                }
                R.id.fish -> {
                    val intent = Intent(this, FishActivity::class.java)
                    try {
                        startActivity(intent)
                    } catch (ex: ActivityNotFoundException) {
                        Log.e(TaskActivity.TAG, "Unable to start the activity")
                    }
                    finish()
                }
            }

            return@setOnItemSelectedListener true
        }

        val TaskStarter = findViewById<ImageView>(R.id.imageView2)
        val ExpertPlanner = findViewById<ImageView>(R.id.imageView3)
        val PetOwner = findViewById<ImageView>(R.id.imageView4)
        val PetStore = findViewById<ImageView>(R.id.imageView6)
        val HabitStarter = findViewById<ImageView>(R.id.imageView5)
        val HabitMaster = findViewById<ImageView>(R.id.imageView7)
        val DepartmentStore = findViewById<ImageView>(R.id.imageView9)
        val IKEAShowroom = findViewById<ImageView>(R.id.imageView8)

        TaskStarter.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Task Starter")
                bundle.putString("goal", "Create 5/5 Tasks")
                bundle.putString("Reward", "Reward: 10 Fish Food")
                bundle.putString("state", "Achieved")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        ExpertPlanner.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Expert Planner")
                bundle.putString("goal", "Create 20/20 Tasks")
                bundle.putString("Reward", "Reward: 50 Fish Food")
                bundle.putString("state", "Achieved")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        PetOwner.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Pet Owner")
                bundle.putString("goal", "Collect 5/5 Fish")
                bundle.putString("Reward", "Reward: Rainbow Gravel")
                bundle.putString("state", "Achieved")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        PetStore.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "[Locked]")
                bundle.putString("goal", "Collect 8/20 Fish")
                bundle.putString("Reward", "Reward: 75 Fish Food")
                bundle.putString("state", "Locked")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        HabitStarter.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Habit Starter")
                bundle.putString("goal", "Complete 10/10 Tasks")
                bundle.putString("Reward", "Reward: Seaweed Decoration")
                bundle.putString("state", "Earned")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        HabitMaster.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "[Locked]")
                bundle.putString("goal", "Complete 10/50 Tasks")
                bundle.putString("Reward", "Reward: Fish Castle")
                bundle.putString("state", "Locked")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        DepartmentStore.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "[Locked]")
                bundle.putString("goal", "Buy 1/10 Items")
                bundle.putString("Reward", "Reward: 45 Fish Food")
                bundle.putString("state", "Locked")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        IKEAShowroom.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "[Locked]")
                bundle.putString("goal", "Buy 1/20 Items")
                bundle.putString("Reward", "Reward: Golden Gravel")
                bundle.putString("state", "Locked")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
    }
    companion object {
        // String for LogCat documentation
        const val TAG = "Achieve Activity"
    }
}