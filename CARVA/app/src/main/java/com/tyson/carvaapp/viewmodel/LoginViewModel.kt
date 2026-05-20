package com.tyson.carvaapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var username = mutableStateOf("Tyson Paul")
    var email = mutableStateOf("tyson@gmail.com")
    var phone = mutableStateOf("+971 50 000 0000")

    fun login(
        name: String,
        userEmail: String,
        userPhone: String
    ) {
        username.value = name
        email.value = userEmail
        phone.value = userPhone
    }

    fun logout() {

        username.value = ""
        email.value = ""
        phone.value = ""
    }
}