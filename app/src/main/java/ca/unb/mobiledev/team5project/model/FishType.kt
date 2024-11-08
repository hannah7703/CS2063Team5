package ca.unb.mobiledev.team5project.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fish_type")
class FishType {
    @PrimaryKey(true) var id = 0
    val typeName: String? = null
    var rarity: Int = 0;
}