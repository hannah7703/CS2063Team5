package ca.unb.mobiledev.team5project

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.unb.mobiledev.team5project.util.ListMaker

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
        val purchased = bundle?.getBoolean("owned")
        val name = bundle?.getString("name")
        val type = bundle?.getString("decoType")
        val placement = bundle?.getString("placement")
        var owned = false
        if (purchased!= null && purchased){
            owned = true
        }
        val cost = bundle?.getString("cost")
        val food = bundle?.getInt("food")
        var afford = true
        if (cost != "" && cost != null && cost.toInt() > food!!) {
            afford = false
        }
        val exitBtn = findViewById<Button>(R.id.button)
        exitBtn.setOnClickListener{
            finish()
        }
        val purchaseBtn = findViewById<Button>(R.id.purchase)
        val leftBtn = findViewById<Button>(R.id.left)
        val rightBtn = findViewById<Button>(R.id.right)
        val removeBtn = findViewById<Button>(R.id.remove)
        removeBtn.setOnClickListener {
            val listMaker = ListMaker(this)
            listMaker.executeDecorations()
            listMaker.executeStatistics()
            val statistics = listMaker.getStatistics()
            listMaker.placeDecoration(name!!, placement!!, "NA")
            listMaker.updateStatistics("Decoration Placed", statistics.DecorationPlaced, false, 1)
            finish()
        }
        purchaseBtn.setOnClickListener{
            val listMaker = ListMaker(this)
            listMaker.executeDecorations()
            listMaker.executeStatistics()
            val statistics = listMaker.getStatistics()
            if(!owned) { //Buying the decoration
                if (name != null) {
                    listMaker.buyDecoration(name)
                }
                listMaker.updateStatistics("Fish food", statistics.Fishfood, false, cost!!.toInt())
                listMaker.updateStatistics("Decoration Bought", statistics.DecorationBought, true, 1)
            } else if (!placement.equals("Center")){
                val decoList = listMaker.getDecorationList()
                for (deco in decoList){
                    if(deco.decoType == type && deco.placement.equals("Center")){
                        listMaker.placeDecoration(deco.name!!, deco.placement!!, "NA")
                        listMaker.updateStatistics("Decoration Placed", statistics.DecorationPlaced, false, 1)
                        statistics.DecorationPlaced--
                        break
                    }
                }
                listMaker.placeDecoration(name!!, placement!!, "Center")
                if(placement.equals("NA")) {
                    listMaker.updateStatistics("Decoration Placed", statistics.DecorationPlaced, true, 1)
                }
            }
            finish()
        }
        leftBtn.setOnClickListener {
            if(!placement.equals("Left")) {
                val listMaker = ListMaker(this)
                listMaker.executeDecorations()
                listMaker.executeStatistics()
                val statistics = listMaker.getStatistics()
                val decoList = listMaker.getDecorationList()
                for (deco in decoList) {
                    if (deco.decoType == type && deco.placement.equals("Left")) {
                        listMaker.placeDecoration(deco.name!!, deco.placement!!, "NA")
                        listMaker.updateStatistics("Decoration Placed", statistics.DecorationPlaced, false, 1)
                        statistics.DecorationPlaced--
                        break
                    }
                }
                listMaker.placeDecoration(name!!, placement!!, "Left")
                if (placement.equals("NA")) {
                    listMaker.updateStatistics("Decoration Placed", statistics.DecorationPlaced, true, 1)
                }
            }
            finish()
        }
        rightBtn.setOnClickListener {
            if(!placement.equals("Right")) {
                val listMaker = ListMaker(this)
                listMaker.executeDecorations()
                listMaker.executeStatistics()
                val statistics = listMaker.getStatistics()
                val decoList = listMaker.getDecorationList()
                for (deco in decoList) {
                    if (deco.decoType == type && deco.placement.equals("Right")) {
                        listMaker.placeDecoration(deco.name!!, deco.placement!!, "NA")
                        listMaker.updateStatistics("Decoration Placed", statistics.DecorationPlaced, false, 1)
                        statistics.DecorationPlaced--
                        break
                    }
                }
                listMaker.placeDecoration(name!!, placement!!, "Right")
                if (placement.equals("NA")) {
                    listMaker.updateStatistics("Decoration Placed", statistics.DecorationPlaced, true, 1)
                }
            }
            finish()
        }

        val text = findViewById<TextView>(R.id.textView20)
        var content = ""
        if(placement.equals("Left")){
            leftBtn.setBackgroundColor(Color.parseColor("#3F51B5"))
            rightBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            purchaseBtn.setBackgroundColor(Color.parseColor("#2196F3"))
        } else if(placement.equals("Right")){
            leftBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            rightBtn.setBackgroundColor(Color.parseColor("#3F51B5"))
            purchaseBtn.setBackgroundColor(Color.parseColor("#2196F3"))
        } else if (placement.equals("Center")){
            leftBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            rightBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            purchaseBtn.setBackgroundColor(Color.parseColor("#3F51B5"))
        } else {
            leftBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            rightBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            purchaseBtn.setBackgroundColor(Color.parseColor("#2196F3"))
        }
        if(placement != "NA"){
            content = "Move $name on $type?"
            purchaseBtn.visibility = View.VISIBLE
            leftBtn.visibility = View.VISIBLE
            rightBtn.visibility = View.VISIBLE
            removeBtn.visibility = View.VISIBLE
            purchaseBtn.text = "Center"
        } else if (owned) {
            content = "Place $name on $type?"
            purchaseBtn.visibility = View.VISIBLE
            leftBtn.visibility = View.VISIBLE
            rightBtn.visibility = View.VISIBLE
            removeBtn.visibility = View.INVISIBLE
            purchaseBtn.text = "Center"
        } else if(cost.equals("")){
            purchaseBtn.visibility = View.INVISIBLE
            leftBtn.visibility = View.INVISIBLE
            rightBtn.visibility = View.INVISIBLE
            removeBtn.visibility = View.INVISIBLE
            content = "Unlock by completing achievements!"
        } else if(!afford){
            purchaseBtn.visibility = View.INVISIBLE
            leftBtn.visibility = View.INVISIBLE
            rightBtn.visibility = View.INVISIBLE
            removeBtn.visibility = View.INVISIBLE
            content = "You don't have enough fish food!"
        } else {
            purchaseBtn.visibility = View.VISIBLE
            leftBtn.visibility = View.INVISIBLE
            rightBtn.visibility = View.INVISIBLE
            removeBtn.visibility = View.INVISIBLE
            purchaseBtn.text = "Buy"
            content = "Purchase $name for $cost fish food?"
        }
        text.text = content
    }
}