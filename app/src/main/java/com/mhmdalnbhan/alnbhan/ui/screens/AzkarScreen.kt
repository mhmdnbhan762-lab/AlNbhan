package com.mhmdalnbhan.alnbhan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhmdalnbhan.alnbhan.ui.theme.DarkBackground
import com.mhmdalnbhan.alnbhan.ui.theme.SurfaceDark
import com.mhmdalnbhan.alnbhan.ui.theme.WhiteText

@Composable
fun AzkarScreen() {
    val azkar = listOf(
        "أذكار الصباح",
        "أذكار المساء",
        "دعاء السفر",
        "دعاء الاستيقاظ",
        "ذكر خاص"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Text(
                text = "الأذكار",
                color = WhiteText,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
        }

        items(azkar) { item ->
            Card(
                colors = CardDefaults.cardColors(containerColor = SurfaceDark),
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = item,
                    color = WhiteText,
                    modifier = Modifier.padding(18.dp),
                    fontSize = 18.sp
                )
            }
        }
    }
}
