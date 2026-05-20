package com.tyson.carvaapp.ui.theme.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tyson.carvaapp.ServiceViewModel

@Composable
fun HistoryScreen() {

    val vm: ServiceViewModel = viewModel()

    val services = vm.getServices()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            "Service History",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (services.isEmpty()) {

            Text("No services added yet")

        } else {

            LazyColumn {

                items(services) { service ->

                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {

                            Text(service.title)
                            Text(service.date)
                            Text(service.cost)
                            Text(service.note)

                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = {
                                    vm.deleteService(service)
                                }
                            ) {
                                Text("Delete")
                            }
                        }
                    }
                }
            }
        }
    }
}