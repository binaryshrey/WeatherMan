package dev.shreyansh.weatherman.utils

import java.text.SimpleDateFormat
import java.util.*

fun formatMillisToDayDate(millis: Long): String {
    val sdf = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
    val date = Date(millis)
    return sdf.format(date)
}

fun convertTo12HourFormat(millis: Long): String {
    val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = millis
    return sdf.format(calendar.time)
}

fun convertHourlyTimestamp(timestamp: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
    val date = inputFormat.parse(timestamp)

    val calendar = Calendar.getInstance()
    calendar.time = date

    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    val isAM = hour < 12
    val formattedHour = if (hour > 12) hour - 12 else hour
    val formattedMinute = String.format("%02d", minute)

    val period = if (isAM) "AM" else "PM"

    return "$formattedHour:$formattedMinute $period"
}