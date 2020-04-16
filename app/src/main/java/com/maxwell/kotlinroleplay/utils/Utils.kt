package com.maxwell.kotlinroleplay.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.maxwell.kotlinroleplay.R
import com.maxwell.kotlinroleplay.entities.Enemy
import com.maxwell.kotlinroleplay.quest.Quest
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream


class Utils {

    fun getEnemiesFromJson(context:Context):ArrayList<Enemy>{
        val inputStream: InputStream = context.resources.openRawResource(R.raw.enemies)
        val jsonString = readTextFile(inputStream)

        return Gson().fromJson<ArrayList<Enemy>>(jsonString)
    }

    fun getQuestsFromJson(context:Context):ArrayList<Quest>{
        val inputStream: InputStream = context.resources.openRawResource(R.raw.story_1)
        val jsonString = readTextFile(inputStream)

        return Gson().fromJson<ArrayList<Quest>>(jsonString)
    }

    private fun readTextFile(inputStream: InputStream):String{
        val outputStream = ByteArrayOutputStream()

        val buf = ByteArray(1024)
        var len: Int

        try {
            while (inputStream.read(buf).also { len = it } != -1) {
                outputStream.write(buf, 0, len)
            }
            outputStream.close()
            inputStream.close()
        } catch (e: IOException) {

        }

        return outputStream.toString()
    }

    inline fun <reified T> Gson.fromJson(json: String) = fromJson<T>(json, object: TypeToken<T>() {}.type)
}