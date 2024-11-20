package ca.unb.mobiledev.team5project.util

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import ca.unb.mobiledev.team5project.model.Achievement
import ca.unb.mobiledev.team5project.model.Decoration
import ca.unb.mobiledev.team5project.model.Statistics
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class ListMaker(private val activity: AppCompatActivity) {
    private val appContext: Context = activity.applicationContext
    lateinit var achieveList: ArrayList<Achievement>
    lateinit var decoList: ArrayList<Decoration>
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

    fun updateAchieveState(name: String, state: String, index: Int){
//        val array = JsonUtils(appContext).getAchievementsArray(appContext)
//        if (state.equals("Earned")){
//            array.getJSONObject(index).put("state", "Achieved")
//        } else {
//            array.getJSONObject(index).put("state", "Earned")
//        }
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
        val string = content.toString()
        val stringput = string.replaceFirst("\"state\": \"Earned\"", "\"state\": \"Achieved\"")
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

    fun updateStatistics(stat: String, value: Int, increase: Boolean){
        var file = appContext.getFileStreamPath("Statistic.json")
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
            change++
        } else {
            change--
        }
        val string = content.toString()
        val stringput = string.replaceFirst("\"$stat\": \"$value\"", "\"$stat\": \"$change\"")
        val fileWriter = FileWriter(file)
        val bufferedWriter = BufferedWriter(fileWriter)

        bufferedWriter.write(stringput)
        bufferedWriter.close()
    }
}