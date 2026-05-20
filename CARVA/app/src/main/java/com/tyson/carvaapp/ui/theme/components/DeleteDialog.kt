package com.tyson.carvaapp.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun DeleteDialog(
    show: Boolean,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    if (show) {

        AlertDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                TextButton(onClick = onConfirm) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text("Cancel")
                }
            },
            title = {
                Text("Delete Service?")
            },
            text = {
                Text("This action cannot be undone.")
            }
        )
    }
}