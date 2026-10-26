package com.mhmdalnbhan.alnbhan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhmdalnbhan.alnbhan.ui.theme.DarkBackground
import com.mhmdalnbhan.alnbhan.ui.theme.GoldAccent
import com.mhmdalnbhan.alnbhan.ui.theme.WhiteText

@Composable
fun TasbihScreen() {
    var count by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
                .background(GoldAccent.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = count.toString(),
                color = WhiteText,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold
            )
        }

        androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(18.dp))

        Button(
            onClick = { count++ },
            modifier = Modifier.padding(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = GoldAccent)
        ) {
            Text(text = "تسبيح", color = Color(0xFF071927), fontWeight = FontWeight.Bold)
        }

        Button(
            onClick = { count = 0 },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B2E42))
        ) {
            Text(text = "إعادة", color = WhiteText)
        }
    }
}
