package ca.unb.mobiledev.team5project.model

data class Achievement (var name: String?,
                        var goal: Int, //Numerical goal
                        var goalType: String?, //number fish, tasks made, completed
                        var reward: String?,
                        var rewardCode: String?, //Signifies currency or decoration and how much/which
                        val state: String?) //Add a progress value? or store values as global vars and check against?