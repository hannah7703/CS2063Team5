package ca.unb.mobiledev.team5project

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StoreDialog : AppCompatActivity()   {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_store)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.storeDialog)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras
        val purchased = bundle?.getBoolean("purchased")
        val name = bundle?.getString("name")
        var owned = false
        if (purchased!= null && purchased){
            owned = true
        }
        val cost = bundle?.getInt("cost")
        var afford = true
        if (cost != null && cost > 15) {
            afford = false
        }
        val exitBtn = findViewById<Button>(R.id.button)
        exitBtn.setOnClickListener{
            finish()
        }
        val purchaseBtn = findViewById<Button>(R.id.purchase)
        purchaseBtn.setOnClickListener{
            finish()
        }
        val text = findViewById<TextView>(R.id.textView20)
        var content = ""
        if(!afford || owned){
            purchaseBtn.visibility = View.INVISIBLE
            if (owned){
                content = "You already own this!"
            } else {
                content = "You don't have enough fish food!"
            }
        } else {
            purchaseBtn.visibility = View.VISIBLE
            content = "Purchase $name for $cost fish food?"
        }
        text.text = content
    }
}