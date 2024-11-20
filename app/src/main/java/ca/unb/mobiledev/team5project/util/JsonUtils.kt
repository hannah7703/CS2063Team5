package ca.unb.mobiledev.team5project.util

import android.content.Context
import ca.unb.mobiledev.team5project.model.Achievement
import ca.unb.mobiledev.team5project.model.Decoration
import ca.unb.mobiledev.team5project.model.Statistics
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.*


class JsonUtils(context: Context) {
    private var achieveList: ArrayList<Achievement> = ArrayList()
    private var decoList: ArrayList<Decoration> = ArrayList()
    private lateinit var stats: Statistics

    private fun processJSON(context: Context, fileName: String) {
        try {
            // Create a JSON Object from file contents String
            val jsonObject = JSONObject(Objects.requireNonNull(loadJSONFromAssets(context, fileName)))

            if(fileName.equals("Achievements.json")){
                // Create a JSON Array from the JSON Object
                val jsonArray = jsonObject.getJSONArray("achievements")
                for (i in 0 until jsonArray.length()) {
                    val classObject : JSONObject = jsonArray.getJSONObject(i)
                    val name = classObject.get("name").toString()
                    val goal = classObject.get("goal").toString().toInt()
                    val goalType = classObject.get("goalType").toString()
                    val reward = classObject.get("reward").toString()
                    val rewardCode = classObject.get("rewardCode").toString()
                    val state = classObject.get("state").toString()
                    val newAchievement = Achievement(name, state, goal, goalType, reward, rewardCode)
                    achieveList.add(newAchievement)
                }
            } else if(fileName.equals("Decorations.json")){
                val jsonArray = jsonObject.getJSONArray("decorations")
                for (i in 0 until jsonArray.length()) {
                    val classObject : JSONObject = jsonArray.getJSONObject(i)
                    val name = classObject.get("name").toString()
                    val owned = classObject.get("owned").toString().toBoolean()
                    val decoType = classObject.get("decoType").toString()
                    val placement = classObject.get("placement").toString()
                    val decoCode = classObject.get("decoCode").toString()
                    val cost = classObject.get("cost").toString()
                    val newDecoration = Decoration(name, owned, decoType, placement, decoCode, cost)
                    decoList.add(newDecoration)
                }
            } else if(fileName.equals("Statistics.json")){
                val username = jsonObject.get("Username").toString()
                val food = jsonObject.get("Fish food").toString().toInt()
                val made = jsonObject.get("Task Made").toString().toInt()
                val completed = jsonObject.get("Task Completed").toString().toInt()
                val collected = jsonObject.get("Fish Collected").toString().toInt()
                val displayed = jsonObject.get("Fish Displayed").toString().toInt()
                val bought = jsonObject.get("Decoration Bought").toString().toInt()
                val placed = jsonObject.get("Decoration Placed").toString().toInt()
                stats = Statistics(username, food, made, completed, collected, displayed, bought, placed)
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    fun loadJSONFromAssets(context: Context, fileName: String): String {
        val assetManager = context.getAssets()
        val inputStream = assetManager.open(fileName)
        val reader = BufferedReader(inputStream.reader())
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
        return content.toString()
    }

    private fun loadJSONFromFile(context: Context, fileName: String): String {
        val inputStream = context.getFileStreamPath(fileName)
        val reader = BufferedReader(inputStream.reader())
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
        return content.toString()
    }


    // Getter method for courses ArrayList
    fun getAchievements(context: Context): ArrayList<Achievement> {
        processJSON(context, "Achievements.json")
        return achieveList
    }

    fun getDecorations(context: Context): ArrayList<Decoration> {
        processJSON(context, "Decorations.json")
        return decoList
    }

    fun getStatistics(context: Context): Statistics{
        processJSON(context, "Statistics.json")
        return stats
    }

    fun getAchievementsFile(context: Context): ArrayList<Achievement> {
        var achievelist: ArrayList<Achievement> = ArrayList()

        val file = File(context.filesDir, "achievementList.json")
        val fileReader = FileReader(file)
        val bufferedReader = BufferedReader(fileReader)
        val stringBuilder = java.lang.StringBuilder()

        var line = bufferedReader.readLine()
        while (line != null) {
            stringBuilder.append(line).append("\n")
            line = bufferedReader.readLine()
        }
        bufferedReader.close()

        val jsonObject = JSONObject(Objects.requireNonNull(loadJSONFromFile(context, "achievementList.json")))
        val jsonArray = jsonObject.getJSONArray("achievements")
        for (i in 0 until jsonArray.length()) {
            val classObject : JSONObject = jsonArray.getJSONObject(i)
            val name = classObject.get("name").toString()
            val goal = classObject.get("goal").toString().toInt()
            val goalType = classObject.get("goalType").toString()
            val reward = classObject.get("reward").toString()
            val rewardCode = classObject.get("rewardCode").toString()
            val state = classObject.get("state").toString()
            val newAchievement = Achievement(name, state, goal, goalType, reward, rewardCode)
            achievelist.add(newAchievement)
        }
        return achievelist
    }

    fun getDecorationsFile(context: Context): ArrayList<Decoration> {
        var decolist: ArrayList<Decoration> = ArrayList()

        val file = File(context.filesDir, "decorationList.json")
        val fileReader = FileReader(file)
        val bufferedReader = BufferedReader(fileReader)
        val stringBuilder = java.lang.StringBuilder()

        var line = bufferedReader.readLine()
        while (line != null) {
            stringBuilder.append(line).append("\n")
            line = bufferedReader.readLine()
        }
        bufferedReader.close()

        val jsonObject = JSONObject(Objects.requireNonNull(loadJSONFromFile(context, "decorationList.json")))
        val jsonArray = jsonObject.getJSONArray("decorations")
        for (i in 0 until jsonArray.length()) {
            val classObject : JSONObject = jsonArray.getJSONObject(i)
            val name = classObject.get("name").toString()
            val owned = classObject.get("owned").toString().toBoolean()
            val decoType = classObject.get("decoType").toString()
            val placement = classObject.get("placement").toString()
            val decoCode = classObject.get("decoCode").toString()
            val cost = classObject.get("cost").toString()
            val newDecoration = Decoration(name, owned, decoType, placement, decoCode, cost)
            decolist.add(newDecoration)
        }
        return decolist
    }

    fun getStatisticsFile(context: Context): Statistics {
        var statistics: Statistics

        val file = File(context.filesDir, "Statistics.json")
        val fileReader = FileReader(file)
        val bufferedReader = BufferedReader(fileReader)
        val stringBuilder = java.lang.StringBuilder()

        var line = bufferedReader.readLine()
        while (line != null) {
            stringBuilder.append(line).append("\n")
            line = bufferedReader.readLine()
        }
        bufferedReader.close()

        val statistic = JSONObject(Objects.requireNonNull(loadJSONFromFile(context, "Statistics.json")))
        val username = statistic.get("Username").toString()
        val food = statistic.get("Fish food").toString().toInt()
        val made = statistic.get("Task Made").toString().toInt()
        val completed = statistic.get("Task Completed").toString().toInt()
        val collected = statistic.get("Fish Collected").toString().toInt()
        val displayed = statistic.get("Fish Displayed").toString().toInt()
        val bought = statistic.get("Decoration Bought").toString().toInt()
        val placed = statistic.get("Decoration Placed").toString().toInt()
        statistics = Statistics(username, food, made, completed, collected, displayed, bought, placed)
        return statistics
    }
}
