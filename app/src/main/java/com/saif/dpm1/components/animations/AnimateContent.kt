package com.saif.dpm1.components.animations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyAnimateContent(modifier: Modifier= Modifier){
    var number by remember { mutableIntStateOf(0) }

    Column(Modifier.fillMaxSize().padding(top=48.dp)) {
        Button(onClick = {number ++}) {
            Text("Sumar")
        }
        Spacer(Modifier.height(32.dp))

        Text(number.toString())
    }
}