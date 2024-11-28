package ca.unb.mobiledev.team5project

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.TimeUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.unb.mobiledev.team5project.model.Fish
import ca.unb.mobiledev.team5project.model.Statistics
import ca.unb.mobiledev.team5project.util.ListMaker
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.time.LocalTime

class TankActivity : AppCompatActivity() {
    lateinit var statistics: Statistics
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tank)

        val ListMaker = ListMaker(this)

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

        var i = 0
        val decoList = ListMaker.getDecorationList()
        var tempDeco = decoList[i]
        while(i < decoList.size) {
            tempDeco = decoList[i]
            when(tempDeco.placement) {
                "left" ->
                    when(tempDeco.decoType) {
                        "wall" -> findViewById<ImageView>(R.id.wallDecoLeft).setImageURI(tempDeco.decoCode?.toUri())
                        "table" -> findViewById<ImageView>(R.id.tableDecoLeft).setImageURI(tempDeco.decoCode?.toUri())
                        "tank" -> findViewById<ImageView>(R.id.tankDecoLeft).setImageURI(tempDeco.decoCode?.toUri())
                    }
                "right" ->
                    when(tempDeco.decoType) {
                        "wall" -> findViewById<ImageView>(R.id.wallDecoRight).setImageURI(tempDeco.decoCode?.toUri())
                        "table" -> findViewById<ImageView>(R.id.tableDecoRight).setImageURI(tempDeco.decoCode?.toUri())
                        "tank" -> findViewById<ImageView>(R.id.tankDecoRight).setImageURI(tempDeco.decoCode?.toUri())
                    }
                "center" ->
                    when(tempDeco.decoType) {
                        "wall" -> findViewById<ImageView>(R.id.wallDecoCenter).setImageURI(tempDeco.decoCode?.toUri())
                        "table" -> findViewById<ImageView>(R.id.tableDecoCenter).setImageURI(tempDeco.decoCode?.toUri())
                        "tank" -> findViewById<ImageView>(R.id.tankDecoCenter).setImageURI(tempDeco.decoCode?.toUri())
                    }
                null -> {}
                else -> Log.e(TankActivity.TAG, "Unable to place Decoration " + tempDeco.name)
            }
            i++
        }
        i = 0
        val fishList: List<Fish> = ListMaker.fishList.toList()
        var tempFish = fishList[i]
        while(i < fishList.size) {
            tempFish = fishList[i]
            when(tempFish.placement) {
                    "left" -> findViewById<ImageView>(R.id.fishLeft).setImageURI(tempFish.imageLink.toUri())
                    "center" -> findViewById<ImageView>(R.id.fishCenter).setImageURI(tempFish.imageLink.toUri())
                    "right" -> findViewById<ImageView>(R.id.fishRight).setImageURI(tempFish.imageLink.toUri())
                    null -> {}
                    else -> Log.e(TankActivity.TAG, "Unable to place Fish " + tempFish.name)
            }
            i++
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

        ListMaker.executeStatistics()
        statistics = ListMaker.getStatistics()
        val foodCount = findViewById<TextView>(R.id.foodCount)
        foodCount.text = statistics.Fishfood.toString()
        val title = findViewById<TextView>(R.id.textView)
        title.text = "${statistics.Username}'s Tank"
    }

    companion object {
        // String for LogCat documentation
        const val TAG = "Tank Activity"
    }
}