package ca.unb.mobiledev.team5project.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "decoration")
class Decoration {
    @PrimaryKey(true) var id = 0
    var name: String? = null
    val owned: Boolean = false
    var decoType: String? = null //Wall, table, tank
    val placement: String? = null
    val decoCode: String? = null
    val cost: Int = 0
}
