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

    lateinit var  PhotoText: TextView
    lateinit var  PlantText: TextView
    lateinit var  SnowText: TextView
    lateinit var  CastleText: TextView
    lateinit var  seaweedText: TextView
    lateinit var signText: TextView
    lateinit var bookText: TextView
    lateinit var plushText: TextView
    lateinit var hangText: TextView
    lateinit var treasureText: TextView
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
        val housePlant = findViewById<ImageView>(R.id.housePlantImage)
        val snowGlobe = findViewById<ImageView>(R.id.snowglobe)
        val castle = findViewById<ImageView>(R.id.castle)
        val seaweed = findViewById<ImageView>(R.id.seaweed)
        val sign = findViewById<ImageView>(R.id.neonSign)
        val books = findViewById<ImageView>(R.id.books)
        val plush = findViewById<ImageView>(R.id.plushToy)
        val hangingPlant = findViewById<ImageView>(R.id.hangingPlant)
        val treasure = findViewById<ImageView>(R.id.treasure)

        ListMaker = ListMaker(this)
        ListMaker.executeDecorations()
        decoList = ListMaker.getDecorationList()
        ListMaker.executeStatistics()
        statistics = ListMaker.getStatistics()
        foodCount = findViewById(R.id.foodCount)
        foodCount.text = statistics.Fishfood.toString()

        framedPhoto.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", decoList.get(0).name)
                bundle.putBoolean("owned", decoList.get(0).owned)
                bundle.putString("cost", decoList.get(0).cost)
                bundle.putString("decoType", decoList.get(0).decoType)
                bundle.putString("placement", decoList.get(0).placement)
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
                bundle.putString("name", decoList.get(1).name)
                bundle.putBoolean("owned", decoList.get(1).owned)
                bundle.putString("cost", decoList.get(1).cost)
                bundle.putString("decoType", decoList.get(1).decoType)
                bundle.putString("placement", decoList.get(1).placement)
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
                bundle.putString("name", decoList.get(2).name)
                bundle.putBoolean("owned", decoList.get(2).owned)
                bundle.putString("cost", decoList.get(2).cost)
                bundle.putString("decoType", decoList.get(2).decoType)
                bundle.putString("placement", decoList.get(2).placement)
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
                bundle.putString("name", decoList.get(3).name)
                bundle.putBoolean("owned", decoList.get(3).owned)
                bundle.putString("cost", decoList.get(3).cost)
                bundle.putString("decoType", decoList.get(3).decoType)
                bundle.putString("placement", decoList.get(3).placement)
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
                bundle.putString("name", decoList.get(4).name)
                bundle.putBoolean("owned", decoList.get(4).owned)
                bundle.putString("cost", decoList.get(4).cost)
                bundle.putString("decoType", decoList.get(4).decoType)
                bundle.putString("placement", decoList.get(4).placement)
                bundle.putInt("food", statistics.Fishfood)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        sign.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", decoList.get(5).name)
                bundle.putBoolean("owned", decoList.get(5).owned)
                bundle.putString("cost", decoList.get(5).cost)
                bundle.putString("decoType", decoList.get(5).decoType)
                bundle.putString("placement", decoList.get(5).placement)
                bundle.putInt("food", statistics.Fishfood)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        books.setOnClickListener {
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", decoList.get(6).name)
                bundle.putBoolean("owned", decoList.get(6).owned)
                bundle.putString("cost", decoList.get(6).cost)
                bundle.putString("decoType", decoList.get(6).decoType)
                bundle.putString("placement", decoList.get(6).placement)
                bundle.putInt("food", statistics.Fishfood)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        plush.setOnClickListener{
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", decoList.get(7).name)
                bundle.putBoolean("owned", decoList.get(7).owned)
                bundle.putString("cost", decoList.get(7).cost)
                bundle.putString("decoType", decoList.get(7).decoType)
                bundle.putString("placement", decoList.get(7).placement)
                bundle.putInt("food", statistics.Fishfood)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        hangingPlant.setOnClickListener{
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", decoList.get(8).name)
                bundle.putBoolean("owned", decoList.get(8).owned)
                bundle.putString("cost", decoList.get(8).cost)
                bundle.putString("decoType", decoList.get(8).decoType)
                bundle.putString("placement", decoList.get(8).placement)
                bundle.putInt("food", statistics.Fishfood)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        treasure.setOnClickListener{
            val intent = Intent(this, StoreDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", decoList.get(9).name)
                bundle.putBoolean("owned", decoList.get(9).owned)
                bundle.putString("cost", decoList.get(9).cost)
                bundle.putString("decoType", decoList.get(9).decoType)
                bundle.putString("placement", decoList.get(9).placement)
                bundle.putInt("food", statistics.Fishfood)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
    }

    private fun setDetails(decoration: Decoration, text: TextView){
        if(decoration.placement != "NA"){
            text.text = "Placed"
            text.setTextColor(Color.BLUE)
        }else if(decoration.owned){
            text.text = "Owned"
            text.setTextColor(Color.BLUE)
        } else if(decoration.cost.equals("")){
            text.text = "[Locked]"
        } else if(decoration.cost.toInt() > statistics.Fishfood){
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

        PhotoText = findViewById(R.id.framedPhotoText)
        PlantText = findViewById(R.id.housePlantText)
        SnowText = findViewById(R.id.snowGlobeText)
        CastleText = findViewById(R.id.castleText)
        seaweedText = findViewById(R.id.seaweedText)
        signText = findViewById(R.id.neonSignText)
        bookText = findViewById(R.id.bookText)
        plushText = findViewById(R.id.plushText)
        hangText = findViewById(R.id.hangText)
        treasureText = findViewById(R.id.treasureText)

        setDetails(decoList.get(0), PhotoText)
        setDetails(decoList.get(1), PlantText)
        setDetails(decoList.get(2), SnowText)
        setDetails(decoList.get(3), CastleText)
        setDetails(decoList.get(4), seaweedText)
        setDetails(decoList.get(5), signText)
        setDetails(decoList.get(6), bookText)
        setDetails(decoList.get(7), plushText)
        setDetails(decoList.get(8), hangText)
        setDetails(decoList.get(9), treasureText)

        ListMaker.executeStatistics()
        statistics = ListMaker.getStatistics()
        foodCount.text = statistics.Fishfood.toString()
    }
    companion object {
        // String for LogCat documentation
        const val TAG = "Store Activity"
    }
}