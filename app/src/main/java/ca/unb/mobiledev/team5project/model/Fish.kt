package ca.unb.mobiledev.team5project.model

data class Fish (
    var name: String? = null,
    val type: String? = null,
    var owned: Boolean = false,
    var placed: Boolean = false,
    val fishCode: Int = 0,
    val rarity: String = "Common",
    val imageLink: String = "")
{}