package com.tyson.carvaapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.tyson.carvaapp.data.datastore.UserPreferences
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application) : AndroidViewModel(application) {

    private val prefs = UserPreferences(application)

    val darkMode = prefs.darkMode
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            false
        )

    fun toggleDarkMode(value: Boolean) {

        viewModelScope.launch {

            prefs.setDarkMode(value)
        }
    }
}