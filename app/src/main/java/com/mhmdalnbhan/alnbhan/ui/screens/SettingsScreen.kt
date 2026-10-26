package com.mhmdalnbhan.alnbhan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhmdalnbhan.alnbhan.ui.theme.DarkBackground
import com.mhmdalnbhan.alnbhan.ui.theme.MutedText
import com.mhmdalnbhan.alnbhan.ui.theme.SurfaceDark
import com.mhmdalnbhan.alnbhan.ui.theme.WhiteText

@Composable
fun SettingsScreen() {
    val settings = listOf(
        "تغيير اللغة" to "العربية",
        "تغيير ال��ظهر" to "داكن فاخر",
        "تغيير المنطقة" to "الرياض",
        "تفعيل التنبيهات" to "مفعّل"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "الإعدادات",
                color = WhiteText,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
        }

        items(settings) { (label, value) ->
            Card(
                colors = CardDefaults.cardColors(containerColor = SurfaceDark),
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = label, color = WhiteText, fontSize = 16.sp)
                    Text(text = value, color = MutedText, fontSize = 14.sp)
                }
            }
        }

        item {
            var notifications by remember { mutableStateOf(true) }
            Card(
                colors = CardDefaults.cardColors(containerColor = SurfaceDark),
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "الإشعارات", color = WhiteText, fontSize = 16.sp)
                    Switch(checked = notifications, onCheckedChange = { notifications = it })
                }
            }
        }
    }
}
