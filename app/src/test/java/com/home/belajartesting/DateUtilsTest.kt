package com.home.belajartesting

import org.junit.Assert.*

import org.junit.Test
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
//pengujian untuk memastikan hasil konversi date ke string pada class DateUtils
class DateUtilsTest {

    @Test
    fun toSimpleString() {
        val dateFormat: DateFormat = SimpleDateFormat("MM/dd/yyyy")
        var date: Date? = null
        try {
            date = dateFormat.parse("02/28/2018")
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        //memastikan dua parameter apakah memiliki nilai sama
        assertEquals("Wed, 28 Feb 2018", DateUtils.toSimpleString(date!!))
    }
}