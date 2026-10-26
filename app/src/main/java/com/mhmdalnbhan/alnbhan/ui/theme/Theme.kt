package com.mhmdalnbhan.alnbhan.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val AppDarkColors = darkColorScheme(
    primary = GoldAccent,
    secondary = TealAccent,
    background = DarkBackground,
    surface = SurfaceDark,
    onPrimary = DarkBackground,
    onSecondary = DarkBackground,
    onBackground = WhiteText,
    onSurface = WhiteText,
    surfaceVariant = CardSurface,
    onSurfaceVariant = MutedText
)

@Composable
fun AlNbhanTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppDarkColors,
        content = content
    )
}
