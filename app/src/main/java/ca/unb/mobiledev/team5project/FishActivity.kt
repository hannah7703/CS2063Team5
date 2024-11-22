package ca.unb.mobiledev.team5project

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.unb.mobiledev.team5project.model.Decoration
import ca.unb.mobiledev.team5project.model.Fish
import ca.unb.mobiledev.team5project.model.FishType
import ca.unb.mobiledev.team5project.model.Statistics
import ca.unb.mobiledev.team5project.util.ListMaker
import com.google.android.material.bottomnavigation.BottomNavigationView

class FishActivity : AppCompatActivity() {
    lateinit var statistics: Statistics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fish)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fish)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavBar.selectedItemId = R.id.fish
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
                R.id.achievements -> {
                    val intent = Intent(this, AchieveActivity::class.java)
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

        val ListMaker = ListMaker(this)
        ListMaker.executeStatistics()
        statistics = ListMaker.getStatistics()
        val foodCount = findViewById<TextView>(R.id.foodCount)
        foodCount.text = statistics.Fishfood.toString()
        val title = findViewById<TextView>(R.id.textView)
        title.text = "${statistics.Username}'s Fish"


        val fish1 = findViewById<ImageView>(R.id.imageView3)
        val fish2 = findViewById<ImageView>(R.id.imageView4)
        val fish3 = findViewById<ImageView>(R.id.imageView5)
        val fish4 = findViewById<ImageView>(R.id.imageView6)
        val fish5 = findViewById<ImageView>(R.id.imageView7)
        val fish6 = findViewById<ImageView>(R.id.imageView8)
        val fish7 = findViewById<ImageView>(R.id.imageView9)
        val fish8 = findViewById<ImageView>(R.id.imageView10)

        val fishText1 = findViewById<TextView>(R.id.textView6)
        val fishText2 = findViewById<TextView>(R.id.textView7)
        val fishText3 = findViewById<TextView>(R.id.textView8)
        val fishText4 = findViewById<TextView>(R.id.textView9)
        val fishText5 = findViewById<TextView>(R.id.textView10)
        val fishText6 = findViewById<TextView>(R.id.textView11)
        val fishText7 = findViewById<TextView>(R.id.textView12)
        val fishText8 = findViewById<TextView>(R.id.textView13)

        fish1.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Fish Name")
                bundle.putString("type", "Fish Type")
                bundle.putBoolean("owned", false)
                bundle.putBoolean("placed", false)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        fish2.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Fish Name")
                bundle.putString("type", "Fish Type")
                bundle.putBoolean("owned", false)
                bundle.putBoolean("placed", false)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        fish3.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Fish Name")
                bundle.putString("type", "Fish Type")
                bundle.putBoolean("owned", false)
                bundle.putBoolean("placed", false)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        fish4.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Fish Name")
                bundle.putString("type", "Fish Type")
                bundle.putBoolean("owned", false)
                bundle.putBoolean("placed", false)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        fish5.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Fish Name")
                bundle.putString("type", "Fish Type")
                bundle.putBoolean("owned", false)
                bundle.putBoolean("placed", false)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        fish6.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Fish Name")
                bundle.putString("type", "Fish Type")
                bundle.putBoolean("owned", false)
                bundle.putBoolean("placed", false)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        fish7.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Fish Name")
                bundle.putString("type", "Fish Type")
                bundle.putBoolean("owned", false)
                bundle.putBoolean("placed", false)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        fish8.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Fish Name")
                bundle.putString("type", "Fish Type")
                bundle.putBoolean("owned", false)
                bundle.putBoolean("placed", false)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
    }
    private fun setDetails(fish: Fish, text: TextView, image: ImageView){
        if(fish.owned){
            text.text = fish.name
            image.setImageResource(R.drawable.fishbowl_fishselection)
        } else {
            text.text = "[Locked]"
            image.setImageResource(R.drawable.fishbowl_fishselection)
        }
    }
    companion object {
        // String for LogCat documentation
        const val TAG = "Fish Activity"
    }
}