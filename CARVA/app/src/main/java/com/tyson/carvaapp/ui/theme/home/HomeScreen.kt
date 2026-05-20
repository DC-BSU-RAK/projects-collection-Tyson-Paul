package com.tyson.carvaapp.ui.theme.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tyson.carvaapp.CarViewModel
import com.tyson.carvaapp.ServiceViewModel

@Composable
fun HomeScreen(
    onAddService: () -> Unit = {}
) {

    val carVM: CarViewModel = viewModel()
    val serviceVM: ServiceViewModel = viewModel()

    val services = serviceVM.getServices()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF071120),
                        Color(0xFF0F172A)
                    )
                )
            )
            .padding(20.dp)
    ) {

        Text(
            text = "CARVA Dashboard",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        ElevatedCard(
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Vehicle Overview",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text("Car: ${carVM.carName.value}")
                Text("Plate: ${carVM.carPlate.value}")
                Text("Mileage: ${carVM.carKm.value}")

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        carVM.saveCar(
                            "Toyota Supra",
                            "DXB 4587",
                            "48,000 KM"
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Edit Vehicle Info ")
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        ElevatedCard(
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    Icons.Default.Build,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {

                    Text(
                        "Total Services",
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        "${services.size}",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onAddService,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.Add, null)

            Spacer(modifier = Modifier.width(8.dp))

            Text("Add Service")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Recent Activity",
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {

            items(services.size) { index ->

                val service = services[index]

                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    shape = RoundedCornerShape(18.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            service.title,
                            fontWeight = FontWeight.Bold
                        )

                        Text(service.date)
                        Text(service.cost)
                    }
                }
            }
        }
    }
}