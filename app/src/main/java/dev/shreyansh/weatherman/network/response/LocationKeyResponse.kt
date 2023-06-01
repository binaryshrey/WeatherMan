package dev.shreyansh.weatherman.network.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.shreyansh.weatherman.domain.CurrentWeather
import kotlinx.parcelize.Parcelize


@JsonClass(generateAdapter = true)
@Parcelize
data class LocationKeyResponse(
    @Json(name = "Key")
    val locationKey : String,

    @Json(name = "EnglishName")
    val cityName : String
): Parcelable




@JsonClass(generateAdapter = true)
@Parcelize
data class CurrentWeatherCondition(
    @Json(name = "WeatherText")
    val weatherText : String,

    @Json(name = "WeatherIcon")
    val weatherIcon : Int,

    @Json(name = "Temperature")
    val temperature : Temperature,

    @Json(name = "Link")
    val weatherURI : String
): Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Temperature(
    @Json(name = "Metric")
    val metric: Metric
): Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Metric(
    @Json(name = "Value")
    val value : String,

    @Json(name = "Unit")
    val unit : String
): Parcelable



