package com.example.healthyfitness.presentation.screens.notification.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.theme.DarkGreen
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import com.example.healthyfitness.presentation.theme.White


@Composable
fun NotificationItem(item: String ) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(15.dp)
            )
            .background(color = DarkGreen)
    ){
        Row(modifier = Modifier.padding(15.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top) {
            Column (horizontalAlignment = Alignment.Start, modifier = Modifier.weight(weight = 1f) ){
                Text(text = "$item\n" +
                        "Generic Risk for Obesity", color = White, )
Row (verticalAlignment = Alignment.CenterVertically) {
    Image(imageVector = ImageVector.vectorResource(id = R.drawable.alarm_clock), contentDescription = "Alarm time")

    Text(text = "04-Sep-2023", color = White, modifier = Modifier.padding(15.dp))
    /*Icon(
        imageVector = Icons.Default.Add, // Using the default "+" icon
        contentDescription = "Add Icon",
        tint = LemonGreen,
        modifier = Modifier
            .size(35.dp)
            // Positioning the icon at the bottom center
            .padding(bottom = 8.dp)
    )*/
    Image(imageVector = ImageVector.vectorResource(id = R.drawable.plus), colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary), contentDescription = "Plus")

    Text(text = "Follow", color = White, modifier = Modifier.padding(15.dp))
   }
            }
            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(50.dp)
                    .clip(RoundedCornerShape(15.dp))
                ,


                ){
                Image( painter = painterResource(id = R.drawable.vegetables), contentDescription ="Banner Image",
                    contentScale = ContentScale.Crop,

                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(15.dp))
                )

            }

        }
    }
}

@Preview
@Composable
fun PreviewNotificationItem() {
    HealthyFitnessTheme {
        NotificationItem("Item 2")
    }

}