package com.vcyberpunk.news.data.mapper

import com.vcyberpunk.news.domain.entity.Interval
import com.vcyberpunk.news.domain.entity.RefreshConfig
import com.vcyberpunk.news.domain.entity.Settings

fun Int.toInterval(): Interval {
    return Interval.entries.firstOrNull { it.minutes == this } ?: Interval.MIN_15
}

fun Settings.toRefreshConfig(): RefreshConfig = RefreshConfig(
    language = language,
    interval = interval,
    wifiOnly = wifiOnly
)