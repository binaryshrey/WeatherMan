package dev.shreyansh.weatherman.network.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


@JsonClass(generateAdapter = true)
@Parcelize
data class DailyForecastResponse(
    @Json(name = "DailyForecasts")
    val dailyForecasts: List<ForecastResponse>
) : Parcelable


@JsonClass(generateAdapter = true)
@Parcelize
data class ForecastResponse(
    @Json(name = "Date")
    val date: String,

    @Json(name = "Temperature")
    val temperature: ForecastTemperature,

    @Json(name = "Day")
    val day: Day,

    @Json(name = "Link")
    val link: String
) : Parcelable


@JsonClass(generateAdapter = true)
@Parcelize
data class ForecastTemperature(
    @Json(name = "Minimum")
    val minimum: Minimum,

    @Json(name = "Maximum")
    val maximum: Maximum
) : Parcelable


@JsonClass(generateAdapter = true)
@Parcelize
data class Minimum(
    @Json(name = "Value")
    val value: Int,

    @Json(name = "Unit")
    val unit: String
) : Parcelable


@JsonClass(generateAdapter = true)
@Parcelize
data class Maximum(
    @Json(name = "Value")
    val value: Int,

    @Json(name = "Unit")
    val unit: String
) : Parcelable


@JsonClass(generateAdapter = true)
@Parcelize
data class Day(
    @Json(name = "Icon")
    val icon: String,

    @Json(name = "IconPhrase")
    val weatherType: String
) : Parcelable
