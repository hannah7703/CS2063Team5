package ca.unb.mobiledev.team5project

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.unb.mobiledev.team5project.util.ListMaker

class AchievementDialog : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_achievement)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.achieveDialog)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listMaker = ListMaker(this)
        val bundle = intent.extras
        val achieved = findViewById<ImageView>(R.id.achieved)
        val locked = findViewById<ImageView>(R.id.locked)
        val state = bundle?.getString("state")
        val name = bundle?.getString("name")
        val title = findViewById<TextView>(R.id.achievementTitle)
        val goal = findViewById<TextView>(R.id.achievementGoal)
        val goalAmount = bundle?.getInt("goal")
        val goalType = bundle?.getString("goalType")
        val progress = bundle?.getInt("progress")
        if (state.equals("Locked")){
            goal.text = "$progress/$goalAmount $goalType"
            title.text = "Locked"
        } else {
            goal.text = "$goalAmount/$goalAmount $goalType"
            title.text = name
        }
        val reward = findViewById<TextView>(R.id.acheiveReward)
        val rewardText = bundle?.getString("Reward")
        reward.text = "Reward: $rewardText"

        val acceptBtn = findViewById<Button>(R.id.accept)
        acceptBtn.visibility = View.INVISIBLE
        acceptBtn.setOnClickListener{
            if (name != null && state != null) {
                listMaker.updateAchieveState(name, state)
            }
            val rewardCode = bundle?.getString("rewardCode")
            val type = rewardCode?.substring(0, 2)
            val rewardvalue = rewardCode?.substring(2)
            if(type.equals("FF")){
                listMaker.executeStatistics()
                val statistics = listMaker.getStatistics()
                if (rewardvalue != null) {
                    listMaker.updateStatistics("Fish food", statistics.Fishfood,true, rewardvalue.toInt())
                }
            } else {
                listMaker.executeDecorations()
                val decoList = listMaker.getDecorationList()
                var decoReward = ""
                for(deco in decoList){
                    if(deco.decoCode.equals(rewardvalue)){
                        decoReward = deco.name.toString()
                        break
                    }
                }
                if (name != null) {
                    listMaker.buyDecoration(decoReward)
                }
            }
            finish()
        }
        val closeBtn = findViewById<Button>(R.id.button)
        closeBtn.setOnClickListener{
            finish()
        }

        if (state.equals("Locked")){
            locked.visibility = View.VISIBLE
            achieved.visibility = View.INVISIBLE
        } else {
            locked.visibility = View.INVISIBLE
            achieved.visibility = View.VISIBLE
        }
        if (state.equals("Earned")){
            acceptBtn.visibility = View.VISIBLE
            closeBtn.visibility = View.INVISIBLE
        }

    }
}