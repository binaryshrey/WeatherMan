package dev.shreyansh.weatherman.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WeatherManViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherManViewModel::class.java)) {
            return WeatherManViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}