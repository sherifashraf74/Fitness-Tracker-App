package com.example.healthyfitness.presentation.screens.notification.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.theme.White


@Composable
fun Banner() {
    Box(
        modifier = Modifier.padding(top = 16.dp)
            .size(375.dp, 200.dp)
            .clip(RoundedCornerShape(15.dp))
        ,


        ){
        Image( painter = painterResource(id = R.drawable.notifications_man), contentDescription ="Banner Image",
            contentScale = ContentScale.Crop,

            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(15.dp))
        )
        Text(text = "Subscribe to unlock new features and\nGet a free Gym Kit", color = White, modifier = Modifier.padding(15.dp))
Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_cil_diamond_icon), contentDescription = "Diamond",Modifier.align(
    Alignment.BottomEnd).absoluteOffset(x = 10.dp, y = 10.dp).clip(RoundedCornerShape(15.dp)).padding(20.dp)
)
    }

}

@Preview
@Composable
fun PreviewBanner() {
    Banner()

}