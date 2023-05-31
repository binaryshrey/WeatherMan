package dev.shreyansh.weatherman.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dev.shreyansh.weatherman.BuildConfig
import dev.shreyansh.weatherman.network.response.CurrentWeatherCondition
import dev.shreyansh.weatherman.network.response.DailyForecastResponse
import dev.shreyansh.weatherman.network.response.HourlyForecastResponse
import dev.shreyansh.weatherman.network.response.LocationKeyResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*


private const val BASE_URL = "https://dataservice.accuweather.com"
private const val API_KEY = BuildConfig.API_KEY

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface WeatherManService {
    @GET("/locations/v1/cities/search")
    suspend fun getLocationKey(
        @Query("q") q: String,
        @Query("apikey") apikey: String = API_KEY
    ) : List<LocationKeyResponse>

    @GET("/currentconditions/v1/{cityId}")
    suspend fun getCurrentWeatherByCityCode(
        @Path("cityId") cityId: String,
        @Query("apikey") apikey: String = API_KEY
    ) : List<CurrentWeatherCondition>


    @GET("/forecasts/v1/hourly/12hour/{cityId}")
    suspend fun getHourlyForecastByCityCode(
        @Path("cityId") cityId: String,
        @Query("apikey") apikey: String = API_KEY
    ) : List<HourlyForecastResponse>


    @GET("/forecasts/v1/daily/5day/{cityId}")
    suspend fun getDailyForecastByCityCode(
        @Path("cityId") cityId: String,
        @Query("apikey") apikey: String = API_KEY
    ) : DailyForecastResponse
}

object WeatherManAPI {
    val weatherManService: WeatherManService by lazy {
        retrofit.create(WeatherManService::class.java)
    }
}