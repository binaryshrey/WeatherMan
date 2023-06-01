package dev.shreyansh.weatherman.network.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


@JsonClass(generateAdapter = true)
@Parcelize
data class DetailedWeatherResponse(
    @Json(name = "current")
    val current: DetailedResponse
) : Parcelable


@JsonClass(generateAdapter = true)
@Parcelize
data class DetailedResponse(
    @Json(name = "wind_kph")
    val windKPH: Float,

    @Json(name = "pressure_mb")
    val pressure: Float,

    @Json(name = "humidity")
    val humidity: Int,

    @Json(name = "cloud")
    val cloud: Int,

    @Json(name = "air_quality")
    val air_quality: AirQuality,
) : Parcelable


@JsonClass(generateAdapter = true)
@Parcelize
data class AirQuality(
    @Json(name = "pm10")
    val aqi: Float
) : Parcelable