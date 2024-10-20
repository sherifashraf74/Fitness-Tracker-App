package com.example.healthyfitness.presentation.screens.common_components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun ExerciseItem(exercise: Exercise, onItemClicked:()->Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.secondary, shape = MaterialTheme.shapes.large)
            .clickable { onItemClicked() },
        verticalAlignment = Alignment.CenterVertically
    ) {

        Card(
            modifier = Modifier
                .size(120.dp)
                .background(color = MaterialTheme.colorScheme.background, MaterialTheme.shapes.large)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(exercise.gifUrl)
                    .decoderFactory(ImageDecoderDecoder.Factory())
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = exercise.name,
            color = MaterialTheme.colorScheme.onTertiary,
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 20.sp)
        )


    }
}