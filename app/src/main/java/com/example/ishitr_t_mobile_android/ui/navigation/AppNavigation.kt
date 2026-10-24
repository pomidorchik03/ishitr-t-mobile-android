package com.example.ishitr_t_mobile_android.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.modifier.modifierLocalOf
import com.example.ishitr_t_mobile_android.ui.auth.AuthScreen
import com.example.ishitr_t_mobile_android.ui.family.FamilyGroupScreen
import com.example.ishitr_t_mobile_android.ui.stats.StatisticsScreen

private enum class AppScreen {
    AUTH,
    FAMILY,
    STATS
}

@Composable
fun AppNavigation() {
    var currentScreen by remember { mutableStateOf(AppScreen.AUTH) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextButton(
                onClick = {
                    currentScreen = AppScreen.AUTH
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Вход")
            }
            TextButton(
                onClick = { currentScreen = AppScreen.FAMILY },
                modifier = Modifier.weight(1f)
            ) {
                Text("Семья")
            }
            TextButton(
                onClick = { currentScreen = AppScreen.STATS },
                modifier = Modifier.weight(1f)
            ) {
                Text("Статистика")
            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            when (currentScreen) {
                AppScreen.AUTH -> AuthScreen()
                AppScreen.FAMILY -> FamilyGroupScreen()
                AppScreen.STATS -> StatisticsScreen()
            }
        }
    }
}