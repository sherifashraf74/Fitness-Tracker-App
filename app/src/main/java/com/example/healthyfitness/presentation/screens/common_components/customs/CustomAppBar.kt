package com.example.healthyfitness.presentation.screens.common_components.customs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.theme.LemonGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(title:String,showBackButton:Boolean ,navController: NavHostController) {
    TopAppBar(
        navigationIcon = {
            if(showBackButton){
                IconButton(onClick = { navController.popBackStack() }) {
                    Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_right_icon), contentDescription = "")
                }
            }
        },
        title = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    title,
                    style = MaterialTheme.typography.headlineLarge.copy(color = LemonGreen, fontWeight = FontWeight.Bold)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
    )
}

//@Preview
//@Composable
//fun PreviewCustomAppBar() {
////    CustomAppBar("Notifications",R.drawable.ic_launcher_background)
//    CustomAppBar("Notifications")
//
//}