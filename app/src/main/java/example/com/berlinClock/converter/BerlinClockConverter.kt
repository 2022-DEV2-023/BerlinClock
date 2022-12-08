package example.com.berlinClock.converter

import example.com.berlinClock.models.BerlinClockValues
import java.util.*


class BerlinClockConverter {
    companion object {
        fun convertToBerlinClock(date: GregorianCalendar): BerlinClockValues {
            val seconds = date.get(Calendar.SECOND)
            val hours = date.get(Calendar.HOUR_OF_DAY)

            return BerlinClockValues(
                secondsIndicatorOn = seconds % 2 == 0,
                hoursFirstRowCount = hours.floorDiv(5)
            )
        }
    }
}