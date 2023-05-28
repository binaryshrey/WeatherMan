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