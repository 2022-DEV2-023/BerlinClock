package example.com.berlinClock.viewmodel

import androidx.lifecycle.ViewModel
import example.com.berlinClock.converter.BerlinClockConverter
import example.com.berlinClock.models.BerlinClockValues
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.*


class BerlinClockViewModel(date: GregorianCalendar = GregorianCalendar()) : ViewModel() {
    private val _uiState =
        MutableStateFlow(BerlinClockConverter.convertToBerlinClock(date))
    val uiState: StateFlow<BerlinClockValues> = _uiState.asStateFlow()

}