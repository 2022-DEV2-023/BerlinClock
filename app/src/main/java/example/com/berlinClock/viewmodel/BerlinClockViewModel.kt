package example.com.berlinClock.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import example.com.berlinClock.converter.BerlinClockConverter
import example.com.berlinClock.models.BerlinClockValues
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.*


class BerlinClockViewModel(date: GregorianCalendar = GregorianCalendar()) : ViewModel() {
    private val _uiState =
        MutableStateFlow(BerlinClockConverter.convertToBerlinClock(date))
    val uiState: StateFlow<BerlinClockValues> = _uiState.asStateFlow()

    fun startClock() {
        Handler(Looper.getMainLooper()).also {
            it.post(object : Runnable {
                override fun run() {
                    _uiState.update {
                        BerlinClockConverter.convertToBerlinClock()
                    }
                    it.postDelayed(this, 1000)
                }
            })
        }
    }
}