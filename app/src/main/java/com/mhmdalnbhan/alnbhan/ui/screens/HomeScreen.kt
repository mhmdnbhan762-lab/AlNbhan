package com.mhmdalnbhan.alnbhan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mhmdalnbhan.alnbhan.model.PrayerItem
import com.mhmdalnbhan.alnbhan.ui.theme.DarkBackground
import com.mhmdalnbhan.alnbhan.ui.theme.GoldAccent
import com.mhmdalnbhan.alnbhan.ui.theme.GoldSoft
import com.mhmdalnbhan.alnbhan.ui.theme.MutedText
import com.mhmdalnbhan.alnbhan.ui.theme.SurfaceDark
import com.mhmdalnbhan.alnbhan.ui.theme.WhiteText
import com.mhmdalnbhan.alnbhan.viewmodel.AppViewModel

@Composable
fun HomeScreen(viewModel: AppViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(horizontal = 18.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            HeaderCard(
                time = uiState.currentTime,
                gregorianDate = uiState.gregorianDate,
                hijriDate = uiState.hijriDate
            )
        }

        item {
            NextPrayerCard(
                prayer = uiState.nextPrayer,
                time = uiState.nextPrayerTime
            )
        }

        item {
            Text(
                text = "أوقات الصلاة",
                color = WhiteText,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        items(uiState.prayerList) { prayer ->
            PrayerRow(item = prayer)
        }
    }
}

@Composable
private fun HeaderCard(time: String, gregorianDate: String, hijriDate: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = SurfaceDark),
        shape = RoundedCornerShape(28.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            GoldAccent.copy(alpha = 0.42f),
                            SurfaceDark
                        )
                    )
                )
                .padding(20.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "AlNbhan",
                    color = GoldSoft,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = time,
                    color = WhiteText,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = hijriDate, color = GoldSoft, fontSize = 14.sp)
                    Text(text = gregorianDate, color = MutedText, fontSize = 14.sp)
                }
            }
        }
    }
}

@Composable
private fun NextPrayerCard(prayer: String, time: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = SurfaceDark),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "الصلاة القادمة", color = MutedText, fontSize = 13.sp)
                Text(text = prayer, color = WhiteText, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
            Box(
                modifier = Modifier
                    .size(58.dp)
                    .clip(CircleShape)
                    .background(GoldAccent.copy(alpha = 0.18f)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = time, color = GoldSoft, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun PrayerRow(item: PrayerItem) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (item.isNext) GoldAccent.copy(alpha = 0.14f) else SurfaceDark
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = item.title,
                color = if (item.isNext) WhiteText else WhiteText,
                fontSize = 18.sp,
                fontWeight = if (item.isNext) FontWeight.Bold else FontWeight.Normal
            )
            Text(
                text = item.time,
                color = if (item.isNext) GoldSoft else MutedText,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
