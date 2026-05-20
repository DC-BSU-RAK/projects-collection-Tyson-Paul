package com.tyson.carvaapp.ui.theme.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tyson.carvaapp.LoginViewModel

@Composable
fun ProfileScreen(
    onLogout: () -> Unit
) {

    val vm: LoginViewModel = viewModel()

    val name = vm.username.value
    val email = vm.email.value
    val phone = vm.phone.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0F172A),
                        Color(0xFF111827)
                    )
                )
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Surface(
            shape = CircleShape
        ) {

            Box(
                modifier = Modifier.size(100.dp),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = name.take(1),
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = name,
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = email,
            color = Color.LightGray
        )

        Spacer(modifier = Modifier.height(30.dp))

        ElevatedCard(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text("Phone: $phone")

                Spacer(modifier = Modifier.height(10.dp))

                Text("Premium CARVA Member")
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                vm.logout()
                onLogout()
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Logout")
        }
    }
}