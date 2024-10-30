package ca.unb.mobiledev.team5project.model

data class Decoration(var name: String?,
                      val owned: Boolean,
                      var decoType: String?, //Wall, table, tank
                      val placement: String?,
                      val decoCode: String?)
