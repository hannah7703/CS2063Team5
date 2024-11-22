package ca.unb.mobiledev.team5project.model

data class Decoration(
    val name: String? = null,
    var owned: Boolean = false,
    val decoType: String? = null, //Wall, table, tank
    var placement: String? = null,
    val decoCode: String? = null,
    val cost: String = "0",
    val imageLink: String = "")
{}
