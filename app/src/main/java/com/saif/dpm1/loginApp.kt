package com.saif.dpm1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginApp() {
    Scaffold(
        /*topBar = {
            LoginTopAppBar(
                onModeChanged = { /* Aquí puedes reaccionar al cambio de opción si quieres */ }
            )
        }*/
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LoginScreen(
                onSubmit = { user, pass, mode ->
                    // TODO: Aquí haces la lógica de login (validar, llamar API, navegar, etc.)
                    // Por ahora, solo imprime en Logcat o maneja un state.
                    println("Login -> usuario=$user, pass=$pass, modo=$mode")
                }
            )
        }
    }
}