package com.example.weather_api_app

// WeatherData.kt

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_data")
data class WeatherData(
    @PrimaryKey val date: Long,
    val maxTemp: Double,
    val minTemp: Double
)
