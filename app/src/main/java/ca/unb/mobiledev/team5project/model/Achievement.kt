package ca.unb.mobiledev.team5project.model

data class Achievement(
    var name: String? = null,
    var state: String? = null,
    var goal: Int = 0, //Numerical goal
    var goalType: String? = null, //number fish, tasks made, completed
    var reward: String? = null,
    var rewardCode: String? = null, //Signifies currency or decoration and how much/which
    )
{}