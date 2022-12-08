package example.com.berlinClock.models


data class BerlinClockValues(
    val secondsIndicatorOn: Boolean,
    val hoursFirstRowCount: Int,
    val hoursSecondRowCount: Int,
    val minutesFirstRowCount: Int,
    val minutesSecondRowCount: Int
)