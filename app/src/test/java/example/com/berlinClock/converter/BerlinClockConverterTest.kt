package example.com.berlinClock.converter

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class BerlinClockConverterTest {

    @Test
    fun `returns true when seconds are even`() {
        val input = GregorianCalendar(2022,1,1,0,0,0)
        val actual = BerlinClockConverter.convertToBerlinClock(input)

        assertEquals(true, actual)
    }

    @Test
    fun `returns false when seconds are odd`() {
        val input = GregorianCalendar(2022,1,1,0,0,1)
        val actual = BerlinClockConverter.convertToBerlinClock(input)

        assertEquals(false, actual)
    }
}