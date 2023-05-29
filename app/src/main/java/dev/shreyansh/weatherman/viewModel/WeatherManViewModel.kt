package dev.shreyansh.weatherman.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import dev.shreyansh.weatherman.domain.CurrentWeather
import dev.shreyansh.weatherman.network.WeatherManAPI
import dev.shreyansh.weatherman.network.response.CurrentWeatherCondition
import dev.shreyansh.weatherman.utils.CurrentLocation
import dev.shreyansh.weatherman.utils.WeatherManDataStore
import kotlinx.coroutines.launch


enum class WeatherManCurrentConditionStatus { LOADING, ERROR, DONE }


class WeatherManViewModel(application: Application) : AndroidViewModel(application) {


    private val dataStore = WeatherManDataStore.getInstance(application)
    var currentCity = dataStore.getCityPrefs().asLiveData()
    var currentCountryCode = dataStore.getCountryCode().asLiveData()
    var isOnBoardComplete = dataStore.getOnboardPrefs().asLiveData()

    private val _currentLocation = MutableLiveData<CurrentLocation>()
    val currentLocation : MutableLiveData<CurrentLocation>
        get() = _currentLocation

    private val _currentWeatherCondition = MutableLiveData<CurrentWeatherCondition>()
    val currentWeatherCondition : MutableLiveData<CurrentWeatherCondition>
        get() = _currentWeatherCondition

    private val _currentConditionStatus = MutableLiveData<WeatherManCurrentConditionStatus>()
    val currentConditionStatus : MutableLiveData<WeatherManCurrentConditionStatus>
        get() = _currentConditionStatus

    init {
    }

    fun updateCurrentLocation(location: CurrentLocation){
        _currentLocation.value = location
        updateCurrentCity(location.city)
        updateCurrentCountryCode(location.countryCode)
        getCurrentWeather(location.city)
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

    fun getCurrentWeather(city: String) {
        viewModelScope.launch {
            _currentConditionStatus.value = WeatherManCurrentConditionStatus.LOADING
            try {
                val cityCode = WeatherManAPI.weatherManService.getLocationKey(city)
                Log.i("cityCode","${cityCode}")

                if(!cityCode.isNullOrEmpty()){
                    val weatherCondition = WeatherManAPI.weatherManService.getCurrentWeatherByCityCode(cityCode[0].locationKey)
                    _currentWeatherCondition.value = weatherCondition[0]
                    Log.i("weatherCondition","${weatherCondition}")
                }
                _currentConditionStatus.value = WeatherManCurrentConditionStatus.DONE
            }
            catch (e: Exception){
                _currentConditionStatus.value = WeatherManCurrentConditionStatus.ERROR
                Log.i("Exception","$e")
            }
        }
    }
}