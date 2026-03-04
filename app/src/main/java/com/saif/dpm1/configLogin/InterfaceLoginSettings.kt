package com.saif.dpm1.configLogin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.saif.dpm1.configLogin.rolesLoginSettings.FormScreenDeveloperRol
import com.saif.dpm1.configLogin.rolesLoginSettings.FormScreenProductionRol
import com.saif.dpm1.configLogin.rolesLoginSettings.FormScreenTestRol

@Composable
fun FullScreenContainer(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .systemBarsPadding()
            .imePadding(), // también se adapta cuando aparece el teclado
        content = content
    )
}

@Composable
fun TabbedScreen(
    tabs: List<String>,
    modifier: Modifier = Modifier,
    content: @Composable (selectedIndex: Int) -> Unit
) {
    var selectedIndex by remember { mutableStateOf(0) }

    Column(modifier = modifier.fillMaxSize()) {

        // ── Barra de selección ──────────────────────────────────────
        ScrollableTabRow(
            selectedTabIndex = selectedIndex,
            edgePadding = 0.dp
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedIndex == index,
                    onClick = { selectedIndex = index },
                    text = { Text(text = title) }
                )
            }
        }

        // ── Contenido dinámico ──────────────────────────────────────
        Box(modifier = Modifier.fillMaxSize()) {
            content(selectedIndex)
        }
    }
}



@Composable
fun generarMenuLogin() {
    val tabs = listOf("Desarrollo", "Pruebas", "Produccion")
    FullScreenContainer{
        TabbedScreen(tabs=tabs) {selectedIndex ->
            when(selectedIndex){
                0-> FormScreenDeveloperRol()
                1-> FormScreenTestRol()
                2-> FormScreenProductionRol()
            }
        }
    }
}