package com.tyson.moodcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Main activity for launching the app
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MoodSyncApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodSyncApp() {

    // Stores selected mood and energy values
    var selectedMood by remember { mutableStateOf("Happy 😄") }
    var selectedEnergy by remember { mutableStateOf("Medium ⚡") }

    // Stores result title and recommendation list
    var resultMode by remember { mutableStateOf("") }
    var suggestions by remember { mutableStateOf(listOf<String>()) }

    // Controls popup dialog and dark mode
    var showInfo by remember { mutableStateOf(false) }
    var darkMode by remember { mutableStateOf(false) }

    // Mood dropdown options
    val moods = listOf(
        "Happy 😄",
        "Sad 😢",
        "Stressed 😫",
        "Angry 😡",
        "Relaxed 😌",
        "Tired 😴"
    )

    // Energy dropdown options
    val energyLevels = listOf(
        "Low 🔋",
        "Medium ⚡",
        "High 🚀"
    )

    // Professional color system
    val bgTop =
        if (!darkMode) Color(0xFFF5F7FA)
        else Color(0xFF101418)

    val bgBottom =
        if (!darkMode) Color(0xFFE4ECF5)
        else Color(0xFF1B232A)

    val cardColor =
        if (!darkMode) Color.White
        else Color(0xFF1F2A33)

    val primaryColor =
        if (!darkMode) Color(0xFF1565C0)
        else Color(0xFF64B5F6)

    val textColor =
        if (!darkMode) Color(0xFF1A1A1A)
        else Color.White

    val secondaryText =
        if (!darkMode) Color(0xFF555555)
        else Color(0xFFDDDDDD)

    MaterialTheme(
        colorScheme = if (darkMode) darkColorScheme() else lightColorScheme()
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(bgTop, bgBottom)
                    )
                )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 18.dp)
                    .padding(top = 18.dp, bottom = 10.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // App title section
                Text(
                    text = "MoodSync",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.SansSerif,
                    color = primaryColor
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Understand your mood. Improve your day.",
                    fontSize = 14.sp,
                    color = secondaryText
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Mood and energy input card
                Card(
                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(22.dp),

                    elevation = CardDefaults.cardElevation(8.dp),

                    colors = CardDefaults.cardColors(
                        containerColor = cardColor
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(14.dp),

                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        Text(
                            text = "How do you feel today?",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = textColor
                        )

                        // Mood dropdown
                        DropdownBox(
                            label = "Mood",
                            options = moods,
                            selected = selectedMood,
                            onSelect = { selectedMood = it },
                            darkMode = darkMode,
                            primaryColor = primaryColor
                        )

                        // Energy dropdown
                        DropdownBox(
                            label = "Energy",
                            options = energyLevels,
                            selected = selectedEnergy,
                            onSelect = { selectedEnergy = it },
                            darkMode = darkMode,
                            primaryColor = primaryColor
                        )

                        // Analyze mood button
                        Button(
                            onClick = {

                                // Generates personalized suggestions
                                when {

                                    selectedMood.contains("Happy") &&
                                            selectedEnergy.contains("High") -> {

                                        resultMode = "Adventure Mode 🚀"

                                        suggestions = listOf(
                                            "Go out with friends 🎉",
                                            "Try a new activity 🌍",
                                            "Play sports or gym ⚽"
                                        )
                                    }

                                    selectedMood.contains("Happy") &&
                                            selectedEnergy.contains("Low") -> {

                                        resultMode = "Peaceful Joy ☀️"

                                        suggestions = listOf(
                                            "Watch a comfort movie 🎬",
                                            "Read something inspiring 📖",
                                            "Take a relaxing walk 🚶"
                                        )
                                    }

                                    selectedMood.contains("Sad") &&
                                            selectedEnergy.contains("Low") -> {

                                        resultMode = "Recovery Mode 🌙"

                                        suggestions = listOf(
                                            "Take proper rest 😴",
                                            "Listen to calm music 🎧",
                                            "Avoid stressful tasks 💧"
                                        )
                                    }

                                    selectedMood.contains("Sad") &&
                                            selectedEnergy.contains("High") -> {

                                        resultMode = "Release Energy ⚡"

                                        suggestions = listOf(
                                            "Talk to someone trusted 💬",
                                            "Exercise to release tension 🏃",
                                            "Write your thoughts 📝"
                                        )
                                    }

                                    selectedMood.contains("Stressed") &&
                                            selectedEnergy.contains("High") -> {

                                        resultMode = "Overload Alert 🔥"

                                        suggestions = listOf(
                                            "Take deep breaths 🧘",
                                            "Reduce screen time 📱",
                                            "Pause multitasking ⏸️"
                                        )
                                    }

                                    selectedMood.contains("Stressed") &&
                                            selectedEnergy.contains("Low") -> {

                                        resultMode = "Mental Recharge 🌿"

                                        suggestions = listOf(
                                            "Sleep early tonight 🌙",
                                            "Drink water 💧",
                                            "Listen to calming sounds 🎵"
                                        )
                                    }

                                    selectedMood.contains("Angry") &&
                                            selectedEnergy.contains("High") -> {

                                        resultMode = "Cool Down ❄️"

                                        suggestions = listOf(
                                            "Walk away briefly 🚶",
                                            "Avoid arguments 🧠",
                                            "Use breathing exercises 🌬️"
                                        )
                                    }

                                    selectedMood.contains("Relaxed") &&
                                            selectedEnergy.contains("Medium") -> {

                                        resultMode = "Balanced State ✨"

                                        suggestions = listOf(
                                            "Maintain your routine 📅",
                                            "Enjoy hobbies 🎨",
                                            "Stay productive calmly ☕"
                                        )
                                    }

                                    selectedMood.contains("Tired") &&
                                            selectedEnergy.contains("Low") -> {

                                        resultMode = "Recharge Needed 🔋"

                                        suggestions = listOf(
                                            "Take a nap 😴",
                                            "Stretch your body 🤸",
                                            "Eat healthy food 🥗"
                                        )
                                    }

                                    else -> {

                                        resultMode = "Focus Mode 🎯"

                                        suggestions = listOf(
                                            "Stay organized 📋",
                                            "Work on small goals ✅",
                                            "Keep a positive mindset 💡"
                                        )
                                    }
                                }
                            },

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),

                            shape = RoundedCornerShape(16.dp),

                            colors = ButtonDefaults.buttonColors(
                                containerColor = primaryColor
                            )
                        ) {

                            Icon(
                                Icons.Default.Psychology,
                                contentDescription = null
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(
                                text = "Analyze Mood",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Animated result card
                AnimatedVisibility(
                    visible = resultMode.isNotEmpty(),

                    enter = fadeIn() + slideInVertically(),

                    exit = fadeOut()
                ) {

                    Card(
                        modifier = Modifier.fillMaxWidth(),

                        shape = RoundedCornerShape(22.dp),

                        elevation = CardDefaults.cardElevation(6.dp),

                        colors = CardDefaults.cardColors(
                            containerColor = cardColor
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(14.dp),

                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Icon(
                                    Icons.Default.AutoAwesome,
                                    contentDescription = null,
                                    tint = primaryColor
                                )

                                Spacer(modifier = Modifier.width(6.dp))

                                Text(
                                    text = resultMode,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = textColor
                                )
                            }

                            // Displays recommendation list
                            suggestions.forEach {

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Icon(
                                        Icons.Default.CheckCircle,
                                        contentDescription = null,
                                        tint = primaryColor
                                    )

                                    Spacer(modifier = Modifier.width(6.dp))

                                    Text(
                                        text = it,
                                        fontSize = 15.sp,
                                        color = textColor
                                    )
                                }
                            }

                            HorizontalDivider()

                            Text(
                                text = "Small actions create meaningful change",
                                fontSize = 13.sp,
                                color = secondaryText
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // About and reset buttons
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    OutlinedButton(
                        onClick = { showInfo = true }
                    ) {

                        Icon(
                            Icons.Default.Info,
                            contentDescription = null,
                            tint = primaryColor
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "About",
                            color = primaryColor
                        )
                    }

                    OutlinedButton(
                        onClick = {

                            resultMode = ""
                            suggestions = emptyList()
                        }
                    ) {

                        Icon(
                            Icons.Default.Refresh,
                            contentDescription = null,
                            tint = primaryColor
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "Reset",
                            color = primaryColor
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                // Dark mode toggle
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        Icons.Default.DarkMode,
                        contentDescription = null,
                        tint = textColor
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = "Dark Mode",
                        color = textColor
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Switch(
                        checked = darkMode,
                        onCheckedChange = {
                            darkMode = it
                        }
                    )
                }
            }

            // About popup dialog
            if (showInfo) {

                AlertDialog(
                    onDismissRequest = {
                        showInfo = false
                    },

                    confirmButton = {

                        Button(
                            onClick = {
                                showInfo = false
                            }
                        ) {
                            Text("OK")
                        }
                    },

                    title = {
                        Text("About MoodSync")
                    },

                    text = {

                        Text(
                            "This MoodSync App analyzes mood and energy levels to provide personalized emotional lifestyle suggestions.\n\n" +
                                    "Select your mood and energy, then tap Analyze Mood to receive smart recommendations."
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun DropdownBox(
    label: String,
    options: List<String>,
    selected: String,
    onSelect: (String) -> Unit,
    darkMode: Boolean,
    primaryColor: Color
) {

    // Controls dropdown expansion
    var expanded by remember {
        mutableStateOf(false)
    }

    val textColor =
        if (!darkMode) Color.Black
        else Color.White

    Column {

        Text(
            text = label,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = textColor
        )

        Spacer(modifier = Modifier.height(4.dp))

        Button(
            onClick = {
                expanded = true
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp),

            shape = RoundedCornerShape(14.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColor
            )
        ) {

            Text(
                text = selected,
                fontSize = 15.sp
            )
        }

        // Dropdown menu component
        DropdownMenu(
            expanded = expanded,

            onDismissRequest = {
                expanded = false
            }
        ) {

            options.forEach {

                DropdownMenuItem(
                    text = {
                        Text(it)
                    },

                    onClick = {

                        onSelect(it)
                        expanded = false
                    }
                )
            }
        }
    }
}