package com.example.chatapp.utils

import java.text.SimpleDateFormat
import java.util.Calendar

class DateUtil {
    companion object{
        fun getDate(): String {
            // Create a DateFormatter object for displaying date in specified format.
            val dateFormat = "EEE hh:mm"
            val formatter: SimpleDateFormat = SimpleDateFormat(dateFormat)

            // Create a calendar object that will convert the date and time value in milliseconds to date.
            val calendar = Calendar.getInstance()
            return formatter.format(calendar.time)
        }
    }
}