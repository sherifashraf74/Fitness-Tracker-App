package com.example.healthyfitness.presentation.screens.foods

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.healthyfitness.R

import com.example.healthyfitness.data.food_data.FoodItem


@Composable
fun FoodListScreen(foodItems: List<FoodItem?>, onItemClick: (FoodItem) -> Unit) {

        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            items(foodItems) { item ->
                if (item != null) {
                    FoodItemRow(item) { onItemClick(item) }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }


@Composable
fun FoodItemRow(foodItem: FoodItem, onClick: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(12.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (foodItem?.image?.image != "" && foodItem?.image?.image != null) {
            Image(
                painter = rememberAsyncImagePainter(foodItem.image.image),
                contentDescription = foodItem.name,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                painter = rememberAsyncImagePainter(R.drawable.ic_launcher_background),
                contentDescription = "Default Image",
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = foodItem.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onTertiary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "${foodItem.energy} Kcal",
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Medium),
                color = Color.White
            )
        }

        Image(
            painter = rememberAsyncImagePainter(R.drawable.calories),
            contentDescription = "Calories Icon",
            modifier = Modifier
                .size(30.dp)
        )
    }
}
