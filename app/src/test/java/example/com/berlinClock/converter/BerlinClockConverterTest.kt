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
    fun `returns 0 for first row of hours when hours is equal to 0`() {
        val actual = calculateBerlinClockFor(hours = 0)

        assertEquals(0, actual.hoursFirstRowCount)
    }

    @Test
    fun `returns 1 for first row of hours when hours is equal to 5`() {
        val actual = calculateBerlinClockFor(hours = 5)

        assertEquals(1, actual.hoursFirstRowCount)
    }

    @Test
    fun `returns 0 for second row of hours when remainder of division by 5 is equal to 0`() {
        val actualWhenZero = calculateBerlinClockFor(hours = 0)

        assertEquals(0, actualWhenZero.hoursSecondRowCount)

        val actualWhenFive = calculateBerlinClockFor(hours = 5)

        assertEquals(0, actualWhenFive.hoursSecondRowCount)
    }

    @Test
    fun `returns 3 for second row of hours when remainder of division by 5 is equal to 3`() {
        val actualWhenThree = calculateBerlinClockFor(hours = 3)

        assertEquals(3, actualWhenThree.hoursSecondRowCount)

        val actualWhenEight = calculateBerlinClockFor(hours = 3)

        assertEquals(3, actualWhenEight.hoursSecondRowCount)
    }

    @Test
    fun `returns 0 for first row of minutes when minutes is equal to 0`() {
        val actual = calculateBerlinClockFor(minutes = 0)

        assertEquals(0, actual.minutesFirstRowCount)
    }

    private fun calculateBerlinClockFor(hours: Int = 0, minutes: Int = 0, seconds: Int = 0) =
        BerlinClockConverter.convertToBerlinClock(
            GregorianCalendar(
                2022,
                1,
                1,
                hours,
                minutes,
                seconds
            )
        )
}