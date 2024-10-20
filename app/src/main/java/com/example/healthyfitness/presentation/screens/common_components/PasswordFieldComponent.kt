package com.example.healthyfitness.presentation.screens.common_components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.healthyfitness.presentation.theme.robotoFontFamily
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldComponent(@DrawableRes icon: Int,label: String, password: String, onPasswordChange: (String) -> Unit,error: String?) {
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        leadingIcon = { Image(painter = painterResource(icon), contentDescription = "password Icon") },
        value = password,
        onValueChange = onPasswordChange,
        label = { Text(text = label,
            style= TextStyle(
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.W400,
            )
        ) },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, contentDescription = null)
            }
        },
        shape = MaterialTheme.shapes.large,  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
         )
}

//@Preview
//@Composable
//private fun PasswordFieldPreview() {
//    PasswordFieldComponent(label = "Password", password = "dsdfsdf") { }
//
//}