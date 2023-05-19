package dev.shreyansh.weatherman.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class WeatherManViewModel(application: Application) : AndroidViewModel(application) {


    private val _currentLocation = MutableLiveData<String>()
    val currentLocation: LiveData<String>
        get() = _currentLocation

    init {
        _currentLocation.value = "New Delhi"
    }

    fun updateCurrentLocation(location : String){
        _currentLocation.value = location
    }
}