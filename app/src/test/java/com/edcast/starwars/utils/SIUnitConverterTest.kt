package com.edcast.starwars.utils


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SIUnitConverterTest {

    @Test
    fun `cms given null expect 0`() {
        val result=SIUnitConverter.convertCentimeterToMeter(null)
        assertThat(result).isEqualTo("0.0")
    }

    @Test
    fun `cms value given expect success`() {
        val result=SIUnitConverter.convertCentimeterToMeter("77")
        assertThat(result).isEqualTo("0.77")
    }

    @Test
    fun `mass given null expect 0`() {
        val result=SIUnitConverter.massToKgs(null)
        assertThat(result).isEqualTo("0 kg")
    }

    @Test
    fun `mass value given expect success`() {
        val result=SIUnitConverter.massToKgs("77")
        assertThat(result).isEqualTo("77 kgs")
    }

    @Test
    fun massToKgs() {
    }
}