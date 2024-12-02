package ca.unb.mobiledev.team5project

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.unb.mobiledev.team5project.model.Decoration
import ca.unb.mobiledev.team5project.model.Fish
import ca.unb.mobiledev.team5project.model.Statistics
import ca.unb.mobiledev.team5project.util.ListMaker
import com.google.android.material.bottomnavigation.BottomNavigationView

class FishActivity : AppCompatActivity() {
    lateinit var fishList: ArrayList<Fish>
    lateinit var ListMaker: ListMaker
    lateinit var statistics: Statistics
    lateinit var foodCount: TextView

    lateinit var bettaText: TextView
    lateinit var zebraText: TextView
    lateinit var catfishText: TextView
    lateinit var guppyText: TextView
    lateinit var cichlidText: TextView
    lateinit var discusText: TextView
    lateinit var tangText: TextView
    lateinit var goldText: TextView

    lateinit var betta: ImageView
    lateinit var zebra: ImageView
    lateinit var catfish: ImageView
    lateinit var guppy: ImageView
    lateinit var cichlid: ImageView
    lateinit var discus: ImageView
    lateinit var tang: ImageView
    lateinit var gold: ImageView

    private lateinit var gestureDetector: GestureDetector
    private val swipeWidth = 100
    private val swipeVelocity = 100
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
        ListMaker = ListMaker(this)
        fishList = ListMaker.executeFish()
        ListMaker.executeStatistics()
        statistics = ListMaker.getStatistics()
        val foodCount = findViewById<TextView>(R.id.foodCount)
        foodCount.text = statistics.Fishfood.toString()
        val title = findViewById<TextView>(R.id.textView)
        title.text = "${statistics.Username}'s Fish"

        betta = findViewById(R.id.betta)
        zebra = findViewById(R.id.zebrafish)
        catfish = findViewById(R.id.catfish)
        guppy = findViewById(R.id.guppy)
        cichlid = findViewById(R.id.cichlid)
        discus = findViewById(R.id.discus)
        tang = findViewById(R.id.blueTang)
        gold = findViewById(R.id.goldfish)

        betta.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", fishList.get(0).name)
                bundle.putString("type", fishList.get(0).type)
                bundle.putBoolean("owned", fishList.get(0).owned)
                bundle.putBoolean("placed", fishList.get(0).placed)
                bundle.putString("link", fishList.get(0).imageLink)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        zebra.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", fishList.get(1).name)
                bundle.putString("type", fishList.get(1).type)
                bundle.putBoolean("owned", fishList.get(1).owned)
                bundle.putBoolean("placed", fishList.get(1).placed)
                bundle.putString("link", fishList.get(1).imageLink)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        catfish.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", fishList.get(2).name)
                bundle.putString("type", fishList.get(2).type)
                bundle.putBoolean("owned", fishList.get(2).owned)
                bundle.putBoolean("placed", fishList.get(2).placed)
                bundle.putString("link", fishList.get(2).imageLink)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        guppy.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", fishList.get(3).name)
                bundle.putString("type", fishList.get(3).type)
                bundle.putBoolean("owned", fishList.get(3).owned)
                bundle.putBoolean("placed", fishList.get(3).placed)
                bundle.putString("link", fishList.get(3).imageLink)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        cichlid.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", fishList.get(4).name)
                bundle.putString("type", fishList.get(4).type)
                bundle.putBoolean("owned", fishList.get(4).owned)
                bundle.putBoolean("placed", fishList.get(4).placed)
                bundle.putString("link", fishList.get(4).imageLink)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        discus.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", fishList.get(5).name)
                bundle.putString("type", fishList.get(5).type)
                bundle.putBoolean("owned", fishList.get(5).owned)
                bundle.putBoolean("placed", fishList.get(5).placed)
                bundle.putString("link", fishList.get(5).imageLink)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        tang.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", fishList.get(6).name)
                bundle.putString("type", fishList.get(6).type)
                bundle.putBoolean("owned", fishList.get(6).owned)
                bundle.putBoolean("placed", fishList.get(6).placed)
                bundle.putString("link", fishList.get(6).imageLink)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
        gold.setOnClickListener{
            val intent = Intent(this, FishDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", fishList.get(7).name)
                bundle.putString("type", fishList.get(7).type)
                bundle.putBoolean("owned", fishList.get(7).owned)
                bundle.putBoolean("placed", fishList.get(7).placed)
                bundle.putString("link", fishList.get(7).imageLink)
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(AchieveActivity.TAG, "Unable to start the activity")
            }
        }
    }
    private fun setDetails(fish: Fish, text: TextView, image: ImageView){
        var link = fish.imageLink.substringBefore(".")
        link = link + "_bowl"
        if(fish.owned){
            text.text = fish.name
        } else {
            text.text = "[Locked]"
            link = link + "_dark"
        }
        val resID = getResources().getIdentifier(link, "drawable", packageName)
        image.setImageResource(resID)

        gestureDetector = GestureDetector(this, object : SimpleOnGestureListener() {
            override fun onDown(motionEvent: MotionEvent): Boolean {
                return false
            }

            override fun onFling(
                event1: MotionEvent?, event2: MotionEvent,
                velocityX: Float, velocityY: Float,
            ): Boolean {
                try {
                    val Ylength = event1!!.y - event2.y
                    val Xlength = event1.x - event2.x
                    if (Math.abs(Xlength) > Math.abs(Ylength)) {
                        if (Math.abs(Xlength) > swipeWidth && Math.abs(velocityX) > swipeVelocity) {
                            if (Xlength < 0) {
                                val intent = Intent(this@FishActivity, TankActivity::class.java)
                                try {
                                    startActivity(intent)
                                } catch (ex: ActivityNotFoundException) {
                                    Log.e(TaskActivity.TAG, "Unable to start the activity")
                                }
                                finish()
                            }
                        }
                    }
                }
                catch (exception: Exception) {
                    exception.printStackTrace()
                }
                return true
            }
        })
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (gestureDetector.onTouchEvent(event)) {
            true
        }
        else {
            super.onTouchEvent(event)
        }
    }

    override fun onResume() {
        super.onResume()
        ListMaker = ListMaker(this)
        fishList = ListMaker.executeFish()

        betta = findViewById(R.id.betta)
        zebra = findViewById(R.id.zebrafish)
        catfish = findViewById(R.id.catfish)
        guppy = findViewById(R.id.guppy)
        cichlid = findViewById(R.id.cichlid)
        discus = findViewById(R.id.discus)
        tang = findViewById(R.id.blueTang)
        gold = findViewById(R.id.goldfish)

        bettaText = findViewById(R.id.bettaText)
        zebraText = findViewById(R.id.zebraText)
        catfishText = findViewById(R.id.catfishText)
        guppyText = findViewById(R.id.guppyText)
        cichlidText = findViewById(R.id.cichlidText)
        discusText = findViewById(R.id.discusText)
        tangText = findViewById(R.id.tangText)
        goldText = findViewById(R.id.goldText)

        setDetails(fishList.get(0), bettaText, betta)
        setDetails(fishList.get(1), zebraText, zebra)
        setDetails(fishList.get(2), catfishText, catfish)
        setDetails(fishList.get(3), guppyText, guppy)
        setDetails(fishList.get(4), cichlidText, cichlid)
        setDetails(fishList.get(5), discusText, discus)
        setDetails(fishList.get(6), tangText, tang)
        setDetails(fishList.get(7), goldText, gold)
    }
    companion object {
        // String for LogCat documentation
        const val TAG = "Fish Activity"
    }
}