package com.example.healthyfitness.presentation.screens.common_components.customs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.navigation.NavRoutes
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomAppBar(navController: NavHostController, currentIndex: Int) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            // List of routes and corresponding icons
            val navRoutes = listOf(
                Pair(NavRoutes.ExerciseSelection.route, Icons.Default.Home),
                Pair(NavRoutes.FoodList.route, painterResource(id = R.drawable.fast_food)),
                Pair(NavRoutes.HomeScreen1.route, painterResource(id = R.drawable.activity)),
                Pair(NavRoutes.NotificationList.route, Icons.Default.Notifications)
            )

            navRoutes.forEachIndexed { index, route ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.weight(1f) // Ensure equal spacing between items
                ) {
                    // Background circle for the selected index
                    if (index == currentIndex) {
                        Box(
                            modifier = Modifier
                                .size(60.dp) // Adjust size as needed
                                .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape)
                        )
                    }

                    // Icon button
                    IconButton(onClick = {
                        navController.navigate(route.first) {
                            popUpTo(route.first) { inclusive = true }
                        }
                    }) {
                        val iconColor = if (index == currentIndex) Color.Black else Color.White
                        when (val icon = route.second) {

                            is ImageVector -> Icon(icon, contentDescription = "Navigation icon", tint = iconColor, modifier = Modifier.size(30.dp))
                            is Painter -> Icon(painter = icon, contentDescription = "Navigation icon", tint = iconColor, modifier = Modifier.size(30.dp))
                        }
                    }
                }
            }
        }
    }
}





@Preview
@Composable
private fun PreviewCustomBottomAppBar() {
    HealthyFitnessTheme {
        CustomBottomAppBar(navController = NavHostController(context = LocalContext.current),0)
    }
}