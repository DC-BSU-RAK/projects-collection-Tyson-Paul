package com.tyson.carvaapp.ui.theme.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tyson.carvaapp.R

@Composable
fun SplashScreen(
    onFinish: () -> Unit
) {

    var startAnim by remember {
        mutableStateOf(false)
    }

    val scale by animateFloatAsState(
        targetValue = if (startAnim) 1f else 0.6f,
        animationSpec = tween(1200),
        label = ""
    )

    LaunchedEffect(Unit) {

        startAnim = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0F172A),
                        Color(0xFF1E293B),
                        Color(0xFF334155)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.scale(scale)
        ) {

            Image(
                painter = painterResource(id = R.drawable.carva_logo),
                contentDescription = "CARVA Logo",
                modifier = Modifier.size(140.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "CARVA",
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Smart Car Service Manager",
                color = Color.LightGray,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            CircularProgressIndicator(
                color = Color.White
            )
        }
    }
}