package ca.unb.mobiledev.team5project

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

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

        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavBar.selectedItemId = R.id.store
        bottomNavBar?.setOnItemSelectedListener { item ->
            val menuItemId = item.itemId

            when (menuItemId) {
                R.id.achievements -> {
                    val intent = Intent(this, AchieveActivity::class.java)
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

        val item1 = findViewById<ImageView>(R.id.imageView)
        val item2 = findViewById<ImageView>(R.id.imageView10)
        val item3 = findViewById<ImageView>(R.id.imageView13)
        val item4 = findViewById<ImageView>(R.id.imageView14)
        val item5 = findViewById<ImageView>(R.id.imageView17)
        val item6 = findViewById<ImageView>(R.id.imageView18)

        item1.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Picture Frame")
                bundle.putInt("cost", 15)
                bundle.putBoolean("purchased", false)
                bundle.putBoolean("placed", false)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        item2.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Framed Map")
                bundle.putInt("cost", 20)
                bundle.putBoolean("purchased", false)
                bundle.putBoolean("placed", false)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        item3.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Fish Tank Man")
                bundle.putInt("cost", 20)
                bundle.putBoolean("purchased", false)
                bundle.putBoolean("placed", false)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        item4.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Wall Clock")
                bundle.putInt("cost", 10)
                bundle.putBoolean("purchased", true)
                bundle.putBoolean("placed", true)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        item5.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Magnifying Glass")
                bundle.putInt("cost", 5)
                bundle.putBoolean("purchased", false)
                bundle.putBoolean("placed", false)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        item6.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Camera")
                bundle.putInt("cost", 35)
                bundle.putBoolean("purchased", false)
                bundle.putBoolean("placed", false)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
    }
    companion object {
        // String for LogCat documentation
        const val TAG = "Store Activity"
    }
}