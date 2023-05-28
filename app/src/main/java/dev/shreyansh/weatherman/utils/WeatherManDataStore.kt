package dev.shreyansh.weatherman.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


object PREFS {
    val ONBOARD_KEY = booleanPreferencesKey("ONBOARD_KEY")
    val LOCATION_KEY = stringPreferencesKey("LOCATION_KEY")

}


class WeatherManDataStore private constructor(context: Context) {

    companion object {

        @Volatile
        private var INSTANCE: WeatherManDataStore? = null

        fun getInstance(context: Context): WeatherManDataStore {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = WeatherManDataStore(context)
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "WeatherManDS")
    private val dataStore = context.dataStore


    //onboard prefs
    suspend fun setOnboardPrefs(isOnboarded: Boolean) {
        dataStore.edit { pref ->
            pref[PREFS.ONBOARD_KEY] = isOnboarded
        }
    }

    fun getOnboardPrefs(): Flow<Boolean> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { pref ->
            val onboard = pref[PREFS.ONBOARD_KEY] ?: false
            onboard
        }


    //location prefs
    suspend fun setLocationPrefs(location: String) {
        dataStore.edit { pref ->
            pref[PREFS.LOCATION_KEY] = location
        }
    }

    fun getLocationPrefs(): Flow<String> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { pref ->
            val location = pref[PREFS.LOCATION_KEY] ?: "New Delhi"
            location
        }


}