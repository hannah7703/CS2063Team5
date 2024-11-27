package ca.unb.mobiledev.team5project.model

data class Decoration(
    val name: String? = null,
    var owned: Boolean = false,
    var placement: String? = null,
    val decoType: String? = null, //Wall, table, tank
    val decoCode: String? = null,
    val cost: String = "0",
    val imageLink: String = "")
{}
