package com.example.healthyfitness.presentation.screens.foods

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.healthyfitness.data.food_data.FoodItem


@Composable
fun FoodDetailsScreen(food: FoodItem) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = food.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(Alignment.CenterHorizontally),
                color = Color.White,

            )

            food.image?.let {
                Image(
                    painter = rememberAsyncImagePainter(food.image.image),
                    contentDescription = food.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }?: kotlin.run {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    Text(
                        text = "No Image Available",
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.Gray
                    )
                }
            }




            Spacer(modifier = Modifier.height(32.dp))

            Column (
                modifier = Modifier.background(MaterialTheme.colorScheme.surface).padding(8.dp).clip(shape = RoundedCornerShape(16.dp)).fillMaxWidth()
            ){
                TextRow(label = "Energy:", value = "${food.energy} kcal")
                TextRow(label = "Protein:", value = "${food.protein} g")
                TextRow(label = "Carbohydrates:", value = "${food.carbohydrates} g")
                TextRow(label = "Carbohydrates Sugar:", value = "${food.carbohydrates_sugar} g")
                TextRow(label = "Fat:", value = "${food.fat} g")
                TextRow(label = "Fat Saturated:", value = "${food.fat_saturated} g")
                TextRow(label = "Fiber:", value = "${food.fiber} g")
                TextRow(label = "Sodium:", value = "${food.sodium} g")
            }
        }
    }


@Composable
fun TextRow(label: String, value: String) {
    Row(modifier = Modifier.padding(vertical = 8.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(text = label, fontWeight = FontWeight.Bold, modifier = Modifier.width(150.dp), color = Color.White)
        Text(text = value, color = MaterialTheme.colorScheme.onTertiary)
    }
}
