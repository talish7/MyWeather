package com.tian.myweather.utils

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/20: 21: 36
 * @Description: 描述
 */
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

object DateUtils {

    private val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    /**
     * 根据日期字符串返回星期几（DayOfWeek枚举）
     *
     * @param dateStr 日期字符串，格式为"yyyy-MM-dd"
     * @return 对应的星期几，如果解析失败则返回null
     */
    fun getDayOfWeek(dateStr: String?): String? {
        return try {
            val date = LocalDate.parse(dateStr, dateFormat)
            when(date.dayOfWeek){
                DayOfWeek.MONDAY -> "星期一"
                DayOfWeek.TUESDAY -> "星期二"
                DayOfWeek.WEDNESDAY -> "星期三"
                DayOfWeek.THURSDAY -> "星期四"
                DayOfWeek.FRIDAY -> "星期五"
                DayOfWeek.SATURDAY -> "星期六"
                DayOfWeek.SUNDAY -> "星期日"
            }
        } catch (e: Exception) {
            null
        }
    }



    /**
     * 从给定的日期时间字符串中提取T后面的五个字符。
     *
     * @param dateTimeStr 包含日期和时间的字符串，格式为YYYY-MM-DDTHH:mmTZD（例如："2021-02-16T16:00+08:00"）
     * @return T后面的五个字符，如果字符串格式不正确或T后不足五个字符则返回null
     */
    fun extractTimeFromDateTimeStr(dateTimeStr: String): String? {
        val tIndex = dateTimeStr.indexOf('T')
        if (tIndex != -1 && dateTimeStr.length > tIndex + 5) {
            return dateTimeStr.substring(tIndex + 1, tIndex + 6)
        }
        return null
    }

}

fun main(){
    println(DateUtils.getDayOfWeek("2019-07-30"))
    println(DateUtils.extractTimeFromDateTimeStr("2021-02-16T16:00+08:00"))
}

