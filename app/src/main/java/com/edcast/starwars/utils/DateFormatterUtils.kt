package com.edcast.starwars.utils

import android.annotation.SuppressLint
import java.lang.Exception
import java.text.ParseException
import java.text.SimpleDateFormat

object DateFormatterUtils {
    @SuppressLint("SimpleDateFormat")
    fun changeFormat(source:String, resultFormat:String, dateString:String):String{
        val dateFormatter = SimpleDateFormat(source)
        try {
            val date = dateFormatter.parse(dateString)
            val newFormat = SimpleDateFormat(resultFormat)
            return newFormat.format(date) ?: dateString
        }catch (e: ParseException){
            return "Unparseable Date"
        }catch (e:Exception){
            return "Exception"
        }
    }
}