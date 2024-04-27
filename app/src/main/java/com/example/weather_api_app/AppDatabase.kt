package com.example.weather_api_app

// AppDatabase.kt

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WeatherData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
