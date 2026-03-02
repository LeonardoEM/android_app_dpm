package com.saif.dpm1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import com.saif.dpm1.R
import com.saif.dpm1.ui.theme.ButtonDisabled
import com.saif.dpm1.ui.theme.Divider
import com.saif.dpm1.ui.theme.OnBackground
import com.saif.dpm1.ui.theme.OnPrimary
import com.saif.dpm1.ui.theme.OnSurface
import com.saif.dpm1.ui.theme.PrimaryBlue
import com.saif.dpm1.ui.theme.PrimaryPurple
import com.saif.dpm1.ui.theme.PrimaryRed
import com.saif.dpm1.ui.theme.Surface

enum class LoginMode { MODO_A, MODO_B, MODO_C }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onSubmit: (usuario: String, password: String, mode: LoginMode) -> Unit
) {
    var usuario by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var mostrarPassword by remember { mutableStateOf(false) }
    var selectedMode by remember { mutableStateOf(LoginMode.MODO_A) }
    val canSubmit = usuario.isNotBlank() && password.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        PrimaryPurple.copy(alpha = 0.1f),
                        PrimaryRed.copy(alpha = 0.1f),
                        PrimaryBlue.copy(alpha = 0.1f)
                    )
                )
            )
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Logo pequeño para mantener consistencia visual con Logotipo.kt
        Icon(
            painter = painterResource(R.drawable.logo_dpm),
            contentDescription = "Logo DPM",
            modifier = Modifier.size(80.dp),
            tint = PrimaryPurple
        )

        // Encabezado mejorado
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Bienvenido a DPM",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryPurple,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Ingresa tus credenciales",
                fontSize = 16.sp,
                color = OnBackground.copy(alpha = 0.7f)
            )
        }

        // Usuario - Campo con bordes redondeados y colores personalizados
        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Usuario") },
            placeholder = { Text("Ingresa tu usuario") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PrimaryPurple,
                unfocusedBorderColor = Divider,
                focusedLabelColor = PrimaryPurple,
                cursorColor = PrimaryPurple
            )
        )

        // Contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contrasena") },
            placeholder = { Text("Ingresa tu contrasena") },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            visualTransformation = if (mostrarPassword) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                TextButton(
                    onClick = { mostrarPassword = !mostrarPassword },
                    content = {
                        Text(
                            text = if (mostrarPassword) "Ocultar" else "Mostrar",
                            color = PrimaryPurple
                        )
                    }
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PrimaryPurple,
                unfocusedBorderColor = Divider,
                focusedLabelColor = PrimaryPurple,
                cursorColor = PrimaryPurple
            )
        )

        // Selector de modo
        TriOptionSelector(
            selected = selectedMode,
            onSelected = { selectedMode = it }
        )

        // Boton de iniciar sesion
        Button(
            onClick = { onSubmit(usuario.trim(), password, selectedMode) },
            enabled = canSubmit,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentPadding = PaddingValues(vertical = 12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryPurple,
                contentColor = OnPrimary,
                disabledContainerColor = ButtonDisabled,
                disabledContentColor = OnSurface.copy(alpha = 0.5f)
            )
        ) {
            Text(
                text = "Iniciar sesion",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun TriOptionSelector(
    selected: LoginMode,
    onSelected: (LoginMode) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Modo:",
            color = OnBackground,
            fontWeight = FontWeight.Medium
        )

        val selectedIndex = when (selected) {
            LoginMode.MODO_A -> 0
            LoginMode.MODO_B -> 1
            LoginMode.MODO_C -> 2
        }

        ThreeSegmentSelector(
            selected = selectedIndex,
            onSelected = { index ->
                val mode = when (index) {
                    0 -> LoginMode.MODO_A
                    1 -> LoginMode.MODO_B
                    else -> LoginMode.MODO_C
                }
                onSelected(mode)
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThreeSegmentSelector(
    selected: Int,
    onSelected: (Int) -> Unit
) {
    val options = listOf("Dev", "QA", "Prod")
    val segmentColors = listOf(PrimaryPurple, PrimaryRed, PrimaryBlue)

    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                selected = selected == index,
                onClick = { onSelected(index) },
                shape = SegmentedButtonDefaults.itemShape(index, options.size),
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = segmentColors[index].copy(alpha = 0.2f),
                    activeContentColor = segmentColors[index],
                    inactiveContainerColor = Surface,
                    inactiveContentColor = segmentColors[index].copy(alpha = 0.6f),
                    activeBorderColor = segmentColors[index],
                    inactiveBorderColor = Divider
                )
            ) {
                Text(
                    text = label,
                    maxLines = 1,
                    softWrap = false,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = if (selected == index) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}