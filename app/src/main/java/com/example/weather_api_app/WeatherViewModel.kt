package com.example.weather_api_app

// WeatherViewModel.kt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    fun fetchWeather(latitude: Double, longitude: Double, date: Long) {
        viewModelScope.launch {
            val weather = repository.getWeatherData(latitude, longitude, date)
            // Update UI here
        }
    }
}
