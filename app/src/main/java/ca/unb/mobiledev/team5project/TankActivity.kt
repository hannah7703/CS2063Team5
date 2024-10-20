package ca.unb.mobiledev.team5project

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.TimeUtils
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.time.LocalTime

class TankActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tank)

        //sets day window and wall visible if day *****Hardcoded sunrise sunset!!
        val daytime = TimeUtils.isTimeBetween(LocalTime.now(), LocalTime.of(6,0), LocalTime.of(22,0))
        if (daytime) {
            findViewById<ImageView>(R.id.dayWindow).visibility = View.VISIBLE
            findViewById<ImageView>(R.id.nightWindow).visibility = View.INVISIBLE
            findViewById<ImageView>(R.id.dayWall).visibility = View.VISIBLE
            findViewById<ImageView>(R.id.nightWall).visibility = View.INVISIBLE
        }
        else {
            findViewById<ImageView>(R.id.dayWindow).visibility = View.INVISIBLE
            findViewById<ImageView>(R.id.nightWindow).visibility = View.VISIBLE
            findViewById<ImageView>(R.id.dayWall).visibility = View.INVISIBLE
            findViewById<ImageView>(R.id.nightWall).visibility = View.VISIBLE
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tank)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavBar.selectedItemId = R.id.tank
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
                R.id.achievements -> {
                    val intent = Intent(this, AchieveActivity::class.java)
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
    }
    companion object {
        // String for LogCat documentation
        const val TAG = "Tank Activity"
    }
}