package ca.unb.mobiledev.team5project.util

import android.content.Context
import ca.unb.mobiledev.team5project.model.Achievement
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.*


class JsonUtils(context: Context) {
    private lateinit var list: ArrayList<Achievement>

    private fun processJSON(context: Context) {
        list = ArrayList()
        try {
            // Create a JSON Object from file contents String
            val jsonObject = JSONObject(Objects.requireNonNull(loadJSONFromAssets(context)))

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
                val newAchievement = Achievement(name, goal, goalType, reward, rewardCode, state)
                list.add(newAchievement)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    fun loadJSONFromAssets(context: Context): String? {
        val assetManager = context.getAssets()
        val inputStream = assetManager.open("Achievements.json")
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

    private fun loadJSONFromFile(context: Context): String? {
        val inputStream = context.getFileStreamPath("achievementList.json")
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
        processJSON(context)
        return list
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

        val jsonObject = JSONObject(Objects.requireNonNull(loadJSONFromFile(context)))
        val jsonArray = jsonObject.getJSONArray("achievements")
        for (i in 0 until jsonArray.length()) {
            val classObject : JSONObject = jsonArray.getJSONObject(i)
            val name = classObject.get("name").toString()
            val goal = classObject.get("goal").toString().toInt()
            val goalType = classObject.get("goalType").toString()
            val reward = classObject.get("reward").toString()
            val rewardCode = classObject.get("rewardCode").toString()
            val state = classObject.get("state").toString()
            val newAchievement = Achievement(name, goal, goalType, reward, rewardCode, state)
            achievelist.add(newAchievement)
        }
        return achievelist
    }
}
