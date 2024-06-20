package com.mohmmed.mosa.eg.news.util

import android.annotation.SuppressLint
import com.mohmmed.mosa.eg.news.util.Constant.DEFAULT_DATE_PATTERN
import org.ocpsoft.prettytime.PrettyTime
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.Date

fun stringToDate(string: String, pattern: String = DEFAULT_DATE_PATTERN): Date {
    var date: Date? = null
    date = SimpleDateFormat(pattern).parse(string) as Date
    return date
}


fun prettyTime(date: Date): String {
    return PrettyTime().format(date)
}
