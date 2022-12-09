package example.com.berlinClock.converter

import example.com.berlinClock.models.BerlinClockValues
import java.util.*


class BerlinClockConverter {
    companion object {
        fun convertToBerlinClock(date: GregorianCalendar = GregorianCalendar()): BerlinClockValues {
            val seconds = date.get(Calendar.SECOND)
            val hours = date.get(Calendar.HOUR_OF_DAY)
            val minutes = date.get(Calendar.MINUTE)

            return BerlinClockValues(
                secondsIndicatorOn = seconds % 2 == 0,
                hoursFirstRowCount = hours.floorDiv(5),
                hoursSecondRowCount = hours % 5,
                minutesFirstRowCount = minutes.floorDiv(5),
                minutesSecondRowCount = minutes % 5,
                time = "${formattedString(hours)}:${formattedString(minutes)}"
            )

        }

        private fun formattedString(s: Int) = if (s <= 9) {
            "0$s"
        } else {
            "$s"
        }
    }
}