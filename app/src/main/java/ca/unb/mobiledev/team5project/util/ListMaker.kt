package ca.unb.mobiledev.team5project.util

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import ca.unb.mobiledev.team5project.model.Achievement
import ca.unb.mobiledev.team5project.model.Decoration
import ca.unb.mobiledev.team5project.model.Fish
import ca.unb.mobiledev.team5project.model.Statistics
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class ListMaker(private val context: Context) {
    private val appContext: Context = context
    lateinit var achieveList: ArrayList<Achievement>
    lateinit var decoList: ArrayList<Decoration>
    lateinit var fishList: ArrayList<Fish>
    lateinit var stats: Statistics

    fun executeAchievements(){
        var file = appContext.getFileStreamPath("achievementList.json")
        if(!file.exists()){
            file = File(appContext.getFilesDir(), "achievementList.json")
            val fileWriter = FileWriter(file)
            val bufferedWriter = BufferedWriter(fileWriter)

            var assetString = JsonUtils(appContext).loadJSONFromAssets(appContext, "Achievements.json")
            bufferedWriter.write(assetString)
            bufferedWriter.close()

            achieveList = JsonUtils(appContext).getAchievements(appContext)
        } else {
            //file.delete()
            achieveList = JsonUtils(appContext).getAchievementsFile(appContext)
        }
    }

    fun executeDecorations(){
        var file = appContext.getFileStreamPath("decorationList.json")
        if(!file.exists()){
            file = File(appContext.getFilesDir(), "decorationList.json")
            val fileWriter = FileWriter(file)
            val bufferedWriter = BufferedWriter(fileWriter)

            var assetString = JsonUtils(appContext).loadJSONFromAssets(appContext, "Decorations.json")
            bufferedWriter.write(assetString)
            bufferedWriter.close()

            decoList = JsonUtils(appContext).getDecorations(appContext)
        } else {
            //file.delete()
            decoList = JsonUtils(appContext).getDecorationsFile(appContext)
        }
    }

    fun executeFish(): ArrayList<Fish>{
        var file = appContext.getFileStreamPath("fishList.json")
        if(!file.exists()){
            file = File(appContext.getFilesDir(), "fishList.json")
            val fileWriter = FileWriter(file)
            val bufferedWriter = BufferedWriter(fileWriter)

            var assetString = JsonUtils(appContext).loadJSONFromAssets(appContext, "Fishes.json")
            bufferedWriter.write(assetString)
            bufferedWriter.close()

            fishList = JsonUtils(appContext).getFish(appContext)
            return fishList
        } else {
            //file.delete()
            fishList = JsonUtils(appContext).getFishFile(appContext)
            return fishList
        }
    }

    fun executeStatistics(){
        var file = appContext.getFileStreamPath("Statistics.json")
        if(!file.exists()){
            file = File(appContext.getFilesDir(), "Statistics.json")
            val fileWriter = FileWriter(file)
            val bufferedWriter = BufferedWriter(fileWriter)

            var assetString = JsonUtils(appContext).loadJSONFromAssets(appContext, "Statistics.json")
            bufferedWriter.write(assetString)
            bufferedWriter.close()

            stats = JsonUtils(appContext).getStatistics(appContext)
        } else {
            //file.delete()
            stats = JsonUtils(appContext).getStatisticsFile(appContext)
        }
    }

    fun getAchievementList(): ArrayList<Achievement>{
        return achieveList
    }

    fun getDecorationList(): ArrayList<Decoration>{
        return decoList
    }

    fun getStatistics(): Statistics{
        return stats
    }

    fun updateAchieveState(name: String, state: String){
        var file = appContext.getFileStreamPath("achievementList.json")
        val reader = BufferedReader(file.reader())
        val content = StringBuilder()
        try {
            var line = reader.readLine()
            while (line != null) {
                content.append(line)
                line = reader.readLine()
            }
        } finally {
            reader.close()
        }
        var newState = state
        if (state.equals("Locked")){
            newState = "Earned"
        } else {
            newState = "Achieved"
        }
        val string = content.toString()
        val stringput = string.replaceFirst("\"name\": \"$name\",      \"state\": \"$state\"", "\"name\": \"$name\",      \"state\": \"$newState\"")
        val fileWriter = FileWriter(file)
        val bufferedWriter = BufferedWriter(fileWriter)

        bufferedWriter.write(stringput)
        bufferedWriter.close()
    }

    fun buyDecoration(name: String){
        var file = appContext.getFileStreamPath("decorationList.json")
        val reader = BufferedReader(file.reader())
        val content = StringBuilder()
        try {
            var line = reader.readLine()
            while (line != null) {
                content.append(line)
                line = reader.readLine()
            }
        } finally {
            reader.close()
        }
        val string = content.toString()
        val stringput = string.replaceFirst("\"name\": \"$name\",      \"owned\": false", "\"name\": \"$name\",      \"owned\": true")
        val fileWriter = FileWriter(file)
        val bufferedWriter = BufferedWriter(fileWriter)

        bufferedWriter.write(stringput)
        bufferedWriter.close()
    }

    fun placeDecoration(name: String, placement: String, newPlace: String){
        var file = appContext.getFileStreamPath("decorationList.json")
        val reader = BufferedReader(file.reader())
        val content = StringBuilder()
        try {
            var line = reader.readLine()
            while (line != null) {
                content.append(line)
                line = reader.readLine()
            }
        } finally {
            reader.close()
        }
        val string = content.toString()
        val stringput = string.replaceFirst("\"name\": \"$name\",      \"owned\": true,      \"placement\": \"$placement\"", "\"name\": \"$name\",      \"owned\": true,      \"placement\": \"$newPlace\"")

        val fileWriter = FileWriter(file)
        val bufferedWriter = BufferedWriter(fileWriter)

        bufferedWriter.write(stringput)
        bufferedWriter.close()
    }

    fun updateUsername(name: String){
        var file = appContext.getFileStreamPath("Statistics.json")
        val reader = BufferedReader(file.reader())
        val content = StringBuilder()
        try {
            var line = reader.readLine()
            while (line != null) {
                content.append(line)
                line = reader.readLine()
            }
        } finally {
            reader.close()
        }
        val string = content.toString()
        val stringput = string.replaceFirst("\"Username\": \"\"", "\"Username\": \"$name\"")
        val fileWriter = FileWriter(file)
        val bufferedWriter = BufferedWriter(fileWriter)

        bufferedWriter.write(stringput)
        bufferedWriter.close()
    }
    fun updateStatistics(stat: String, value: Int, increase: Boolean, amount: Int){
        var file = appContext.getFileStreamPath("Statistics.json")
        val reader = BufferedReader(file.reader())
        val content = StringBuilder()
        var change = value
        try {
            var line = reader.readLine()
            while (line != null) {
                content.append(line)
                line = reader.readLine()
            }
        } finally {
            reader.close()
        }
        if(increase){
            change = value+amount
        } else {
            change = value-amount
        }
        val string = content.toString()
        val stringput = string.replaceFirst("\"$stat\": $value", "\"$stat\": $change")
        val fileWriter = FileWriter(file)
        val bufferedWriter = BufferedWriter(fileWriter)

        bufferedWriter.write(stringput)
        bufferedWriter.close()
    }

    fun renameFish(name: String, newName: String){
        var file = appContext.getFileStreamPath("fishList.json")
        val reader = BufferedReader(file.reader())
        val content = StringBuilder()
        try {
            var line = reader.readLine()
            while (line != null) {
                content.append(line)
                line = reader.readLine()
            }
        } finally {
            reader.close()
        }
        val fileWriter = FileWriter(file)
        val bufferedWriter = BufferedWriter(fileWriter)
        val string = content.toString()
        val stringput = string.replaceFirst("\"name\": \"$name\"", "\"name\": \"$newName\"")
        bufferedWriter.write(stringput)
        bufferedWriter.close()
    }
    fun updateFish(type: String, newVal: Boolean, stat: String){
        var file = appContext.getFileStreamPath("fishList.json")
        val reader = BufferedReader(file.reader())
        val content = StringBuilder()
        try {
            var line = reader.readLine()
            while (line != null) {
                content.append(line)
                line = reader.readLine()
            }
        } finally {
            reader.close()
        }
        val fileWriter = FileWriter(file)
        val bufferedWriter = BufferedWriter(fileWriter)
        val string = content.toString()
        var stringput = string
        if(stat.equals("owned")){
            stringput = string.replaceFirst("\"type\": \"$type\",      \"owned\": false", "\"type\": \"$type\",      \"owned\": true")
        }else if(stat.equals("placed")){
            val oldVal = !newVal
            stringput = string.replaceFirst("\"type\": \"$type\",      \"owned\": true,      \"placed\": $oldVal", "\"type\": \"$type\",      \"owned\": true,      \"placed\": $newVal")
        }

        bufferedWriter.write(stringput)
        bufferedWriter.close()
    }
}