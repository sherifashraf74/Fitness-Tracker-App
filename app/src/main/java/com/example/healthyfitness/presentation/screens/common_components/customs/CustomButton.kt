package com.example.healthyfitness.presentation.screens.common_components.customs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import java.util.Locale

//@ExperimentalMaterial3Api
@Composable
fun CustomButton(width: Double? = null, buttonText: String ,icon: (@Composable () -> Unit)? = null,onClick: () -> Unit) {

    if (width != null) {
        Button(
//        border = BorderStroke(0.dp, Color.Transparent),
            modifier = Modifier
                .width(width.dp)
                .shadow(
                    shape = MaterialTheme.shapes.small,
                    elevation = 5.dp,
                    ambientColor = MaterialTheme.colorScheme.primary,
                    spotColor = MaterialTheme.colorScheme.primary
                )
                .padding(bottom = 5.dp, start = 5.dp, end = 5.dp),
            onClick = onClick,
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            )
        ) {
            if(icon!=null) {
                icon()
            }else {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                    text = buttonText.uppercase(Locale.ROOT),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontStyle = MaterialTheme.typography.labelLarge.fontStyle
                )
            }
        }
    }else{
        Button(
//        border = BorderStroke(0.dp, Color.Transparent),
            modifier = Modifier

                .shadow(
                    shape = MaterialTheme.shapes.small,
                    elevation = 5.dp,
                    ambientColor = MaterialTheme.colorScheme.primary,
                    spotColor = MaterialTheme.colorScheme.primary
                )
                .padding(bottom = 5.dp, start = 5.dp, end = 5.dp),
            onClick = onClick,
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            )
        ) {
            if(icon!=null) {
                icon()
            }else {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                    text = buttonText.uppercase(Locale.ROOT),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontStyle = MaterialTheme.typography.labelLarge.fontStyle
                )
            }
        }
    }
}
//@ExperimentalMaterial3Api
@Composable
fun IconItem(buttonText: String) {
    Row(
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            text = buttonText.uppercase(Locale.ROOT),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleLarge
        )
Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_export_icon), contentDescription = "", modifier = Modifier.width(15.dp))

    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun PreviewCustomButton() {
    HealthyFitnessTheme(dynamicColor = false) {

        CustomButton(buttonText = "Sign Up", icon = { IconItem("Sign Up") }) {

        }
    }
//CustomButton(buttonText = "Sign Up"){}
}
