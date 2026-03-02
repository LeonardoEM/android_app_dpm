package com.saif.dpm1.components.animations

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.saif.dpm1.LoginApp
import com.saif.dpm1.Logotipo
import kotlinx.coroutines.delay

@Composable
fun MyCrossfade(modifier: Modifier = Modifier, segundos: Int) {
    var currentScreen by remember { mutableStateOf("Detail") }
    var timeForScreenSplash by remember { mutableStateOf(segundos) }

    LaunchedEffect(timeForScreenSplash) {//siempre que haya un cambio en esa variable, este se ejecuta
        if (timeForScreenSplash>0){
            delay(1000)
            timeForScreenSplash--
        }else{
            currentScreen="Home"
        }
    }


    Crossfade(targetState = currentScreen) {
        screen ->
        when (screen) {
            "Home" -> LoginApp()
            "Detail"-> Logotipo()
        }
    }
}
