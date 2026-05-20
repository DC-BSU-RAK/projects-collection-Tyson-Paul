package com.tyson.carvaapp.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "carva_prefs")

class UserPreferences(private val context: Context) {

    companion object {

        // USER
        val USER_NAME = stringPreferencesKey("user_name")
        val USER_EMAIL = stringPreferencesKey("user_email")
        val USER_PHONE = stringPreferencesKey("user_phone")

        // CAR
        val CAR_NAME = stringPreferencesKey("car_name")
        val CAR_PLATE = stringPreferencesKey("car_plate")
        val CAR_KM = stringPreferencesKey("car_km")

        // SETTINGS
        val DARK_MODE = booleanPreferencesKey("dark_mode")
    }

    // =========================
    // USER FLOWS
    // =========================

    val username = context.dataStore.data.map {
        it[USER_NAME] ?: ""
    }

    val email = context.dataStore.data.map {
        it[USER_EMAIL] ?: ""
    }

    val phone = context.dataStore.data.map {
        it[USER_PHONE] ?: ""
    }

    // =========================
    // CAR FLOWS
    // =========================

    val carName = context.dataStore.data.map {
        it[CAR_NAME] ?: ""
    }

    val carPlate = context.dataStore.data.map {
        it[CAR_PLATE] ?: ""
    }

    val carKm = context.dataStore.data.map {
        it[CAR_KM] ?: ""
    }

    // =========================
    // DARK MODE
    // =========================

    val darkMode = context.dataStore.data.map {
        it[DARK_MODE] ?: false
    }

    // =========================
    // SAVE USER
    // =========================

    suspend fun setUser(
        name: String,
        email: String,
        phone: String
    ) {

        context.dataStore.edit {

            it[USER_NAME] = name
            it[USER_EMAIL] = email
            it[USER_PHONE] = phone
        }
    }

    // =========================
    // CLEAR USER
    // =========================

    suspend fun clearUser() {

        context.dataStore.edit {

            it[USER_NAME] = ""
            it[USER_EMAIL] = ""
            it[USER_PHONE] = ""
        }
    }

    // =========================
    // SAVE CAR
    // =========================

    suspend fun setCar(
        name: String,
        plate: String,
        km: String
    ) {

        context.dataStore.edit {

            it[CAR_NAME] = name
            it[CAR_PLATE] = plate
            it[CAR_KM] = km
        }
    }

    // =========================
    // DARK MODE
    // =========================

    suspend fun setDarkMode(value: Boolean) {

        context.dataStore.edit {

            it[DARK_MODE] = value
        }
    }
}