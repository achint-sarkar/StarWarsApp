package com.edcast.starwars.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DateFormatterUtilsTest {

    @Test
    fun `both date format and wrong dateString given expected false `() {
        val result = DateFormatterUtils.changeFormat(
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "dd-MMM-yyyy HH:mm:ss",
            "2014-12-09T13:50:51"
        )
        assertThat(result).isEqualTo("Unparseable Date")
    }

    @Test
    fun `source date format given wrong and result dateString given correct expected false `() {
        val result = DateFormatterUtils.changeFormat(
            "yyyy-MM-dd'T'HH:mm:ss'Z'",
            "dd-MMM-yyyy HH:mm:ss",
            "2014-12-09T13:50:51.644000Z"
        )
        assertThat(result).isEqualTo("Unparseable Date")
    }



    @Test
    fun `both date format and dateString given expected return true `() {
        val result = DateFormatterUtils.changeFormat(
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "dd-MMM-yyyy HH:mm:ss",
            "2014-12-09T13:50:51.644000Z"
        )
        assertThat(result).isEqualTo("09-Dec-2014 14:01:35")
    }


}