package ca.unb.mobiledev.team5project.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "decoration")
class Achievement {
    @PrimaryKey(true) var id = 0
    var name: String? = null
    var goal: Int = 0 //Numerical goal
    var goalType: String? = null //number fish, tasks made, completed
    var reward: String? = null
    var rewardCode: String? = null //Signifies currency or decoration and how much/which
    val state: String? = null //Add a progress value? or store values as global vars and check against?
}