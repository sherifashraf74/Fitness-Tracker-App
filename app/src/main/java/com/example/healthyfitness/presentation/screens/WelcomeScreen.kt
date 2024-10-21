package com.example.healthyfitness.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.navigation.NavRoutes
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import com.example.healthyfitness.presentation.theme.arvoFontFamily
import com.example.healthyfitness.presentation.theme.robotoFontFamily

@Composable
fun WelcomeScreen(
    onSignIn : () -> Unit,
    onSignUp : () -> Unit
) {
    val navController = rememberNavController()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.dumblebgicons),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "",
                modifier = Modifier.padding(start = 37.dp, top = 55.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(2f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_splash_polygon),
                    contentDescription = "back ground",
                    modifier = Modifier.size(350.dp)

                )
                Image(
                    painter = painterResource(id = R.drawable.unsplash_qkqwdvrqqy8),
                    contentDescription = "back ground",
                    modifier = Modifier.size(600.dp)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(179.dp)
                    .padding()
                    .background(
                        MaterialTheme.colorScheme.secondary,
                        MaterialTheme.shapes.medium
                    )
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 30.dp, horizontal = 16.dp)
                ) {

                    Button(
                        onClick = onSignIn,
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .shadow(
                                elevation = 11.dp,
                                shape = RoundedCornerShape(12.dp),
                                clip = true,
                                spotColor = MaterialTheme.colorScheme.primary
                            )
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Sign In",
                            style = TextStyle(
                                fontFamily = arvoFontFamily,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.W700,
                                color = Color(0xFF1C2126)
                            )
                        )
                    }


                    TextButton(onClick = onSignUp) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Don't HaveAccount? ",
                                style = TextStyle(
                                    fontFamily = robotoFontFamily,
                                    fontSize = 16.sp,
                                    color = Color.White
                                )
                            )
                            Text(
                                text = "SIGN UP",
                                style = TextStyle(
                                    fontFamily = robotoFontFamily,
                                    fontSize = 18.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    HealthyFitnessTheme {
        WelcomeScreen(onSignIn = {}, onSignUp = {})
}
    }