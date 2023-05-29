package dev.shreyansh.weatherman.network.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


@JsonClass(generateAdapter = true)
@Parcelize
data class HourlyForecastResponse(
    @Json(name = "DateTime")
    val dateTime: String,

    @Json(name = "IconPhrase")
    val weatherType: String,

    @Json(name = "WeatherIcon")
    val weatherIcon: Int,

    @Json(name = "Temperature")
    val temperature: HourlyTemperature,

    @Json(name = "Link")
    val weatherURI: String
) : Parcelable


@JsonClass(generateAdapter = true)
@Parcelize
data class HourlyTemperature(
    @Json(name = "Value")
    val value: String,

    @Json(name = "Unit")
    val unit: String
) : Parcelable


