package com.example.weather_api_app

// WeatherRepository.kt

class WeatherRepository(private val apiService: WeatherApiService, private val weatherDao: WeatherDao) {
    suspend fun getWeatherData(latitude: Double, longitude: Double, date: Long): WeatherData {
        val weatherResponse = apiService.getHistoricalWeather(latitude, longitude, "hour", date, 1)
        val weatherData = WeatherData(date, weatherResponse.maxTemperature, weatherResponse.minTemperature)
        weatherDao.insertWeather(weatherData)
        return weatherData
    }

    suspend fun getCachedWeatherData(date: Long): WeatherData? {
        return weatherDao.getWeatherByDate(date)
    }
}
