package dev.shreyansh.weatherman.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CurrentWeather(
    val weatherText : String,
    val weatherIcon : Int,
    val temperature : Temperature,
    val weatherURI : String
): Parcelable

@Parcelize
data class Temperature(
    val metric: Metric
): Parcelable

@Parcelize
data class Metric(
    val value : String,
    val unit : String
): Parcelable