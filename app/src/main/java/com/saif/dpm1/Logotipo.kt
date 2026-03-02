package com.saif.dpm1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saif.dpm1.R
import com.saif.dpm1.ui.theme.PrimaryPurple
import com.saif.dpm1.ui.theme.PrimaryRed
import com.saif.dpm1.ui.theme.PrimaryBlue

@Composable
fun Logotipo(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        PrimaryPurple.copy(alpha = 0.3f),
                        PrimaryRed.copy(alpha = 0.3f),
                        PrimaryBlue.copy(alpha = 0.3f)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.logo_dpm),
            contentDescription = "Logo DPM",
            modifier = Modifier.size(300.dp),
            tint = PrimaryPurple
        )
    }
}