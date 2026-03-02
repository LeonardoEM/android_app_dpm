package com.saif.dpm1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.saif.dpm1.ui.theme.Dpm1Theme
import com.saif.dpm1.components.animations.MyCrossfade
import com.saif.dpm1.configLogin.generarMenuLogin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val ssTimer = 4

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Usamos Dpm1Theme en lugar de MaterialTheme
            Dpm1Theme {
                generarMenuLogin()
                //MyCrossfade(segundos = ssTimer)
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        // Esta funcion ya no se usa pero la mantenemos
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Dpm1Theme {
            Greeting("Android")
        }
    }
}