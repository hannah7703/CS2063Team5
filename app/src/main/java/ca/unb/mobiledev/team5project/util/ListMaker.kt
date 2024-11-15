package ca.unb.mobiledev.team5project.util

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import ca.unb.mobiledev.team5project.model.Achievement
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class ListMaker(private val activity: AppCompatActivity) {
    private val appContext: Context = activity.applicationContext
    lateinit var achieveList: ArrayList<Achievement>

    fun execute(){
        var file = appContext.getFileStreamPath("achievementList.json")
        if(!file.exists()){
            file = File(appContext.getFilesDir(), "achievementList.json")
            val fileWriter = FileWriter(file)
            val bufferedWriter = BufferedWriter(fileWriter)

            var assetString = JsonUtils(appContext).loadJSONFromAssets(appContext)
            bufferedWriter.write(assetString)
            bufferedWriter.close()

            achieveList = JsonUtils(appContext).getAchievements(appContext)
        } else {
            //file.delete()
            achieveList = JsonUtils(appContext).getAchievementsFile(appContext)
        }
    }

    fun getAchievementList(): ArrayList<Achievement>{
        return achieveList
    }
}