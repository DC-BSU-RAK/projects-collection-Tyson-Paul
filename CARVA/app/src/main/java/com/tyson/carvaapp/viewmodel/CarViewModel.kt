package com.tyson.carvaapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CarViewModel : ViewModel() {

    var carName = mutableStateOf("BMW M4")
    var carPlate = mutableStateOf("RAK 2025")
    var carKm = mutableStateOf("12,450 KM")

    fun saveCar(
        name: String,
        plate: String,
        km: String
    ) {
        carName.value = name
        carPlate.value = plate
        carKm.value = km
    }
}