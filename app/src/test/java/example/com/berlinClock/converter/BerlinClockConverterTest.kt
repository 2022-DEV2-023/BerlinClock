package example.com.berlinClock.converter

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class BerlinClockConverterTest {

    @Test
    fun `returns true when seconds are even`() {
        val actual = calculateBerlinClockFor(seconds = 0)

        assertEquals(true, actual)
    }

    @Test
    fun `returns false when seconds are odd`() {
        val actual = calculateBerlinClockFor(seconds = 1)

        assertEquals(false, actual)
    }

    private fun calculateBerlinClockFor(seconds: Int): Boolean =
        BerlinClockConverter.convertToBerlinClock(
            GregorianCalendar(
                2022,
                1,
                1,
                0,
                0,
                seconds
            )
        )
}