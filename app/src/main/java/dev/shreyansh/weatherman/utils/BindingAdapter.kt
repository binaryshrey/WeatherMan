package dev.shreyansh.weatherman.utils

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import dev.shreyansh.weatherman.R
import dev.shreyansh.weatherman.viewModel.WeatherManCurrentConditionStatus


@BindingAdapter("currentWeatherProgress")
fun setCurrentWeatherProgress(progressBar: ProgressBar, status: WeatherManCurrentConditionStatus?) {
    progressBar.visibility = View.VISIBLE
    status?.let {
        when (status) {
            WeatherManCurrentConditionStatus.LOADING -> progressBar.visibility = View.VISIBLE
            WeatherManCurrentConditionStatus.ERROR -> progressBar.visibility = View.GONE
            WeatherManCurrentConditionStatus.DONE -> progressBar.visibility = View.GONE
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
            WeatherManCurrentConditionStatus.ERROR -> constraintLayout.visibility = View.VISIBLE
            WeatherManCurrentConditionStatus.DONE -> constraintLayout.visibility = View.VISIBLE
        }
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
        textView.text = temp.toString()
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