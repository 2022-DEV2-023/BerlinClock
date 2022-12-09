package example.com.berlinClock.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import example.com.berlinClock.converter.BerlinClockConverter
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import java.util.*

class BerlinClockViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: BerlinClockViewModel

    @Test
    fun `Clock is initialized correctly`() {
        val date = GregorianCalendar(2022, 12, 9, 11, 11, 11)
        viewModel = BerlinClockViewModel(date)

        val value = viewModel.uiState.value
        val expectedBerlinTime = BerlinClockConverter.convertToBerlinClock(date)

        assertEquals(expectedBerlinTime, value)
    }
}