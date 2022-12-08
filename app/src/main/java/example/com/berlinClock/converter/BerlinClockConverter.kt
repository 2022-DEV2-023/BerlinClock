package example.com.berlinClock.converter

import example.com.berlinClock.models.BerlinClockValues
import java.util.*


class BerlinClockConverter {
    companion object {
        fun convertToBerlinClock(date: GregorianCalendar): BerlinClockValues {
            val seconds = date.get(Calendar.SECOND)
            val hours = date.get(Calendar.HOUR_OF_DAY)
            val minutes = date.get(Calendar.MINUTE)

            return BerlinClockValues(
                secondsIndicatorOn = seconds % 2 == 0,
                hoursFirstRowCount = hours.floorDiv(5),
                hoursSecondRowCount = hours % 5,
                minutesFirstRowCount = minutes.floorDiv(5),
                minutesSecondRowCount = 0
            )
        }
    }
}