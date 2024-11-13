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

        val DivingIn = findViewById<ImageView>(R.id.DivingInImage)
        val Finship = findViewById<ImageView>(R.id.FinshipImage)
        val HabitStarter = findViewById<ImageView>(R.id.HabitStarterImage)
        val HabitMaster = findViewById<ImageView>(R.id.HabitMasterImage)
        val NovicePlanner = findViewById<ImageView>(R.id.NovicePlannerImage)
        val MasterPlanner = findViewById<ImageView>(R.id.MasterPlannerImage)
        val PetOwner = findViewById<ImageView>(R.id.PetOwnerImage)
        val PetShop = findViewById<ImageView>(R.id.PetShopImage)
        val WindowShopper = findViewById<ImageView>(R.id.WindowShopperImage)
        val Shopaholic = findViewById<ImageView>(R.id.ShopaholicImage)
        val InteriorDesign = findViewById<ImageView>(R.id.InteriorDesignImage)
        val IKEAShowroom = findViewById<ImageView>(R.id.IKEAShowroomImage)
        val FishyFriend = findViewById<ImageView>(R.id.FishyFriendImage)
        val FishyFollowing = findViewById<ImageView>(R.id.FishyFollowingImage)

        DivingIn.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Diving In")
                bundle.putString("goal", "1")
                bundle.putString("goalType", "Task Made")
                bundle.putString("Reward", "10 Fish Food")
                bundle.putString("state", "Achieved")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        Finship.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Finship")
                bundle.putString("goal", "1")
                bundle.putString("goalType", "Fish Collected")
                bundle.putString("Reward", "10 Fish Food")
                bundle.putString("state", "Achieved")
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
                bundle.putString("goal", "5")
                bundle.putString("goalType", "Task Completed")
                bundle.putString("Reward", "15 Fish Food")
                bundle.putString("state", "Achieved")
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
                bundle.putString("name", "Habit Master")
                bundle.putString("goal", "20")
                bundle.putString("goalType", "Task Completed")
                bundle.putString("Reward", "100 Fish Food")
                bundle.putString("state", "Locked")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        var clicked = 0;
        NovicePlanner.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Novice Planner")
                bundle.putString("goal", "5")
                bundle.putString("goalType", "Task Made")
                bundle.putString("Reward", "10 Fish Food")
                if (clicked == 0) {
                    bundle.putString("state", "Earned")
                    clicked++
                } else {
                    bundle.putString("state", "Achieved")
                }
                intent.putExtras(bundle)
                startActivity(intent)
                NovicePlanner.setImageResource(R.drawable.star_achieved)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        MasterPlanner.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Master Planner")
                bundle.putString("goal", "25")
                bundle.putString("goalType", "Task Made")
                bundle.putString("Reward", "50 Fish Food")
                bundle.putString("state", "Locked")
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
                bundle.putString("goal", "5")
                bundle.putString("goalType", "Fish Collected")
                bundle.putString("Reward", "Plush Toy")
                bundle.putString("state", "Locked")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        PetShop.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Pet Shop")
                bundle.putString("goal", "20")
                bundle.putString("goalType", "Fish Collected")
                bundle.putString("Reward", "75 Fish Food")
                bundle.putString("state", "Achieved")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        WindowShopper.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Window Shopper")
                bundle.putString("goal", "1")
                bundle.putString("goalType", "Decorations Bought")
                bundle.putString("Reward", "15 Fish Food")
                bundle.putString("state", "Locked")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        Shopaholic.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Shopaholic")
                bundle.putString("goal", "15")
                bundle.putString("goalType", "Decorations Bought")
                bundle.putString("Reward", "100 Fish Food")
                bundle.putString("state", "Locked")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        InteriorDesign.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Interior Design")
                bundle.putString("goal", "1")
                bundle.putString("goalType", "Decorations Placed")
                bundle.putString("Reward", "Desk Lamp")
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
                bundle.putString("name", "IKEA Showroom")
                bundle.putString("goal", "6")
                bundle.putString("goalType", "Decoration Placed")
                bundle.putString("Reward", "Hanging Plant")
                bundle.putString("state", "Locked")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        FishyFriend.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Fishy Friend")
                bundle.putString("goal", "1")
                bundle.putString("goalType", "Fish Displayed")
                bundle.putString("Reward", "10 Fish Food")
                bundle.putString("state", "Locked")
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        FishyFollowing.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", "Fishy Following")
                bundle.putString("goal", "5")
                bundle.putString("goalType", "Fish Displayed")
                bundle.putString("Reward", "Treasure Chest")
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