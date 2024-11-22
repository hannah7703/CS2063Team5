package ca.unb.mobiledev.team5project

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
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

        val exitBtn = findViewById<Button>(R.id.button)
        exitBtn.setOnClickListener{
            finish()
        }

        val fishType = findViewById<TextView>(R.id.fishType)
        val fishName = findViewById<TextView>(R.id.FishNameEdit)
        val nameText = findViewById<TextView>(R.id.textView14)
        val displayCheck = findViewById<CheckBox>(R.id.checkBox)
        val message = findViewById<TextView>(R.id.textView15)
        if(!owned!!){
            fishType.text = "[Locked]"
            nameText.visibility = View.INVISIBLE
            fishName.visibility = View.INVISIBLE
            displayCheck.visibility = View.INVISIBLE
            message.text = "Complete Tasks to Unlock"
        } else {
            fishType.text = type
            nameText.visibility = View.VISIBLE
            fishName.visibility = View.VISIBLE
            fishName.text = name
            displayCheck.visibility = View.VISIBLE
            if (placed != null) {
                displayCheck.isChecked = placed
            }
            message.visibility = View.INVISIBLE
        }
    }
}