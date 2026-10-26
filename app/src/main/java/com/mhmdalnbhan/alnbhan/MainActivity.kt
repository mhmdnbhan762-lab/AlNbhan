package com.mhmdalnbhan.alnbhan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mhmdalnbhan.alnbhan.ui.screens.AzkarScreen
import com.mhmdalnbhan.alnbhan.ui.screens.CompassScreen
import com.mhmdalnbhan.alnbhan.ui.screens.HomeScreen
import com.mhmdalnbhan.alnbhan.ui.screens.SettingsScreen
import com.mhmdalnbhan.alnbhan.ui.screens.TasbihScreen
import com.mhmdalnbhan.alnbhan.ui.theme.AlNbhanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlNbhanTheme {
                AlNbhanApp()
            }
        }
    }
}

@Composable
fun AlNbhanApp() {
    var selectedTab by remember { mutableIntStateOf(0) }

    val tabs = listOf(
        "Home" to Icons.Default.Home,
        "Azkar" to Icons.Default.Star,
        "Tasbih" to Icons.Default.LocationOn,
        "Compass" to Icons.Default.LocationOn,
        "Settings" to Icons.Default.Settings,
    )

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.surface,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    tabs.forEachIndexed { index, pair ->
                        val (label, icon) = pair
                        IconButton(
                            onClick = { selectedTab = index },
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(
                                    if (selectedTab == index) {
                                        MaterialTheme.colorScheme.primary.copy(alpha = 0.18f)
                                    } else {
                                        Color.Transparent
                                    }
                                )
                                .size(52.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    imageVector = icon,
                                    contentDescription = label,
                                    tint = if (selectedTab == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (selectedTab) {
                0 -> HomeScreen()
                1 -> AzkarScreen()
                2 -> TasbihScreen()
                3 -> CompassScreen()
                4 -> SettingsScreen()
            }
        }
    }
}
