package com.example.weather_api_app



//////////////////////////////////////////////////////////////////







//class MainActivity : ComponentActivity() {
//    @OptIn(ExperimentalMaterial3Api::class)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            WeatherApp()
//        }
//    }
//}
//
//
//
//@Composable
//fun WeatherApp() {
//    var cityName by remember { mutableStateOf("") }
//    var date by remember { mutableStateOf("") }
//
//    var maxTemperature by remember { mutableStateOf("") }
//    var minTemperature by remember { mutableStateOf("") }
//    var isDateValid by remember { mutableStateOf(true) }
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "Enter City Name:")
//        TextField(
//            value = cityName,
//            onValueChange = { cityName = it },
//            modifier = Modifier.padding(16.dp)
//        )
//
//        Text(text = "Enter Date (YYYY-MM-DD):")
//        TextField(
//            value = date,
//            onValueChange = {
//
//                date = it
//
//                isDateValid = validateDate(it)
//            },
//            modifier = Modifier.padding(16.dp),
//            isError = !isDateValid,
//            singleLine = true,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )
//
//        if (!isDateValid) {
//            Text(
//                text = "Please enter a valid date in YYYY-MM-DD format",
//                color = Color.Red,
//                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
//            )
//        }
//
//        Button(
//            onClick = {
//                if (isDateValid) {
//                    fetchWeatherData(cityName, date) { result ->
//                        when (result) {
//                            is Result.Success -> {
//                                maxTemperature = result.data.maxTempC
//                                minTemperature = result.data.minTempC
//                            }
//                            is Result.Error -> {
//                                Log.e("WeatherApp", "Error fetching weather data: ${result.exception.message}")
//                            }
//                        }
//                    }
//                }
//            },
//            modifier = Modifier.padding(16.dp)
//        ) {
//            Text("Get Weather")
//        }
//
//        Text(text = "Max Temperature: $maxTemperature")
//        Text(text = "Min Temperature: $minTemperature")
//    }
//}
//
//data class WeatherForecast(
//    val maxTempC: String,
//    val minTempC: String
//)
//
//sealed class Result<out T> {
//    data class Success<out T>(val data: T) : Result<T>()
//    data class Error(val exception: Exception) : Result<Nothing>()
//}
//
//private fun fetchWeatherData(
//    city: String,
//    date: String,
//    callback: (Result<WeatherForecast>) -> Unit
//) {
//    val apiKey = "f302e3f2ffa44556980180712240304"
//    val baseUrl = "https://api.weatherapi.com/v1/history.json"
//    val urlString = "$baseUrl?key=$apiKey&q=$city&dt=$date"
//
//    CoroutineScope(Dispatchers.IO).launch {
//        try {
//            val url = URL(urlString)
//            val uc: HttpsURLConnection = url.openConnection() as HttpsURLConnection
//            val br = BufferedReader(InputStreamReader(uc.inputStream))
//            var line: String?
//            val lin2 = StringBuilder()
//            while (br.readLine().also { line = it } != null) {
//                lin2.append(line)
//            }
//
//            val jsonObject = JSONObject(lin2.toString())
//            val forecastObject = jsonObject.getJSONObject("forecast")
//            val forecastDayArray = forecastObject.getJSONArray("forecastday")
//            val firstForecastDay = forecastDayArray.getJSONObject(0)
//            val dayObject = firstForecastDay.getJSONObject("day")
//            val maxTempC = dayObject.getDouble("maxtemp_c").toString()
//            val minTempC = dayObject.getDouble("mintemp_c").toString()
//
//            val weatherForecast = WeatherForecast(maxTempC, minTempC)
//            withContext(Dispatchers.Main) {
//                callback(Result.Success(weatherForecast))
//            }
//        } catch (exception: Exception) {
//            withContext(Dispatchers.Main) {
//                callback(Result.Error(exception))
//            }
//        }
//    }
//}
//
//private fun validateDate(date: String): Boolean {
//    return try {
//        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
//        sdf.isLenient = false
//        val parsedDate = sdf.parse(date)
//        val cal = Calendar.getInstance()
//        if (parsedDate != null) {
//            cal.time = parsedDate
//        }
//        val maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
//        val day = cal.get(Calendar.DAY_OF_MONTH)
//        day <= maxDay
//    } catch (e: Exception) {
//        false
//    }
//}
//
//
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MaterialTheme {
//        Surface {
//            WeatherApp()
//        }
//    }
//}
//

//}

//import androidx.compose.material.Button
//import androidx.compose.material.Text
//import androidx.compose.material.TextField



//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            var location by remember { mutableStateOf("") }
//
//            var date by remember { mutableStateOf("") }
//
//            val context = LocalContext.current
//            val viewModel = // Initialize ViewModel here
//
//                Column {
//                    TextField(
//                        value = location,
//                        onValueChange = { location = it },
//                        label = { Text("Enter Location") }
//                    )
//                    TextField(
//                        value = date,
//                        onValueChange = { date = it },
//                        label = { Text("Enter Date (YYYY-MM-DD)") },
//                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = androidx.compose.ui.text.input.ImeAction.Done),
//                        keyboardActions = KeyboardActions(onDone = {
//                            viewModel.fetchWeatherData(location, date, "YOUR_API_KEY")
//                        })
//                    )
//                    Button(onClick = { viewModel.fetchWeatherData(location, date, "YOUR_API_KEY") }) {
//                        Text("Get Weather")
//                    }
//
//                    val weatherData by viewModel.weatherData.collectAsState()
//                    weatherData?.let {
//                        Text("Max Temperature: ${it.temperatures.maxTemp}°C")
//                        Text("Min Temperature: ${it.temperatures.minTemp}°C")
//                    }
//                }
//        }
//    }
//}


// MainActivity.kt



//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MaterialTheme {
//                WeatherApp()
//            }
//        }
//    }
//}
//
//@Composable
//fun WeatherApp(weatherViewModel: WeatherViewModel = viewModel()) {
//
//    // New delhi lat and lon
//    var latitude by remember { mutableStateOf("") }
//    var longitude by remember { mutableStateOf("") }
//
//
//
////    var latitude by remember { mutableStateOf("") }
////    var longitude by remember { mutableStateOf("") }
////
//
//
//    var date by remember { mutableStateOf("") }
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        TextField(
//            value = latitude,
//            onValueChange = { latitude = it },
//            label = { Text("Latitude") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )
//        TextField(
//            value = longitude,
//            onValueChange = { longitude = it },
//            label = { Text("Longitude") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )
//        TextField(
//            value = date,
//            onValueChange = { date = it },
//            label = { Text("Date (Epoch)") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )
//        Button(onClick = {
//            weatherViewModel.fetchWeather(latitude.toDouble(), longitude.toDouble(), date.toLong())
//        }) {
//            Text("Fetch Weather")
//        }
//    }
//}



// Imports necessary for database and networking
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                WeatherApp()
            }
        }
    }
}

@Composable
fun WeatherApp(weatherViewModel: WeatherViewModel = viewModel()) {
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = latitude,
            onValueChange = { latitude = it },
            label = { Text("Latitude") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = longitude,
            onValueChange = { longitude = it },
            label = { Text("Longitude") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Date (Epoch)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            if (latitude.isNotEmpty() && longitude.isNotEmpty() && date.isNotEmpty()) {
                weatherViewModel.fetchWeather(latitude.toDouble(), longitude.toDouble(), date.toLong())
            } else {
                errorMessage = "Please fill all fields correctly"
            }
        }) {
            Text("Fetch Weather")
        }
        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
        }
    }
}
