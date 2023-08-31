package dev.shreyansh.weatherman.utils

import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.google.android.material.progressindicator.CircularProgressIndicator
import dev.shreyansh.weatherman.R
import dev.shreyansh.weatherman.viewModel.WeatherManCurrentConditionStatus
import dev.shreyansh.weatherman.viewModel.WeatherManDetailedConditionStatus
import dev.shreyansh.weatherman.viewModel.WeatherManSearchStatus


@BindingAdapter("currentWeatherProgress")
fun setCurrentWeatherProgress(linearLayout: LinearLayout, status: WeatherManCurrentConditionStatus?) {
    linearLayout.visibility = View.VISIBLE
    status?.let {
        when (status) {
            WeatherManCurrentConditionStatus.LOADING -> linearLayout.visibility = View.VISIBLE
            WeatherManCurrentConditionStatus.ERROR -> linearLayout.visibility = View.GONE
            WeatherManCurrentConditionStatus.DONE -> linearLayout.visibility = View.GONE
        }
    }
}


@BindingAdapter("currentWeatherProgressLayout")
fun setCurrentWeatherProgressLayout(
    constraintLayout: ConstraintLayout,
    status: WeatherManCurrentConditionStatus?
) {
    constraintLayout.visibility = View.GONE
    status?.let {
        when (status) {
            WeatherManCurrentConditionStatus.LOADING -> constraintLayout.visibility = View.GONE
            WeatherManCurrentConditionStatus.ERROR -> constraintLayout.visibility = View.GONE
            WeatherManCurrentConditionStatus.DONE -> constraintLayout.visibility = View.VISIBLE
        }
    }
}

@BindingAdapter("currentWeatherErrorLayout")
fun setCurrentWeatherErrorLayout(
    constraintLayout: ConstraintLayout,
    status: WeatherManCurrentConditionStatus?
) {
    constraintLayout.visibility = View.GONE
    status?.let {
        when (status) {
            WeatherManCurrentConditionStatus.LOADING -> constraintLayout.visibility = View.GONE
            WeatherManCurrentConditionStatus.ERROR -> constraintLayout.visibility = View.VISIBLE
            WeatherManCurrentConditionStatus.DONE -> constraintLayout.visibility = View.GONE
        }
    }
}

@BindingAdapter("errorText")
fun setWindSpeed(textView: TextView, error: String?) {
    error?.let {
        textView.text = "Uh Oh! We're unable to load current weather details due to : ${error}. \n\nPlease try again!"
    }
}

@BindingAdapter("currentWeatherIcon")
fun setCurrentWeatherIcon(imageView: ImageView, iconNo: Int?) {
    iconNo?.let {
        when (iconNo) {
            1 -> imageView.setImageResource(R.drawable.sunny)
            2 -> imageView.setImageResource(R.drawable.sunny)
            3 -> imageView.setImageResource(R.drawable.sunny)
            4 -> imageView.setImageResource(R.drawable.cloudy)
            5 -> imageView.setImageResource(R.drawable.cloudy)
            6 -> imageView.setImageResource(R.drawable.cloudy)
            7 -> imageView.setImageResource(R.drawable.cloudy)
            8 -> imageView.setImageResource(R.drawable.clouds)
            11 -> imageView.setImageResource(R.drawable.clouds)
            12 -> imageView.setImageResource(R.drawable.rainy)
            13 -> imageView.setImageResource(R.drawable.partly_cloudy)
            14 -> imageView.setImageResource(R.drawable.partly_cloudy)
            15 -> imageView.setImageResource(R.drawable.rain_lightning)
            16 -> imageView.setImageResource(R.drawable.rain_lightning)
            17 -> imageView.setImageResource(R.drawable.rain_lightning)
            18 -> imageView.setImageResource(R.drawable.rainy)
            19 -> imageView.setImageResource(R.drawable.clouds)
            20 -> imageView.setImageResource(R.drawable.cloudy)
            21 -> imageView.setImageResource(R.drawable.cloudy)
            22 -> imageView.setImageResource(R.drawable.cloudy)
            23 -> imageView.setImageResource(R.drawable.cloudy)
            24 -> imageView.setImageResource(R.drawable.cloudy)
            25 -> imageView.setImageResource(R.drawable.rainy)
            26 -> imageView.setImageResource(R.drawable.rainy)
            29 -> imageView.setImageResource(R.drawable.rainy)
            30 -> imageView.setImageResource(R.drawable.clouds)
            31 -> imageView.setImageResource(R.drawable.clouds)
            32 -> imageView.setImageResource(R.drawable.clouds)
            33 -> imageView.setImageResource(R.drawable.sunny_night)
            34 -> imageView.setImageResource(R.drawable.sunny_night)
            35 -> imageView.setImageResource(R.drawable.sunny_night)
            36 -> imageView.setImageResource(R.drawable.cloudy_night)
            37 -> imageView.setImageResource(R.drawable.cloudy_night)
            38 -> imageView.setImageResource(R.drawable.cloudy_night)
            39 -> imageView.setImageResource(R.drawable.rain_lightning)
            40 -> imageView.setImageResource(R.drawable.rain_lightning)
            41 -> imageView.setImageResource(R.drawable.rain_lightning)
            42 -> imageView.setImageResource(R.drawable.rain_lightning)
            43 -> imageView.setImageResource(R.drawable.cloudy_night)
            44 -> imageView.setImageResource(R.drawable.cloudy_night)

        }
    }
}

@BindingAdapter("dailyWeatherIcon")
fun setDailyWeatherIcon(imageView: ImageView, iconNo: Int?) {
    iconNo?.let {
        when (iconNo) {
            1 -> imageView.setImageResource(R.drawable.sunny_bg)
            2 -> imageView.setImageResource(R.drawable.sunny_bg)
            3 -> imageView.setImageResource(R.drawable.sunny_bg)
            4 -> imageView.setImageResource(R.drawable.cloudy_bg)
            5 -> imageView.setImageResource(R.drawable.cloudy_bg)
            6 -> imageView.setImageResource(R.drawable.cloudy_bg)
            7 -> imageView.setImageResource(R.drawable.cloudy_bg)
            8 -> imageView.setImageResource(R.drawable.clouds_bg)
            11 -> imageView.setImageResource(R.drawable.clouds_bg)
            12 -> imageView.setImageResource(R.drawable.rainy_bg)
            13 -> imageView.setImageResource(R.drawable.partly_cloudy_bg)
            14 -> imageView.setImageResource(R.drawable.partly_cloudy_bg)
            15 -> imageView.setImageResource(R.drawable.rain_lightning_bg)
            16 -> imageView.setImageResource(R.drawable.rain_lightning_bg)
            17 -> imageView.setImageResource(R.drawable.rain_lightning_bg)
            18 -> imageView.setImageResource(R.drawable.rainy_bg)
            19 -> imageView.setImageResource(R.drawable.clouds_bg)
            20 -> imageView.setImageResource(R.drawable.cloudy_bg)
            21 -> imageView.setImageResource(R.drawable.cloudy_bg)
            22 -> imageView.setImageResource(R.drawable.cloudy_bg)
            23 -> imageView.setImageResource(R.drawable.cloudy_bg)
            24 -> imageView.setImageResource(R.drawable.cloudy_bg)
            25 -> imageView.setImageResource(R.drawable.rainy_bg)
            26 -> imageView.setImageResource(R.drawable.rainy_bg)
            29 -> imageView.setImageResource(R.drawable.rainy_bg)
            30 -> imageView.setImageResource(R.drawable.clouds_bg)
            31 -> imageView.setImageResource(R.drawable.clouds_bg)
            32 -> imageView.setImageResource(R.drawable.clouds_bg)
            33 -> imageView.setImageResource(R.drawable.sunny_night_bg)
            34 -> imageView.setImageResource(R.drawable.sunny_night_bg)
            35 -> imageView.setImageResource(R.drawable.sunny_night_bg)
            36 -> imageView.setImageResource(R.drawable.cloudy_night_bg)
            37 -> imageView.setImageResource(R.drawable.cloudy_night_bg)
            38 -> imageView.setImageResource(R.drawable.cloudy_night_bg)
            39 -> imageView.setImageResource(R.drawable.rain_lightning_bg)
            40 -> imageView.setImageResource(R.drawable.rain_lightning_bg)
            41 -> imageView.setImageResource(R.drawable.rain_lightning_bg)
            42 -> imageView.setImageResource(R.drawable.rain_lightning_bg)
            43 -> imageView.setImageResource(R.drawable.cloudy_night_bg)
            44 -> imageView.setImageResource(R.drawable.cloudy_night_bg)

        }
    }
}


@BindingAdapter("hourlyTemp")
fun setHourlyTemp(textView: TextView, temp: Int?) {
    temp?.let {
        textView.text = "${((temp-32)*5/9)}°C"
    }
}

@BindingAdapter("hourlyTempTime")
fun setHourlyTempTime(textView: TextView, temp: String?) {
    temp?.let {
        textView.text = "${convertHourlyTimestamp(temp)}"
    }
}


@BindingAdapter("currentTemp")
fun setCurrentTemp(textView: TextView, temp: String?) {
    temp?.let {
        textView.text = "$temp °C"
    }
}

@BindingAdapter("currentTempType")
fun setCurrentTempType(textView: TextView, tempType: String?) {
    tempType?.let {
        textView.text = tempType.toString()
    }
}

@BindingAdapter("alert")
fun setAlert(textView: TextView, temp: String?) {
    temp?.let {
        if(temp.toFloat() > 25f){
            textView.text = "Extreme heat warning: Temperatures soaring, stay hydrated and seek shade for your safety."
        }
        else{
            textView.text = "Expect cooler conditions with dropping temperatures and a chance of light showers."
        }
    }
}


@BindingAdapter("dailyWeatherForeCast")
fun setDailyWeatherForeCast(textView: TextView, tempType: String?) {
    tempType?.let {
        textView.text = tempType.toString()
    }
}

@BindingAdapter("day")
fun setDay(textView: TextView, day: String?) {
    day?.let {
        textView.text = getDayOfWeek(day)
    }
}

@BindingAdapter("dailyWeatherMax","dailyWeatherMin")
fun setDay(textView: TextView, dailyWeatherMax: Int?, dailyWeatherMin: Int?) {
    dailyWeatherMax?.let {
        dailyWeatherMin?.let {
            textView.text = "${((dailyWeatherMax-32)*5/9)} / ${((dailyWeatherMin-32)*5/9)} °C"
        }
    }
}


@BindingAdapter("detailedWeatherProgress")
fun setDetailedWeatherProgressLayout(linearLayout: LinearLayout, status: WeatherManDetailedConditionStatus?) {
    linearLayout.visibility = View.VISIBLE
    status?.let {
        when (status) {
            WeatherManDetailedConditionStatus.LOADING -> linearLayout.visibility = View.VISIBLE
            WeatherManDetailedConditionStatus.ERROR -> linearLayout.visibility = View.GONE
            WeatherManDetailedConditionStatus.DONE -> linearLayout.visibility = View.GONE
        }
    }
}

@BindingAdapter("searchProgress")
fun setSearchProgress(progressBar: ProgressBar, status: WeatherManSearchStatus?) {
    progressBar.visibility = View.GONE
    status?.let {
        when (status) {
            WeatherManSearchStatus.LOADING -> progressBar.visibility = View.VISIBLE
            WeatherManSearchStatus.ERROR -> progressBar.visibility = View.GONE
            WeatherManSearchStatus.DONE -> progressBar.visibility = View.GONE
        }
    }
}

@BindingAdapter("detailedWeatherLayout")
fun setDetailedWeatherProgress(linearLayout: LinearLayout, status: WeatherManDetailedConditionStatus?) {
    linearLayout.visibility = View.GONE
    status?.let {
        when (status) {
            WeatherManDetailedConditionStatus.LOADING -> linearLayout.visibility = View.GONE
            WeatherManDetailedConditionStatus.ERROR -> linearLayout.visibility = View.VISIBLE
            WeatherManDetailedConditionStatus.DONE -> linearLayout.visibility = View.VISIBLE
        }
    }
}

@BindingAdapter("aqiPercentage")
fun setAQIPercentage(circularProgressIndicator: CircularProgressIndicator, aqi: Float?) {
    aqi?.let {
        circularProgressIndicator.progress = ((aqi/500) * 100).toInt()
    }
}

@BindingAdapter("indicatorColor")
fun setIndicatorColor(circularProgressIndicator: CircularProgressIndicator, aqi: Float?) {
    aqi?.let {
        val aqiPercentage = ((aqi/500) * 100).toInt()
        when(aqiPercentage){
            in 0..150 -> {
                circularProgressIndicator.setIndicatorColor(Color.parseColor("#8fce00"))
                circularProgressIndicator.trackColor = (Color.parseColor("#d9ead3"))

            }
            in 151..200 -> {
                circularProgressIndicator.setIndicatorColor(Color.parseColor("#e69138"))
                circularProgressIndicator.trackColor = (Color.parseColor("#fce5cd"))

            }
            in 201..500 -> {
                circularProgressIndicator.setIndicatorColor(Color.parseColor("#f44336"))
                circularProgressIndicator.trackColor = (Color.parseColor("#f4cccc"))

            }
            else -> {
                circularProgressIndicator.setIndicatorColor(Color.parseColor("#f44336"))
                circularProgressIndicator.trackColor = (Color.parseColor("#f4cccc"))
            }
        }
    }
}


@BindingAdapter("progressColor")
fun setProgressColor(textView: TextView, aqi: Float?) {
    aqi?.let {
        textView.text = "${aqi.toInt()}"
        when(aqi.toInt()){
            in 0..150 -> textView.setTextColor(Color.parseColor("#8fce00"))
            in 151..200 -> textView.setTextColor(Color.parseColor("#e69138"))
            in 201..500 -> textView.setTextColor(Color.parseColor("#f44336"))
            else -> textView.setTextColor(Color.parseColor("#f44336"))
        }
    }
}

@BindingAdapter("aqiOverview")
fun setAQIOverview(textView: TextView, aqi: Float?) {
    aqi?.let {
        when (aqi.toInt()) {
            in 0..50 -> textView.text = "AQI - Very Good"
            in 51..100 -> textView.text = "AQI - Good"
            in 101..150 -> textView.text = "AQI - Moderate"
            in 151..200 -> textView.text = "AQI - Unhealthy"
            in 201..300 -> textView.text = "AQI - Very Unhealthy"
            in 301..500 -> textView.text = "AQI - Hazardous"
            else -> textView.text = "AQI - Hazardous"
        }
    }
}

@BindingAdapter("aqiDetailed")
fun setAQIDetailed(textView: TextView, aqi: Float?) {
    aqi?.let {
        when (aqi.toInt()) {
            in 0..50 -> textView.text = "Air quality is excellent, posing little or no health risk."
            in 51..100 -> textView.text = "Air quality is acceptable, but sensitive individuals may experience minor respiratory issues."
            in 101..150 -> textView.text = "People with respiratory or heart conditions should limit outdoor activities."
            in 151..200 -> textView.text = "Everyone may experience adverse health effects, and prolonged exposure is harmful."
            in 201..300 -> textView.text = "Health warnings are issued, and everyone is at risk of significant health problems."
            in 301..500 -> textView.text = "Emergency conditions with severe health effects; everyone should avoid outdoor activities."
            else -> textView.text = "Emergency conditions with severe health effects; everyone should avoid outdoor activities."
        }
    }
}

@BindingAdapter("humidity")
fun setHumidity(textView: TextView, humidity: Int?) {
    humidity?.let {
        textView.text = "$humidity%"
    }
}

@BindingAdapter("pressure")
fun setPressure(textView: TextView, pressure: Float?) {
    pressure?.let {
        textView.text = "${pressure.toInt()} hPa"
    }
}

@BindingAdapter("windSpeed")
fun setWindSpeed(textView: TextView, windSpeed: Float?) {
    windSpeed?.let {
        textView.text = "$windSpeed km/hr"
    }
}

@BindingAdapter("cloudCover")
fun setCloudCover(textView: TextView, cloudCover: Int?) {
    cloudCover?.let {
        textView.text = "$cloudCover%"
    }
}


@BindingAdapter("city")
fun setCity(textView: TextView, city: String?) {
    city?.let {
        textView.text = "$city, "
    }
}

@BindingAdapter("state")
fun setState(textView: TextView, state: String?) {
    state?.let {
        textView.text = state
    }
}

@BindingAdapter("country")
fun setCountry(textView: TextView, country: String?) {
    country?.let {
        textView.text = country
    }
}