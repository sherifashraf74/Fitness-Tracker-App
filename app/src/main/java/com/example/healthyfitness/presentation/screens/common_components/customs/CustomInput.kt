package com.example.healthyfitness.presentation.screens.common_components.customs

import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.theme.Black
import com.example.healthyfitness.presentation.theme.White

@Composable
fun CustomInput(hint:String,prefix:Int,suffix:Int?=null) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    if(suffix!=null)
    TextField(
        value = textState.value,
        onValueChange = { newValue -> textState.value = newValue },
        label = { Text(hint,style = MaterialTheme.typography.bodyMedium) },
      shape = MaterialTheme.shapes.small,
        prefix = { Image(imageVector = ImageVector.vectorResource(id = prefix), contentDescription = "") },
        suffix = { Image(imageVector = ImageVector.vectorResource(id = suffix), contentDescription = "") },
        colors = TextFieldDefaults.colors( focusedContainerColor = White,   // Custom background color when focused
            unfocusedContainerColor = White, // Custom background color when unfocused
            cursorColor = Black,   // Cursor color
            focusedIndicatorColor = Black, // Line color when focused
            unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f) // Line color when unfocused
        )
        )
else
        TextField(
            value = textState.value,
            onValueChange = { newValue -> textState.value = newValue },
            placeholder = { Text(hint,style = MaterialTheme.typography.bodyMedium.copy(color = Black)) },
            shape = MaterialTheme.shapes.small,
            prefix = { Image(imageVector = ImageVector.vectorResource(id = prefix), contentDescription = "") },
            colors = TextFieldDefaults.colors( focusedContainerColor = White,   // Custom background color when focused
                unfocusedContainerColor = White, // Custom background color when unfocused
                cursorColor = Black,   // Cursor color
                focusedIndicatorColor = Black, // Line color when focused
                unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f) // Line color when unfocused
            )
        )
}
@Preview
@Composable
fun PreviewCustomInput() {
    CustomInput("Enter your name",R.drawable.ic_lock_icon)
}
