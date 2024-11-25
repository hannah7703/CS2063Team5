package ca.unb.mobiledev.team5project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.unb.mobiledev.team5project.util.ListMaker

class UsernameDialog : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_username)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.usernameDialog)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.enterBtn)
        val textEdit = findViewById<EditText>(R.id.NameEdit)
        val ListMaker = ListMaker(this)
        ListMaker.executeStatistics()

        button.setOnClickListener {
            ListMaker.updateUsername(textEdit.text.toString())
            finish()
        }
    }
}