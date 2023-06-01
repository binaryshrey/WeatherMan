package dev.shreyansh.weatherman.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dev.shreyansh.weatherman.BuildConfig
import dev.shreyansh.weatherman.network.response.DetailedWeatherResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



private const val BASE_URL = "https://api.weatherapi.com"
private const val API_KEY = BuildConfig.WEATHER_API_API_KEY

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface WeatherManDetailService {
    @GET("/v1/current.json")
    suspend fun getDetailedWeather(
        @Query("q") q: String,
        @Query("key") key: String = API_KEY,
        @Query("aqi") aqi: String = "yes",
    ) : DetailedWeatherResponse

}

object WeatherManDetailAPI {
    val weatherManDetailService: WeatherManDetailService by lazy {
        retrofit.create(WeatherManDetailService::class.java)
    }
}
