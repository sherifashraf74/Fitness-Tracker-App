package com.example.healthyfitness.presentation.screens.notification

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.presentation.screens.notification.components.NotificationItem
import com.example.healthyfitness.presentation.screens.notification.components.Banner

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Notifications(itemsList: List<String> = (1..10).map { "Item $it" }) {

        Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally) {

            Banner()

                LazyColumn (
                    modifier = Modifier.fillMaxSize().padding(8.dp),

                    ){
                    items(itemsList) { item ->
                        NotificationItem(item)
                    }}

            /* NotificationItem()
             NotificationItem()
             NotificationItem()*/
        }
    }






@Preview
@Composable
fun PreviewNotifications() {
    Notifications()
}