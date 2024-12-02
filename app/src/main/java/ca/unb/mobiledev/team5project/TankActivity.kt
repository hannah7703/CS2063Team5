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
import ca.unb.mobiledev.team5project.model.Decoration
import ca.unb.mobiledev.team5project.model.Fish
import ca.unb.mobiledev.team5project.model.Statistics
import ca.unb.mobiledev.team5project.util.JsonUtils
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

        val listMaker = ListMaker(this)

        //sets day window and wall visible if day *****Hardcoded sunrise sunset!!
        val daytime = TimeUtils.isTimeBetween(LocalTime.now(), LocalTime.of(6,0), LocalTime.of(20,0))
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

        listMaker.executeDecorations()
        val decoList = ArrayList<Decoration>()
        decoList.addAll(listMaker.getDecorationList())
        var image: ImageView
        var id = 0
        var link = ""
        for(tempDeco in decoList) {
            link = tempDeco.imageLink.split(".")[0]
            when(tempDeco.placement) {
                "Left" -> {
                    when (tempDeco.decoType) {
                        "Wall" -> {
                            image = findViewById<ImageView>(R.id.wallDecoLeft)
                            id = getResources().getIdentifier(link, "drawable", packageName)
                            image.setImageResource(id)
                        }

                        "Table" -> {
                            image = findViewById<ImageView>(R.id.tableDecoLeft)
                            id = getResources().getIdentifier(link, "drawable", packageName)
                            image.setImageResource(id)
                        }

                        "tank" -> {
                            image = findViewById<ImageView>(R.id.tankDecoLeft)
                            id = getResources().getIdentifier(link, "drawable", packageName)
                            image.setImageResource(id)
                        }
                    }
                }
                "Right" ->
                    when(tempDeco.decoType) {
                        "Wall" -> {
                            image = findViewById<ImageView>(R.id.wallDecoRight)
                            id = getResources().getIdentifier(link, "drawable", packageName)
                            image.setImageResource(id) }
                        "Table" -> {
                            image = findViewById<ImageView>(R.id.tableDecoRight)
                            id = getResources().getIdentifier(link, "drawable", packageName)
                            image.setImageResource(id)
                        }
                        "Tank" -> {
                            image = findViewById<ImageView>(R.id.tankDecoRight)
                            id = getResources().getIdentifier(link, "drawable", packageName)
                            image.setImageResource(id)
                        }
                    }
                "Center" ->
                    when(tempDeco.decoType) {
                        "Wall" -> {
                            image = findViewById<ImageView>(R.id.wallDecoCenter)
                            id = getResources().getIdentifier(link, "drawable", packageName)
                            image.setImageResource(id)
                        }
                        "Table" -> {
                            image = findViewById<ImageView>(R.id.tableDecoCenter)
                            id = getResources().getIdentifier(link, "drawable", packageName)
                            image.setImageResource(id)
                        }
                        "Tank" -> {
                            image = findViewById<ImageView>(R.id.tankDecoCenter)
                            id = getResources().getIdentifier(link, "drawable", packageName)
                            image.setImageResource(id)
                        }
                    }
                null -> {}
                "NA" -> {}
                else -> Log.e(TankActivity.TAG, "Unable to place Decoration " + tempDeco.name)
            }
        }

        listMaker.executeFish()
        val fishList: List<Fish> = listMaker.fishList
        var fishCount = 0
        for(tempFish in fishList) {
            link = tempFish.imageLink.split(".")[0]
            if(tempFish.owned && tempFish.placed) {
                when(fishCount){
                    0 -> {
                        image = findViewById<ImageView>(R.id.fishLeft)
                        id = getResources().getIdentifier(link, "drawable", packageName)
                        image.setImageResource(id)
                    }
                    1 -> {
                        image = findViewById<ImageView>(R.id.tankDecoCenter)
                        id = getResources().getIdentifier(link, "drawable", packageName)
                        image.setImageResource(id)
                    }
                    2 -> {
                        image = findViewById<ImageView>(R.id.tankDecoRight)
                        id = getResources().getIdentifier(link, "drawable", packageName)
                        image.setImageResource(id)
                    }
                    else -> Log.e(TankActivity.TAG, "Too many placed fish, unable to place: " + tempFish.name)
                }
                fishCount++
            }
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

        listMaker.executeStatistics()
        statistics = listMaker.getStatistics()
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