package com.example.healthyfitness.presentation.screens.home_page1_screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun ExerciseSection(
    @DrawableRes img: Int,
    title: String,
    value: String,
    unit: String,
    isActive: Boolean,
    onStart: () -> Unit,
    onStop: () -> Unit,
    onRetry: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Column(
            modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.surface).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(text = title, style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onSecondary)
                Spacer(modifier = Modifier.width(20.dp))
                Image(
                    painter = painterResource(id = img),
                    contentDescription = null, // Provide a description if needed for accessibility
                    modifier = Modifier.size(40.dp) // Adjust size as needed
                )

            }

            Text(text = "$value $unit", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSecondary)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = if (isActive) onStop else onStart,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isActive) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(if (isActive) "Stop" else "Start")
                }
                if (!isActive) {
                    Button(onClick = onRetry) {
                        Text("Retry")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun SSS() {
    HealthyFitnessTheme {
        ExerciseSection(value = "sa", unit = "d", title = "d", onStop = {}, onRetry = {}, onStart = {}, isActive = false, img = R.drawable.ic_swimmer_icon)

    }

}

//@Preview(
//    showBackground = true,
//    showSystemUi = true,
//    name = "pixel" ,
//    device = Devices.PIXEL_4
//)
//@Composable
//fun ActivityItemPreview(){
//    MaterialTheme { ActivityItem(activity =  FitnessActivity(ActivityType.Cycling, "17","Km", "Today 09:00 AM")) }
//
//}
