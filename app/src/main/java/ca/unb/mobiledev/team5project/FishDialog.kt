package ca.unb.mobiledev.team5project

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.unb.mobiledev.team5project.util.ListMaker
import org.w3c.dom.Text

class FishDialog: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_fish)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fishDialog)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras
        val owned = bundle?.getBoolean("owned")
        val name = bundle?.getString("name")
        val type = bundle?.getString("type")
        val placed = bundle?.getBoolean("placed")
        var link = bundle?.getString("link")
        if (link != null) {
            link = link.substringBefore(".")
        }
        link = link + "_bowl"

        val fishType = findViewById<TextView>(R.id.fishType)
        val fishName = findViewById<TextView>(R.id.FishNameEdit)
        val nameText = findViewById<TextView>(R.id.textView14)
        val displayCheck = findViewById<CheckBox>(R.id.checkBox)
        val image = findViewById<ImageView>(R.id.fish)
        val exitBtn = findViewById<Button>(R.id.button)
        val message = findViewById<TextView>(R.id.FullMessage)
        exitBtn.setOnClickListener{
            val listMaker = ListMaker(this)
            listMaker.executeFish()
            if(displayCheck.isChecked != placed){
                listMaker.executeStatistics()
                val stats = listMaker.getStatistics()
                if (type != null) {
                    listMaker.updateFish(type, displayCheck.isChecked, "placed")
                    if(displayCheck.isChecked){
                        listMaker.updateStatistics("Fish Displayed", stats.FishDisplayed,true, 1)
                    } else {
                        listMaker.updateStatistics("Fish Displayed", stats.FishDisplayed,false, 1)
                    }
                }
            }
            if(!fishName.text.equals(name)){
                if (name != null) {
                    listMaker.renameFish(name, fishName.text.toString())
                }
            }
            finish()
        }


        if(!owned!!){
            fishType.text = "[Locked]"
            nameText.text = "Complete Tasks to\n           Unlock"
            fishName.visibility = View.INVISIBLE
            displayCheck.visibility = View.INVISIBLE
            link = link + "_dark"
            message.visibility = View.INVISIBLE
        } else {
            fishType.text = type
            nameText.text = "Name:"
            nameText.visibility = View.VISIBLE
            fishName.visibility = View.VISIBLE
            fishName.text = name
            displayCheck.visibility = View.VISIBLE
            message.visibility = View.INVISIBLE
            if (placed != null) {
                displayCheck.isChecked = placed
            }
            displayCheck.isEnabled = true
            val listMaker = ListMaker(this)
            listMaker.executeStatistics()
            val statistics = listMaker.getStatistics()
            if (!displayCheck.isChecked && statistics.FishDisplayed == 3){
                message.visibility = View.VISIBLE
                displayCheck.isEnabled = false
                displayCheck.setTextColor(Color.DKGRAY)
                displayCheck.buttonTintList = ColorStateList.valueOf(Color.DKGRAY)
            }
        }
        val resID = getResources().getIdentifier(link, "drawable", packageName)
        image.setImageResource(resID)
    }
}