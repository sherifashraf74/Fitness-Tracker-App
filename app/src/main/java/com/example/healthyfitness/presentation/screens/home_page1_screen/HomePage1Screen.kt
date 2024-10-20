package com.example.healthyfitness.presentation.screens.home_page1_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.healthyfitness.presentation.screens.home_page1_screen.components.ExerciseUi
import com.example.healthyfitness.presentation.screens.home_page1_screen.components.CalendarPager

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun HomePage1Screen() {
    LazyColumn(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 60.dp)
            .fillMaxSize()
    ) {
        item {
            CalendarPager(updateSelectedDay = {})
            Spacer(modifier = Modifier.height(40.dp))
        }
        item { ExerciseUi(viewModel = viewModel())
        }
    }
}
//
