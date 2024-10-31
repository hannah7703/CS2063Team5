package ca.unb.mobiledev.team5project.model

data class Fish(val name: String?,
                var type: String?,
                val owned: Boolean,
                val placed: Boolean?,
                val fishCode: String?,
                val level: Int,
                val levelProgress: Int,
                var rarity: String?)
