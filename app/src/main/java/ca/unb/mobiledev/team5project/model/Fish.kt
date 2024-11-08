package ca.unb.mobiledev.team5project.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fish")
class Fish {
    @PrimaryKey(true) var id = 0
    var name: String? = null
    val type: FishType? = null
    var placed: Boolean = false
    var level: Int = 1
    var levelProgress: Int = 0
}