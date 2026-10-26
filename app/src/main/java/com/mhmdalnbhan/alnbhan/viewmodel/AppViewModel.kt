package com.mhmdalnbhan.alnbhan.viewmodel

import androidx.lifecycle.ViewModel
import com.mhmdalnbhan.alnbhan.model.PrayerItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AppUiState(
    val currentTime: String = "05:42",
    val gregorianDate: String = "26/10/2026",
    val hijriDate: String = "١٤٤٦ هجري",
    val nextPrayer: String = "العصر",
    val nextPrayerTime: String = "15:18",
    val prayerList: List<PrayerItem> = listOf(
        PrayerItem("الفجر", "04:58"),
        PrayerItem("الشروق", "06:18"),
        PrayerItem("الظهر", "12:18"),
        PrayerItem("العصر", "15:18", true),
        PrayerItem("المغرب", "17:55"),
        PrayerItem("العشاء", "19:35")
    )
)

class AppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()
}
