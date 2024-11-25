package ca.unb.mobiledev.team5project

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.unb.mobiledev.team5project.model.Achievement
import ca.unb.mobiledev.team5project.model.Statistics
import ca.unb.mobiledev.team5project.util.ListMaker
import com.google.android.material.bottomnavigation.BottomNavigationView

class AchieveActivity : AppCompatActivity() {
    lateinit var achievementList: ArrayList<Achievement>
    lateinit var statistics: Statistics
    lateinit var foodCount: TextView
    lateinit var ListMaker: ListMaker
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
                        Log.e(TAG, "Unable to start the activity")
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
                        Log.e(TAG, "Unable to start the activity")
                    }
                    finish()
                }
                R.id.fish -> {
                    val intent = Intent(this, FishActivity::class.java)
                    try {
                        startActivity(intent)
                    } catch (ex: ActivityNotFoundException) {
                        Log.e(TAG, "Unable to start the activity")
                    }
                    finish()
                }
            }

            return@setOnItemSelectedListener true
        }
        ListMaker = ListMaker(this)
        ListMaker.executeAchievements()
        achievementList = ListMaker.getAchievementList()
        ListMaker.executeStatistics()
        statistics = ListMaker.getStatistics()
        foodCount = findViewById(R.id.foodCount)
        foodCount.text = statistics.Fishfood.toString()
        val title = findViewById<TextView>(R.id.textView)
        title.text = "${statistics.Username}'s Achievements"


        for(achieve in achievementList){
            if (achieve.goalType.equals("Task Made")){
                if(achieve.goal <= statistics.TaskMade && achieve.state.equals("Locked")){
                    ListMaker.updateAchieveState(achieve.name!!, achieve.state!!)
                    achieve.state = "Earned"
                }
            } else if (achieve.goalType.equals("Task Completed")){
                if(achieve.goal <= statistics.TaskCompleted && achieve.state.equals("Locked")){
                    ListMaker.updateAchieveState(achieve.name!!, achieve.state!!)
                    achieve.state = "Earned"
                }
            } else if (achieve.goalType.equals("Fish Collected")){
                if(achieve.goal <= statistics.FishCollected && achieve.state.equals("Locked")){
                    ListMaker.updateAchieveState(achieve.name!!, achieve.state!!)
                    achieve.state = "Earned"
                }
            } else if (achieve.goalType.equals("Fish Displayed")){
                if(achieve.goal <= statistics.FishDisplayed && achieve.state.equals("Locked")){
                    ListMaker.updateAchieveState(achieve.name!!, achieve.state!!)
                    achieve.state = "Earned"
                }
            } else if (achieve.goalType.equals("Decoration Bought")){
                if(achieve.goal <= statistics.DecorationBought && achieve.state.equals("Locked")){
                    ListMaker.updateAchieveState(achieve.name!!, achieve.state!!)
                    achieve.state = "Earned"
                }
            } else if (achieve.goalType.equals("Decoration Placed")){
                if(achieve.goal <= statistics.DecorationPlaced && achieve.state.equals("Locked")){
                    ListMaker.updateAchieveState(achieve.name!!, achieve.state!!)
                    achieve.state = "Earned"
                }
            }
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

        val DivingInText = findViewById<TextView>(R.id.DivingInText)
        val FinshipText = findViewById<TextView>(R.id.FinshipText)
        val HabitStarterText = findViewById<TextView>(R.id.HabitStarterText)
        val HabitMasterText = findViewById<TextView>(R.id.HabitMasterText)
        val NovicePlannerText = findViewById<TextView>(R.id.NovicePlannerText)
        val MasterPlannerText = findViewById<TextView>(R.id.MasterPlannerText)
        val PetOwnerText = findViewById<TextView>(R.id.PetOwnerText)
        val PetShopText = findViewById<TextView>(R.id.PetShopText)
        val WindowShopperText = findViewById<TextView>(R.id.WindowShopperText)
        val ShopaholicText = findViewById<TextView>(R.id.ShopaholicText)
        val InteriorDesignText = findViewById<TextView>(R.id.InteriorDesignText)
        val IKEAShowroomText = findViewById<TextView>(R.id.IKEAShowroomText)
        val FishyFriendText = findViewById<TextView>(R.id.FishyFriendText)
        val FishyFollowingText = findViewById<TextView>(R.id.FishyFollowingText)

        setDetails(achievementList.get(0), DivingIn,DivingInText)
        setDetails(achievementList.get(1), Finship, FinshipText)
        setDetails(achievementList.get(2), HabitStarter, HabitStarterText)
        setDetails(achievementList.get(3), HabitMaster, HabitMasterText)
        setDetails(achievementList.get(4), NovicePlanner, NovicePlannerText)
        setDetails(achievementList.get(5), MasterPlanner, MasterPlannerText)
        setDetails(achievementList.get(6), PetOwner, PetOwnerText)
        setDetails(achievementList.get(7), PetShop, PetShopText)
        setDetails(achievementList.get(8), WindowShopper, WindowShopperText)
        setDetails(achievementList.get(9), Shopaholic, ShopaholicText)
        setDetails(achievementList.get(10), InteriorDesign, InteriorDesignText)
        setDetails(achievementList.get(11), IKEAShowroom, IKEAShowroomText)
        setDetails(achievementList.get(12), FishyFriend, FishyFriendText)
        setDetails(achievementList.get(13), FishyFollowing, FishyFollowingText)

        DivingIn.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", achievementList.get(0).name)
                bundle.putInt("goal", achievementList.get(0).goal)
                bundle.putString("goalType", achievementList.get(0).goalType)
                bundle.putString("Reward", achievementList.get(0).reward)
                bundle.putString("rewardCode", achievementList.get(0).rewardCode)
                bundle.putString("state", achievementList.get(0).state)
                bundle.putInt("progress", statistics.TaskMade)
                intent.putExtras(bundle)
                startActivity(intent)
                if(achievementList.get(0).state.equals("Earned")){
                    achievementList.get(0).state = "Achieved"
                    setDetails(achievementList.get(0), DivingIn, DivingInText)
                }
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        Finship.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", achievementList.get(1).name)
                bundle.putInt("goal", achievementList.get(1).goal)
                bundle.putString("goalType", achievementList.get(1).goalType)
                bundle.putString("Reward", achievementList.get(1).reward)
                bundle.putString("rewardCode", achievementList.get(1).rewardCode)
                bundle.putString("state", achievementList.get(1).state)
                bundle.putInt("progress", statistics.FishCollected)
                intent.putExtras(bundle)
                startActivity(intent)
                if(achievementList.get(1).state.equals("Earned")){
                    achievementList.get(1).state = "Achieved"
                    setDetails(achievementList.get(1), Finship, FinshipText)
                }
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        HabitStarter.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", achievementList.get(2).name)
                bundle.putInt("goal", achievementList.get(2).goal)
                bundle.putString("goalType", achievementList.get(2).goalType)
                bundle.putString("Reward", achievementList.get(2).reward)
                bundle.putString("rewardCode", achievementList.get(2).rewardCode)
                bundle.putString("state", achievementList.get(2).state)
                bundle.putInt("progress", statistics.TaskCompleted)
                intent.putExtras(bundle)
                startActivity(intent)
                if(achievementList.get(2).state.equals("Earned")){
                    achievementList.get(2).state = "Achieved"
                    setDetails(achievementList.get(2), HabitStarter, HabitStarterText)
                }
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        HabitMaster.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", achievementList.get(3).name)
                bundle.putInt("goal", achievementList.get(3).goal)
                bundle.putString("goalType", achievementList.get(3).goalType)
                bundle.putString("Reward", achievementList.get(3).reward)
                bundle.putString("rewardCode", achievementList.get(3).rewardCode)
                bundle.putString("state", achievementList.get(3).state)
                bundle.putInt("progress", statistics.TaskCompleted)
                intent.putExtras(bundle)
                startActivity(intent)
                if(achievementList.get(3).state.equals("Earned")){
                    achievementList.get(3).state = "Achieved"
                    setDetails(achievementList.get(3), HabitMaster, HabitMasterText)
                }
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        NovicePlanner.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", achievementList.get(4).name)
                bundle.putInt("goal", achievementList.get(4).goal)
                bundle.putString("goalType", achievementList.get(4).goalType)
                bundle.putString("Reward", achievementList.get(4).reward)
                bundle.putString("rewardCode", achievementList.get(4).rewardCode)
                bundle.putString("state", achievementList.get(4).state)
                bundle.putInt("progress", statistics.TaskMade)
                intent.putExtras(bundle)
                startActivity(intent)
                if(achievementList.get(4).state.equals("Earned")){
                    achievementList.get(4).state = "Achieved"
                    setDetails(achievementList.get(4), NovicePlanner, NovicePlannerText)
                }
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        MasterPlanner.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", achievementList.get(5).name)
                bundle.putInt("goal", achievementList.get(5).goal)
                bundle.putString("goalType", achievementList.get(5).goalType)
                bundle.putString("Reward", achievementList.get(5).reward)
                bundle.putString("rewardCode", achievementList.get(5).rewardCode)
                bundle.putString("state", achievementList.get(5).state)
                bundle.putInt("progress", statistics.TaskMade)
                intent.putExtras(bundle)
                startActivity(intent)
                if(achievementList.get(5).state.equals("Earned")){
                    achievementList.get(5).state = "Achieved"
                    setDetails(achievementList.get(5), MasterPlanner, MasterPlannerText)
                }
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        PetOwner.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", achievementList.get(6).name)
                bundle.putInt("goal", achievementList.get(6).goal)
                bundle.putString("goalType", achievementList.get(6).goalType)
                bundle.putString("Reward", achievementList.get(6).reward)
                bundle.putString("rewardCode", achievementList.get(6).rewardCode)
                bundle.putString("state", achievementList.get(6).state)
                bundle.putInt("progress", statistics.FishCollected)
                intent.putExtras(bundle)
                startActivity(intent)
                if(achievementList.get(6).state.equals("Earned")){
                    achievementList.get(6).state = "Achieved"
                    setDetails(achievementList.get(6), PetOwner, PetOwnerText)
                }
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        PetShop.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", achievementList.get(7).name)
                bundle.putInt("goal", achievementList.get(7).goal)
                bundle.putString("goalType", achievementList.get(7).goalType)
                bundle.putString("Reward", achievementList.get(7).reward)
                bundle.putString("rewardCode", achievementList.get(7).rewardCode)
                bundle.putString("state", achievementList.get(7).state)
                bundle.putInt("progress", statistics.FishCollected)
                intent.putExtras(bundle)
                startActivity(intent)
                if(achievementList.get(7).state.equals("Earned")){
                    achievementList.get(7).state = "Achieved"
                    setDetails(achievementList.get(7), PetShop, PetShopText)
                }
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        WindowShopper.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", achievementList.get(8).name)
                bundle.putInt("goal", achievementList.get(8).goal)
                bundle.putString("goalType", achievementList.get(8).goalType)
                bundle.putString("Reward", achievementList.get(8).reward)
                bundle.putString("rewardCode", achievementList.get(8).rewardCode)
                bundle.putString("state", achievementList.get(8).state)
                bundle.putInt("progress", statistics.DecorationBought)
                intent.putExtras(bundle)
                startActivity(intent)
                if(achievementList.get(8).state.equals("Earned")){
                    achievementList.get(8).state = "Achieved"
                    setDetails(achievementList.get(8), WindowShopper, WindowShopperText)
                }
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        Shopaholic.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", achievementList.get(9).name)
                bundle.putInt("goal", achievementList.get(9).goal)
                bundle.putString("goalType", achievementList.get(9).goalType)
                bundle.putString("Reward", achievementList.get(9).reward)
                bundle.putString("rewardCode", achievementList.get(9).rewardCode)
                bundle.putString("state", achievementList.get(9).state)
                bundle.putInt("progress", statistics.DecorationBought)
                intent.putExtras(bundle)
                startActivity(intent)
                if(achievementList.get(9).state.equals("Earned")){
                    achievementList.get(9).state = "Achieved"
                    setDetails(achievementList.get(9), Shopaholic, ShopaholicText)
                }
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        InteriorDesign.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", achievementList.get(10).name)
                bundle.putInt("goal", achievementList.get(10).goal)
                bundle.putString("goalType", achievementList.get(10).goalType)
                bundle.putString("Reward", achievementList.get(10).reward)
                bundle.putString("rewardCode", achievementList.get(10).rewardCode)
                bundle.putString("state", achievementList.get(10).state)
                bundle.putInt("progress", statistics.DecorationPlaced)
                intent.putExtras(bundle)
                startActivity(intent)
                if(achievementList.get(10).state.equals("Earned")){
                    achievementList.get(10).state = "Achieved"
                    setDetails(achievementList.get(10), InteriorDesign, InteriorDesignText)
                }
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        IKEAShowroom.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", achievementList.get(11).name)
                bundle.putInt("goal", achievementList.get(11).goal)
                bundle.putString("goalType", achievementList.get(11).goalType)
                bundle.putString("Reward", achievementList.get(11).reward)
                bundle.putString("rewardCode", achievementList.get(11).rewardCode)
                bundle.putString("state", achievementList.get(11).state)
                bundle.putInt("progress", statistics.DecorationPlaced)
                intent.putExtras(bundle)
                startActivity(intent)
                if(achievementList.get(11).state.equals("Earned")){
                    achievementList.get(11).state = "Achieved"
                    setDetails(achievementList.get(11), IKEAShowroom, IKEAShowroomText)
                }
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        FishyFriend.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", achievementList.get(12).name)
                bundle.putInt("goal", achievementList.get(12).goal)
                bundle.putString("goalType", achievementList.get(12).goalType)
                bundle.putString("Reward", achievementList.get(12).reward)
                bundle.putString("rewardCode", achievementList.get(12).rewardCode)
                bundle.putString("state", achievementList.get(12).state)
                bundle.putInt("progress", statistics.FishDisplayed)
                intent.putExtras(bundle)
                startActivity(intent)
                if(achievementList.get(12).state.equals("Earned")){
                    achievementList.get(12).state = "Achieved"
                    setDetails(achievementList.get(12), FishyFriend, FishyFriendText)
                }
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }
        FishyFollowing.setOnClickListener {
            val intent = Intent(this, AchievementDialog::class.java)
            try {
                val bundle = Bundle()
                bundle.putString("name", achievementList.get(13).name)
                bundle.putInt("goal", achievementList.get(13).goal)
                bundle.putString("goalType", achievementList.get(13).goalType)
                bundle.putString("Reward", achievementList.get(13).reward)
                bundle.putString("rewardCode", achievementList.get(13).rewardCode)
                bundle.putString("state", achievementList.get(13).state)
                bundle.putInt("progress", statistics.FishDisplayed)
                intent.putExtras(bundle)
                startActivity(intent)
                if(achievementList.get(13).state.equals("Earned")){
                    achievementList.get(13).state = "Achieved"
                    setDetails(achievementList.get(13), FishyFollowing, FishyFollowingText)
                }
            } catch (ex: ActivityNotFoundException) {
                Log.e(TAG, "Unable to start the activity")
            }
        }

    }

    private fun setDetails(achievement: Achievement, image: ImageView, text: TextView){
        if(achievement.state.equals("Locked")){
            image.setImageResource(R.drawable.star_locked)
            text.text = "[Locked]"
        } else if(achievement.state.equals("Achieved")){
            image.setImageResource(R.drawable.star_achieved)
            text.text = "${achievement.name}"
        } else {
            image.setImageResource(R.drawable.star_earned)
            text.text = "${achievement.name}"
        }
    }

    override fun onResume() {
        super.onResume()
        ListMaker.executeStatistics()
        statistics = ListMaker.getStatistics()
        foodCount.text = statistics.Fishfood.toString()
    }

    companion object {
        // String for LogCat documentation
        const val TAG = "Achieve Activity"
    }
}