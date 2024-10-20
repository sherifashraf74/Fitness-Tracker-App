package com.example.healthyfitness.presentation.screens.home_page1_screen.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDate
import org.threeten.bp.format.TextStyle
import java.util.Locale


@Composable
fun CalendarPager(
    updateSelectedDay: (Int) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val currentDate = remember{ LocalDate.now() }

    val currentDaysList = remember {
        (-2..20).map { day -> (currentDate).plusDays(day.toLong()) }
    }
    val selectedMonth = remember { mutableStateOf(currentDaysList[0].month) }
    val selectedYear = remember { mutableIntStateOf(currentDate.year) }
    val pagerState = rememberPagerState(pageCount = { currentDaysList.size - 1 }, initialPage = 0)

    LaunchedEffect(pagerState.currentPage) {
        if (pagerState.currentPage in currentDaysList.indices) {
            selectedMonth.value = currentDaysList[pagerState.currentPage].month
            selectedYear.intValue = currentDaysList[pagerState.currentPage].year
            updateSelectedDay(pagerState.currentPage)
        }
    }
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start
    ) {

        CalenderTopBar(
            dayName = currentDaysList[pagerState.currentPage].dayOfWeek.getDisplayName(
                TextStyle.FULL, Locale.getDefault()
            ), dayNum = currentDaysList[pagerState.currentPage].dayOfMonth.toString(),
        )
        Spacer(modifier = Modifier.height(32.dp))

        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fixed(60.dp),

            snapPosition = SnapPosition.Center,
            modifier = Modifier
                .padding(horizontal = 44.dp)
                .fillMaxWidth()

        ) { page ->
            val dayNum = currentDaysList[page].dayOfMonth.toString()
            val dayName = currentDaysList[page].dayOfWeek.getDisplayName(
                TextStyle.NARROW, Locale.getDefault()
            )
            Card(modifier = Modifier
                .width(40.dp)
                .height(76.dp)
                .clickable { // Add clickable modifier to the Visa
                    coroutineScope.launch { // Launch a coroutine
                        pagerState.animateScrollToPage(page) // Scroll to the clicked page
                    }
                }
                .background(shape = MaterialTheme.shapes.small, color = Color.Transparent),
                colors = CardDefaults.cardColors(if (page == pagerState.currentPage) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface)
            ) {
                CalendarItem(
                    dayNum = dayNum, dayName = dayName, isSelected = page == pagerState.currentPage
                )
            }
        }
    }
}

@Preview(
    name = "DARK | EN",
    locale = "en",
    uiMode = UI_MODE_NIGHT_YES,
    backgroundColor = 0xFF0E0E0E,
    showBackground = true
)
@Composable
fun CalendarPreview() {
    HealthyFitnessTheme {
        CalendarPager(
            updateSelectedDay = {},
        )
    }
}