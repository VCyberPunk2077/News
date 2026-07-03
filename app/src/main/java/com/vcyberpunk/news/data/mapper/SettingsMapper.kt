package com.vcyberpunk.news.data.mapper

import com.vcyberpunk.news.domain.entity.Interval

fun Int.toInterval(): Interval {
    return Interval.entries.firstOrNull { it.minutes == this } ?: Interval.MIN_15
}