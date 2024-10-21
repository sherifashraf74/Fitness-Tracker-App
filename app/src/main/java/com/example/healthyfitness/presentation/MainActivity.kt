package com.example.healthyfitness.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.example.healthyfitness.presentation.navigation.MainScreen
//import com.example.healthyfitness.presentation.common_components.shimmer.Icon
//import com.example.healthyfitness.presentation.screens.home_page1_screen.HomePage1Screen
//import com.example.healthyfitness.presentation.screens.home_page1_screen.components.ActivityItem
//import com.example.healthyfitness.presentation.screens.home_page1_screen.model.ActivityType
//import com.example.healthyfitness.presentation.screens.home_page1_screen.model.FitnessActivity
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthyFitnessTheme(dynamicColor = false) {

                MainScreen()
            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    HealthyFitnessTheme {
//        Greeting("Android")
//    }
