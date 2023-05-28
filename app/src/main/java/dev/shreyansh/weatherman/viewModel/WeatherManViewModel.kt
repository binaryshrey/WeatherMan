package dev.shreyansh.weatherman.viewModel

import android.app.Application
import androidx.lifecycle.*
import dev.shreyansh.weatherman.utils.WeatherManDataStore
import kotlinx.coroutines.launch

class WeatherManViewModel(application: Application) : AndroidViewModel(application) {


    private val dataStore = WeatherManDataStore.getInstance(application)
    var location = dataStore.getLocationPrefs().asLiveData()
    var isOnBoardComplete = dataStore.getOnboardPrefs().asLiveData()

    init {

    }

    fun updateCurrentLocation(location : String){
        viewModelScope.launch {
            dataStore.setLocationPrefs(location)
        }
    }

    fun updateOnBoardingPrefs(isOnBoarded : Boolean){
        viewModelScope.launch {
            dataStore.setOnboardPrefs(isOnBoarded)
        }
    }
}