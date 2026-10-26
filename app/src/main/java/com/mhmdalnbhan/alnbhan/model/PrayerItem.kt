package com.mhmdalnbhan.alnbhan.model

data class PrayerItem(
    val title: String,
    val time: String,
    val isNext: Boolean = false
)
