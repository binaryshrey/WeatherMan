package dev.shreyansh.weatherman.viewModel

import android.app.Application
import androidx.lifecycle.*
import dev.shreyansh.weatherman.utils.CurrentLocation
import dev.shreyansh.weatherman.utils.WeatherManDataStore
import kotlinx.coroutines.launch

class WeatherManViewModel(application: Application) : AndroidViewModel(application) {


    private val dataStore = WeatherManDataStore.getInstance(application)
    var currentCity = dataStore.getCityPrefs().asLiveData()
    var currentCountryCode = dataStore.getCountryCode().asLiveData()
    var isOnBoardComplete = dataStore.getOnboardPrefs().asLiveData()

    private val _currentLocation = MutableLiveData<CurrentLocation>()
    val currentLocation : MutableLiveData<CurrentLocation>
        get() = _currentLocation


    init {
    }

    fun updateCurrentLocation(location: CurrentLocation){
        _currentLocation.value = location
        updateCurrentCity(location.city)
        updateCurrentCountryCode(location.countryCode)

    }

    private fun updateCurrentCity(city : String){
        viewModelScope.launch {
            dataStore.setCityPrefs(city)
        }
    }
    private fun updateCurrentCountryCode(code : String){
        viewModelScope.launch {
            dataStore.setCountryCode(code)
        }
    }

    fun updateOnBoardingPrefs(isOnBoarded : Boolean){
        viewModelScope.launch {
            dataStore.setOnboardPrefs(isOnBoarded)
        }
    }
}