package dev.shreyansh.weatherman.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import dev.shreyansh.weatherman.network.WeatherManAPI
import dev.shreyansh.weatherman.network.WeatherManDetailAPI
import dev.shreyansh.weatherman.network.response.*
import dev.shreyansh.weatherman.utils.CurrentLocation
import dev.shreyansh.weatherman.utils.WeatherManDataStore
import kotlinx.coroutines.launch


enum class WeatherManCurrentConditionStatus { LOADING, ERROR, DONE }
enum class WeatherManDetailedConditionStatus { LOADING, ERROR, DONE }
enum class WeatherManSearchStatus { LOADING, ERROR, DONE }



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


    private val _hourlyForecast = MutableLiveData<List<HourlyForecastResponse>>()
    val hourlyForecast : MutableLiveData<List<HourlyForecastResponse>>
        get() = _hourlyForecast

    private val _dailyForecast = MutableLiveData<DailyForecastResponse>()
    val dailyForecast : MutableLiveData<DailyForecastResponse>
        get() = _dailyForecast


    private val _currentConditionStatus = MutableLiveData<WeatherManCurrentConditionStatus>()
    val currentConditionStatus : MutableLiveData<WeatherManCurrentConditionStatus>
        get() = _currentConditionStatus

    private val _detailedConditionStatus = MutableLiveData<WeatherManDetailedConditionStatus>()
    val detailedConditionStatus : MutableLiveData<WeatherManDetailedConditionStatus>
        get() = _detailedConditionStatus

    private val _detailedWeather = MutableLiveData<DetailedWeatherResponse>()
    val detailedWeather : MutableLiveData<DetailedWeatherResponse>
        get() = _detailedWeather

    private val _currentConditionError = MutableLiveData<String>()
    val currentConditionError : MutableLiveData<String>
        get() = _currentConditionError


    private val _citySearchResults = MutableLiveData<List<CitySearchResponse>>()
    val citySearchResults : MutableLiveData<List<CitySearchResponse>>
        get() = _citySearchResults

    private val _citySearchStatus = MutableLiveData<WeatherManSearchStatus>()
    val citySearchStatus : MutableLiveData<WeatherManSearchStatus>
        get() = _citySearchStatus


    init {
        _currentConditionError.value = ""
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

                if(!cityCode.isNullOrEmpty()){
                    val weatherCondition = WeatherManAPI.weatherManService.getCurrentWeatherByCityCode(cityCode[0].locationKey)
                    _currentWeatherCondition.value = weatherCondition[0]
                    val hourlyForecast = WeatherManAPI.weatherManService.getHourlyForecastByCityCode(cityCode[0].locationKey)
                    _hourlyForecast.value = hourlyForecast
                    val dailyForecast = WeatherManAPI.weatherManService.getDailyForecastByCityCode(cityCode[0].locationKey)
                    _dailyForecast.value = dailyForecast
                    _currentConditionError.value = ""
                }
                _currentConditionStatus.value = WeatherManCurrentConditionStatus.DONE
            }
            catch (e: Exception){
                _currentConditionStatus.value = WeatherManCurrentConditionStatus.ERROR
                _currentConditionError.value = "$e"
                Log.i("Exception","$e")
            }
        }
    }

    fun getDetailedWeather(city: String) {
        viewModelScope.launch {
            _detailedConditionStatus.value = WeatherManDetailedConditionStatus.LOADING
            try{
                val detailedWeather = WeatherManDetailAPI.weatherManDetailService.getDetailedWeather(city)
                _detailedWeather.value = detailedWeather
                _detailedConditionStatus.value = WeatherManDetailedConditionStatus.DONE

            }
            catch (e: Exception){
                _detailedConditionStatus.value = WeatherManDetailedConditionStatus.ERROR
                Log.i("Exception","$e")
            }
        }

    }


    fun getSearchedCity(city: String) {
        viewModelScope.launch {
            _citySearchStatus.value = WeatherManSearchStatus.LOADING
            try{
                val cities = WeatherManAPI.weatherManService.getCities(city)
                _citySearchResults.value = cities
                _citySearchStatus.value = WeatherManSearchStatus.DONE
                Log.i("cities","$cities")

            }
            catch (e: Exception){
                _citySearchStatus.value = WeatherManSearchStatus.ERROR
                Log.i("Exception","$e")
            }
        }

    }
}