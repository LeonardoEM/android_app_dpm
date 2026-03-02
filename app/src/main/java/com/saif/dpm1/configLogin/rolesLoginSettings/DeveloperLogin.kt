package com.saif.dpm1.configLogin.rolesLoginSettings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.saif.dpm1.LoginMode
import com.saif.dpm1.configLogin.FormField
import com.saif.dpm1.configLogin.SavedDataRow

data class FormState(
    val protocolo: String = "awdad",
    val cluster: String = "qqq",
    val port: String = "123"
)

@Composable
fun FormScreenDeveloperRol(){

    // ── State ───────────────────────────────────────────────────────
    val defaultState = FormState()

    var formState by remember { mutableStateOf(defaultState) }
    var savedState by remember { mutableStateOf<FormState?>(null) }

    // Temp fields (what the user is typing)
    var protocoloInput    by remember { mutableStateOf("") }
    var clusterInput   by remember { mutableStateOf("") }
    var portInput   by remember { mutableStateOf("") }
    //var addressInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Desarrollo",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        // ── Fields ──────────────────────────────────────────────────
        FormField(
            label = "Protocolo",
            value = protocoloInput,
            onValueChange = { protocoloInput = it },
            placeholder = "John Doe"
        )

        FormField(
            label = "Cluster",
            value = clusterInput,
            onValueChange = { clusterInput = it },
            placeholder = "0000.0000.0000.0000",
            keyboardType = KeyboardType.Decimal
        )

        FormField(
            label = "Port",
            value = portInput,
            onValueChange = { portInput = it },
            placeholder = "0000",
            keyboardType = KeyboardType.Number
        )

        Spacer(modifier = Modifier.height(8.dp))

        // ── Buttons ─────────────────────────────────────────────────
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // SAVE
            Button(
                onClick = {
                    formState = FormState(
                        protocolo    = protocoloInput,
                        cluster   = clusterInput,
                        port   = portInput
                    )
                    println(protocoloInput+", " + clusterInput+", "+portInput)
                    savedState = formState
                },
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Default.Check, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Save")
            }

            // RESET
            OutlinedButton(
                onClick = {
                    protocoloInput    = defaultState.protocolo
                    clusterInput   = defaultState.cluster
                    portInput   = defaultState.port
                    formState    = defaultState
                    savedState   = null
                },
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Default.Refresh, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Reset")
            }
        }

        // ── Saved values preview ────────────────────────────────────
        savedState?.let { saved ->
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Saved Data",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            SavedDataRow(label = "Protocol",    value = saved.protocolo)
            SavedDataRow(label = "Cluster",   value = saved.cluster)
            SavedDataRow(label = "Port",   value = saved.port)

            LaunchedEffect(saved.protocolo) { }
        }
    }
}