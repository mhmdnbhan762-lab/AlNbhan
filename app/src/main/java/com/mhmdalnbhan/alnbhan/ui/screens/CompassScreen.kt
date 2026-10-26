package com.mhmdalnbhan.alnbhan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhmdalnbhan.alnbhan.ui.theme.DarkBackground
import com.mhmdalnbhan.alnbhan.ui.theme.GoldAccent
import com.mhmdalnbhan.alnbhan.ui.theme.WhiteText

@Composable
fun CompassScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(220.dp)
                .clip(CircleShape)
                .background(GoldAccent.copy(alpha = 0.14f)),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(160.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF102334)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "N",
                    color = WhiteText,
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Text(
            text = "اتجاه القبلة",
            color = WhiteText,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp)
        )
    }
}
