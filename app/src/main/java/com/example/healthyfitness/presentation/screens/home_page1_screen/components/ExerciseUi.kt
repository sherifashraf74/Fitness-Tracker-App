package com.example.healthyfitness.presentation.screens.home_page1_screen.components

import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.screens.home_page1_screen.ExerciseViewModel
import com.example.healthyfitness.presentation.screens.home_page1_screen.model.ExerciseType
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState


@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ExerciseUi(viewModel: ExerciseViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val context = LocalContext.current
    val permissionState = rememberPermissionState(permission = Manifest.permission.ACTIVITY_RECOGNITION)

    // Request permission on the first composition
    LaunchedEffect(Unit) {
        if (!permissionState.status.isGranted) {
            permissionState.launchPermissionRequest()
        }
    }

    // Check if the permission is granted
    if (permissionState.status.isGranted) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 10.dp, 12.dp, 0.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface, shape = MaterialTheme.shapes.extraLarge
                ),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 18.dp, 20.dp, 50.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    ExerciseSection(
                        img = R.drawable.footsteps_outline,
                        title = "Walking",
                        value = viewModel.walkingSteps.toString(),
                        unit = "steps",
                        isActive = viewModel.isWalkingActive,
                        onStart = { viewModel.startExercise(ExerciseType.WALKING) },
                        onStop = { viewModel.stopExercise(ExerciseType.WALKING) },
                        onRetry = { viewModel.retryExercise(ExerciseType.WALKING)}
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    ExerciseSection(
                        img = R.drawable.bicycle_solid,
                        title = "Cycling",
                        value = viewModel.cyclingSteps.toString(),
                        unit = "pedal strokes",
                        isActive = viewModel.isCyclingActive,
                        onStart = { viewModel.startExercise(ExerciseType.CYCLING) },
                        onStop = { viewModel.stopExercise(ExerciseType.CYCLING) },
                        onRetry = { viewModel.retryExercise(ExerciseType.CYCLING) }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ExerciseSection(
                        img = R.drawable.ic_swimmer_icon,
                        title = "Swimming",
                        value = viewModel.formatTime(viewModel.swimmingTime),
                        unit = "",
                        isActive = viewModel.isSwimmingActive,
                        onStart = { viewModel.startExercise(ExerciseType.SWIMMING) },
                        onStop = { viewModel.stopExercise(ExerciseType.SWIMMING) },
                        onRetry = { viewModel.retryExercise(ExerciseType.SWIMMING) }
                    )
                }
            }
        }
    } else {
        Text(text = "Permission needed to access activity recognition.")
    }
}




//@Composable
//fun ActivityItem(viewModel: ExerciseViewModel = viewModel()) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(12.dp,10.dp,12.dp,0.dp)
//            .background(
//                color = MaterialTheme.colorScheme.surface, shape =MaterialTheme.shapes.extraLarge
//            ), verticalArrangement = Arrangement.SpaceEvenly
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(29.dp,18.dp,29.dp,18.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Column(verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally) {
//                Image(
//                    painter = painterResource(id = activity.type.iconImg),
//                    contentDescription = null,
//                    modifier = Modifier.size(44.dp),
//                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                Text(text =stringResource(id = activity.type.label), color = Color.White)
//            }
//            Column(
//                horizontalAlignment = Alignment.End,
//            ) {
//                Row (verticalAlignment = Alignment.CenterVertically,){
//                    Text(
//                        text = activity.value,
//                        color = Color.White,
//                        style = MaterialTheme.typography.bodyLarge.copy(fontSize =30.sp,fontWeight = FontWeight.Bold)
//                    )
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Text(
//                        text = activity.valueType,
//                        color = Color.White,
//                        style = MaterialTheme.typography.bodyMedium.copy(fontSize =17.sp )
//                    )
//                }
//                Spacer(modifier = Modifier.height(8.dp))
//                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.large)
//                    .padding(14.dp,4.dp,14.dp,4.dp)) { Text(
//                    text = activity.time,
//                    color = MaterialTheme.colorScheme.onPrimary,
//                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 13.sp)
//                ) }
//            }
//        }
//    }
//}


@Preview
@Composable
private fun ExercisePreview() {
    ExerciseUi()

}