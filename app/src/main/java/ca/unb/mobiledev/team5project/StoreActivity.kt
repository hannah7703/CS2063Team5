package ca.unb.mobiledev.team5project

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.unb.mobiledev.team5project.FishActivity.Companion

class StoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_store)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.store)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val activityAchieve = findViewById<Button>(R.id.btnAchieve)
        activityAchieve.setOnClickListener {
            val intent = Intent(this, AchieveActivity::class.java)
            try {
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
            finish()
        }
        val activityFish = findViewById<Button>(R.id.btnFish)
        activityFish.setOnClickListener {
            val intent = Intent(this, FishActivity::class.java)
            try {
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
            finish()
        }
        val activityTask = findViewById<Button>(R.id.btnTask)
        activityTask.setOnClickListener {
            val intent = Intent(this, TaskActivity::class.java)
            try {
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
            finish()
        }
        val activityTank = findViewById<Button>(R.id.btnTank)
        activityTank.setOnClickListener {
            val intent = Intent(this, TankActivity::class.java)
            try {
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
            finish()
        }
    }
    companion object {
        // String for LogCat documentation
        const val TAG = "Store Activity"
    }
}