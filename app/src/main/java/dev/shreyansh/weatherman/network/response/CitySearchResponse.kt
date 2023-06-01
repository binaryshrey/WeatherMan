package dev.shreyansh.weatherman.network.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


@JsonClass(generateAdapter = true)
@Parcelize
data class CitySearchResponse(
    @Json(name = "Key")
    val cityKey: String,

    @Json(name = "LocalizedName")
    val city: String,

    @Json(name = "Country")
    val country: Country,

    @Json(name = "AdministrativeArea")
    val state: AdministrativeArea
) : Parcelable


@JsonClass(generateAdapter = true)
@Parcelize
data class Country(
    @Json(name = "LocalizedName")
    val ID: String,
) : Parcelable


@JsonClass(generateAdapter = true)
@Parcelize
data class AdministrativeArea(
    @Json(name = "LocalizedName")
    val state: String,
) : Parcelable