package ca.unb.mobiledev.team5project.model

data class Decoration(
    var name: String? = null,
    val owned: Boolean = false,
    var decoType: String? = null, //Wall, table, tank
    val placement: String? = null,
    val decoCode: String? = null,
    val cost: String = "0")
{}
