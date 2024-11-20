package ca.unb.mobiledev.team5project

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.unb.mobiledev.team5project.model.Decoration
import ca.unb.mobiledev.team5project.model.Statistics
import ca.unb.mobiledev.team5project.util.ListMaker
import com.google.android.material.bottomnavigation.BottomNavigationView

class StoreActivity : AppCompatActivity() {
    lateinit var decoList: ArrayList<Decoration>
    lateinit var ListMaker: ListMaker
    lateinit var statistics: Statistics
    lateinit var foodCount: TextView

    lateinit var  photoFood: ImageView
    lateinit var  clockFood: ImageView
    lateinit var  plantFood: ImageView
    lateinit var  cradleFood: ImageView
    lateinit var  snowFood: ImageView
    lateinit var  castleFood: ImageView
    lateinit var  weedFood: ImageView
    lateinit var  diverFood: ImageView

    lateinit var  PhotoText: TextView
    lateinit var  ClockText: TextView
    lateinit var  PlantText: TextView
    lateinit var  CradleText: TextView
    lateinit var  SnowText: TextView
    lateinit var  CastleText: TextView
    lateinit var  seaweedText: TextView
    lateinit var  diverText: TextView
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

        val framedPhoto = findViewById<ImageView>(R.id.framedPhotoImage)
        val wallClock = findViewById<ImageView>(R.id.wallClockImage)
        val housePlant = findViewById<ImageView>(R.id.housePlantImage)
        val newtonsCradle = findViewById<ImageView>(R.id.newtonsCradleImage)
        val snowGlobe = findViewById<ImageView>(R.id.snowglobe)
        val castle = findViewById<ImageView>(R.id.castle)
        val seaweed = findViewById<ImageView>(R.id.seaweed)
        val diver = findViewById<ImageView>(R.id.diver)

        photoFood = findViewById(R.id.PhotoFood)
        clockFood = findViewById(R.id.ClockFood)
        plantFood = findViewById(R.id.PlantFood)
        cradleFood = findViewById(R.id.CradleFood)
        snowFood = findViewById(R.id.snowFood)
        castleFood = findViewById(R.id.castleFood)
        weedFood = findViewById(R.id.weedFood)
        diverFood = findViewById(R.id.diverFood)

        PhotoText = findViewById(R.id.framedPhotoText)
        ClockText = findViewById(R.id.wallClockText)
        PlantText = findViewById(R.id.housePlantText)
        CradleText = findViewById(R.id.newtonsCradleText)
        SnowText = findViewById(R.id.snowGlobeText)
        CastleText = findViewById(R.id.castleText)
        seaweedText = findViewById(R.id.seaweedText)
        diverText = findViewById(R.id.diverText)

        ListMaker = ListMaker(this)
        ListMaker.executeDecorations()
        decoList = ListMaker.getDecorationList()
        ListMaker.executeStatistics()
        statistics = ListMaker.getStatistics()
        foodCount = findViewById<TextView>(R.id.foodCount)
        foodCount.text = statistics.Fishfood.toString()

        setDetails(decoList.get(0), photoFood, PhotoText)
        setDetails(decoList.get(1), clockFood, ClockText)
        setDetails(decoList.get(2), plantFood, PlantText)
        setDetails(decoList.get(3), cradleFood, CradleText)
        setDetails(decoList.get(4), snowFood, SnowText)
        setDetails(decoList.get(5), castleFood, CastleText)
        setDetails(decoList.get(6), weedFood, seaweedText)
        setDetails(decoList.get(7), diverFood, diverText)

        framedPhoto.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", decoList.get(0).name)
                bundle.putBoolean("owned", decoList.get(0).owned)
                bundle.putString("decoType", decoList.get(0).decoType)
                bundle.putString("placement", decoList.get(0).placement)
                bundle.putString("decoCode", decoList.get(0).decoCode)
                bundle.putString("cost", decoList.get(0).cost)
                bundle.putInt("food", statistics.Fishfood)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        wallClock.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", decoList.get(1).name)
                bundle.putBoolean("owned", decoList.get(1).owned)
                bundle.putString("decoType", decoList.get(1).decoType)
                bundle.putString("placement", decoList.get(1).placement)
                bundle.putString("decoCode", decoList.get(1).decoCode)
                bundle.putString("cost", decoList.get(1).cost)
                bundle.putInt("food", statistics.Fishfood)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        housePlant.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", decoList.get(2).name)
                bundle.putBoolean("owned", decoList.get(2).owned)
                bundle.putString("decoType", decoList.get(2).decoType)
                bundle.putString("placement", decoList.get(2).placement)
                bundle.putString("decoCode", decoList.get(2).decoCode)
                bundle.putString("cost", decoList.get(0).cost)
                bundle.putInt("food", statistics.Fishfood)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        newtonsCradle.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", decoList.get(3).name)
                bundle.putBoolean("owned", decoList.get(3).owned)
                bundle.putString("decoType", decoList.get(3).decoType)
                bundle.putString("placement", decoList.get(3).placement)
                bundle.putString("decoCode", decoList.get(3).decoCode)
                bundle.putString("cost", decoList.get(3).cost)
                bundle.putInt("food", statistics.Fishfood)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        snowGlobe.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", decoList.get(4).name)
                bundle.putBoolean("owned", decoList.get(4).owned)
                bundle.putString("decoType", decoList.get(4).decoType)
                bundle.putString("placement", decoList.get(4).placement)
                bundle.putString("decoCode", decoList.get(4).decoCode)
                bundle.putString("cost", decoList.get(4).cost)
                bundle.putInt("food", statistics.Fishfood)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        castle.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", decoList.get(5).name)
                bundle.putBoolean("owned", decoList.get(5).owned)
                bundle.putString("decoType", decoList.get(5).decoType)
                bundle.putString("placement", decoList.get(5).placement)
                bundle.putString("decoCode", decoList.get(5).decoCode)
                bundle.putString("cost", decoList.get(5).cost)
                bundle.putInt("food", statistics.Fishfood)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        seaweed.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", decoList.get(6).name)
                bundle.putBoolean("owned", decoList.get(6).owned)
                bundle.putString("decoType", decoList.get(6).decoType)
                bundle.putString("placement", decoList.get(6).placement)
                bundle.putString("decoCode", decoList.get(6).decoCode)
                bundle.putString("cost", decoList.get(6).cost)
                bundle.putInt("food", statistics.Fishfood)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        diver.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", decoList.get(7).name)
                bundle.putBoolean("owned", decoList.get(7).owned)
                bundle.putString("decoType", decoList.get(7).decoType)
                bundle.putString("placement", decoList.get(7).placement)
                bundle.putString("decoCode", decoList.get(7).decoCode)
                bundle.putString("cost", decoList.get(7).cost)
                bundle.putInt("food", statistics.Fishfood)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
    }

    private fun setDetails(decoration: Decoration, food: ImageView, text: TextView){
        if(decoration.owned){
            text.text = "Owned"
            text.setTextColor(Color.BLUE)
        } else if(decoration.cost.toInt() > statistics.Fishfood){ //Change this to be dynamic
            text.text = decoration.cost
            text.setTextColor(Color.RED)
        } else {
            text.text = decoration.cost
            text.setTextColor(Color.BLACK)
        }
    }

    override fun onResume() {
        super.onResume()
        ListMaker.executeDecorations()
        decoList = ListMaker.getDecorationList()

        photoFood = findViewById(R.id.PhotoFood)
        clockFood = findViewById(R.id.ClockFood)
        plantFood = findViewById(R.id.PlantFood)
        cradleFood = findViewById(R.id.CradleFood)
        snowFood = findViewById(R.id.snowFood)
        castleFood = findViewById(R.id.castleFood)

        PhotoText = findViewById(R.id.framedPhotoText)
        ClockText = findViewById(R.id.wallClockText)
        PlantText = findViewById(R.id.housePlantText)
        CradleText = findViewById(R.id.newtonsCradleText)
        SnowText = findViewById(R.id.snowGlobeText)
        CastleText = findViewById(R.id.castleText)

        setDetails(decoList.get(0), photoFood, PhotoText)
        setDetails(decoList.get(1), clockFood, ClockText)
        setDetails(decoList.get(2), plantFood, PlantText)
        setDetails(decoList.get(3), cradleFood, CradleText)
        setDetails(decoList.get(4), snowFood, SnowText)
        setDetails(decoList.get(5), castleFood, CastleText)

        ListMaker.executeStatistics()
        statistics = ListMaker.getStatistics()
        foodCount.text = statistics.Fishfood.toString()
    }
    companion object {
        // String for LogCat documentation
        const val TAG = "Store Activity"
    }
}