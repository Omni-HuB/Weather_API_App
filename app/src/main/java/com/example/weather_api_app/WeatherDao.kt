package com.example.weather_api_app

// WeatherDao.kt

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WeatherDao {
    @Insert
    suspend fun insertWeather(weatherData: WeatherData)

    @Query("SELECT * FROM weather_data WHERE date = :date")
    suspend fun getWeatherByDate(date: Long): WeatherData?
}
