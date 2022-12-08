package example.com.berlinClock.converter

import example.com.berlinClock.models.BerlinClockValues
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class BerlinClockConverterTest {

    @Test
    fun `returns true when seconds are even`() {
        val actual = calculateBerlinClockFor(seconds = 0)

        assertEquals(true, actual.secondsIndicatorOn)
    }

    @Test
    fun `returns false when seconds are odd`() {
        val actual = calculateBerlinClockFor(seconds = 1)

        assertEquals(false, actual.secondsIndicatorOn)
    }

    @Test
    fun `returns 0 for first row of hours when hours is equal to 0`(){
        val actual = calculateBerlinClockFor(hours = 0)

        assertEquals(0, actual.hoursFirstRowCount)

    }

    private fun calculateBerlinClockFor(hours:Int=0, seconds: Int=0): BerlinClockValues =
        BerlinClockConverter.convertToBerlinClock(
            GregorianCalendar(
                2022,
                1,
                1,
                hours,
                0,
                seconds
            )
        )
}