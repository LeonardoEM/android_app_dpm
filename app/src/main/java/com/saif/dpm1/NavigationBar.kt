package com.saif.dpm1

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior(
    titulo: String,
    mostrarBotonAtras: Boolean = false,
    onBotonAtrasClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},      // Por si acaso se usa
    onMenuClick: () -> Unit = {}         // Click en hamburguesa o 3 puntos
) {
    TopAppBar(
        title = { Text(titulo) },
        navigationIcon = {
            if (mostrarBotonAtras) {
                IconButton(onClick = onBotonAtrasClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Volver"
                    )
                }
            } else {
                IconButton(onClick = onMenuClick) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Abrir menú"
                    )
                }
            }
        },
        actions = {
            // Lupa (siempre visible por si acaso)
            IconButton(onClick = onSearchClick) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar"
                )
            }

            // Tres puntos
            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Más opciones"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
              // Aqui se personaliza la navigation bar
        )
    )
}

// Preview para ver cómo se ve
@Preview(showBackground = true)
@Composable
fun BarraSuperiorPreview() {
    BarraSuperior(
        titulo = "DPM",
        mostrarBotonAtras = false
    )
}

// Preview con botón de atrás
@Preview(showBackground = true)
@Composable
fun BarraSuperiorAtrasPreview() {
    BarraSuperior(
        titulo = "Detalles",
        mostrarBotonAtras = true
    )
}