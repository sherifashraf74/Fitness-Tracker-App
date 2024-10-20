package com.example.healthyfitness.presentation.screens.all_back_work

import com.example.healthyfitness.presentation.screens.common_components.Exercise
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.example.healthyfitness.presentation.screens.common_components.RowItem
import com.example.healthyfitness.presentation.theme.LightBlack


@RequiresApi(Build.VERSION_CODES.P)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackExerciseDetailsScreen(exercise: Exercise) {

        Column(
            modifier = Modifier
                .background(LightBlack)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            RowItem(ob = exercise.name, "Name")
            RowItem(ob = exercise.target, "Target")
            RowItem(ob = exercise.bodyPart, "Body Part")
            RowItem(ob = exercise.equipment, "Equipment")

            Spacer(modifier = Modifier.height(16.dp))

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(exercise.gifUrl)
                    .decoderFactory(ImageDecoderDecoder.Factory())
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 400.dp, height = 600.dp)
                    .clip(RoundedCornerShape(6.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }



