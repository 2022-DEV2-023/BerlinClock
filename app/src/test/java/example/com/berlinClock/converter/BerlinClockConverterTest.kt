package example.com.berlinClock.converter

import org.junit.Assert.assertEquals
import org.junit.Test

class BerlinClockConverterTest {

    @Test
    fun `returns true when seconds are even`() {
        val actual = BerlinClockConverter.convertToBerlinClock();

        assertEquals(true, actual)
    }
}