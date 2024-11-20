package ca.unb.mobiledev.team5project.model

data class Statistics(
    var Username: String? = "",
    var Fishfood: Int = 0,
    var TaskMade: Int = 0,
    var TaskCompleted: Int = 0,
    var FishCollected: Int = 0,
    var FishDisplayed: Int = 0,
    var DecorationBought: Int = 0,
    var DecorationPlaced: Int = 0)
{}