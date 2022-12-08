package example.com.berlinClock.converter

import java.util.*


class BerlinClockConverter {
    companion object {
        fun convertToBerlinClock(date: GregorianCalendar): Boolean {
            val seconds = date.get(Calendar.SECOND)
            return seconds % 2 == 0
        }
    }
}