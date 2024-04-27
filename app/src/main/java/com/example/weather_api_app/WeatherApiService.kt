package com.example.weather_api_app

// WeatherApiService.kt

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("history/city")
    suspend fun getHistoricalWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("type") type: String = "hour",
        @Query("start") startEpoch: Long,
        @Query("cnt") count: Int,
        @Query("appid") apiKey: String = "ec32c73caa3b51884de1bd975d3eab9b"
    ): WeatherResponse
}

data class WeatherResponse(
    val maxTemperature: Double,
    val minTemperature: Double
)
