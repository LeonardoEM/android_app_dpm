package com.saif.dpm1

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//enum class LoginMode { MODO_A, MODO_B, MODO_C }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTopAppBar(
    onModeChanged: (LoginMode) -> Unit
) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    SingleChoiceSegmentedButtonRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        (0..2).forEach { index ->
            SegmentedButton(
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                shape = SegmentedButtonDefaults.itemShape(index, 3),
            ) {
                Text("Option ${index + 1}")
            }
        }
    }

    Text(
        text = "Selected Option: ${selectedIndex + 1}",
        style = MaterialTheme.typography.bodySmall
    )

    Spacer(Modifier.height(16.dp))

    var selectedIndex1 by remember { mutableIntStateOf(0) }
    SingleChoiceSegmentedButtonRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        (0..4).forEach { index ->
            SegmentedButton(
                selected = selectedIndex1 == index,
                onClick = { selectedIndex1 = index },
                shape = SegmentedButtonDefaults.itemShape(index, 5),
                icon = {
                    SegmentedButtonDefaults.Icon(selectedIndex1 == index, activeContent = {
                        Icon(Icons.Default.Favorite, null)
                    })
                }
            ) {
                Text("${index + 1}")
            }
        }
    }

    Text(
        text = "Selected Option: ${selectedIndex1 + 1}",
        style = MaterialTheme.typography.bodySmall
    )
}
