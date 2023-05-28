package dev.shreyansh.weatherman.utils

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrentLocation (
    val city : String = "",
    val countryCode : String = ""
) : Parcelable