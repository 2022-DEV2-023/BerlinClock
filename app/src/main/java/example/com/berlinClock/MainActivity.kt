package example.com.berlinClock

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import example.com.berlinClock.ui.theme.BerlinClockTheme
import example.com.berlinClock.viewmodel.BerlinClockViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val displayMetrics = DisplayMetrics()

        @Suppress("DEPRECATION")
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        val width = displayMetrics.widthPixels / displayMetrics.density

        setContent {
            BerlinClockTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BerlinClock(
                        width = width
                    )
                }
            }
        }
    }
}

@Composable
fun BerlinClock(
    width: Float,
    viewModel: BerlinClockViewModel = viewModel(),
) {
    viewModel.startClock()
    val uiState by viewModel.uiState.collectAsState()
    val defaultModifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)

    val longRectangleWidth = width / 5
    val shortRectangleWidth = width / 14
    val rectangleHeight = 50.0f

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = defaultModifier,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = defaultModifier,
        ) {
            Circle(
                color = if (uiState.secondsIndicatorOn) {
                    Color.Red
                } else {
                    Color.White
                }
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = defaultModifier,
        ) {
            for (i in 1..uiState.hoursFirstRowCount) {
                Rectangle(
                    width = longRectangleWidth,
                    height = rectangleHeight,
                    color = Color.Red
                )
            }
            for (i in (uiState.hoursFirstRowCount + 1)..4) {
                Rectangle(
                    width = longRectangleWidth,
                    height = rectangleHeight,
                    color = Color.White
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = defaultModifier,
        ) {
            for (i in 1..uiState.hoursSecondRowCount) {
                Rectangle(
                    width = longRectangleWidth,
                    height = rectangleHeight,
                    color = Color.Red
                )
            }
            for (i in (uiState.hoursSecondRowCount + 1)..4) {
                Rectangle(
                    width = longRectangleWidth,
                    height = rectangleHeight,
                    color = Color.White
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = defaultModifier,
        ) {
            for (i in 1..uiState.minutesFirstRowCount) {
                Rectangle(
                    width = shortRectangleWidth,
                    height = rectangleHeight,
                    color = if (i % 3 == 0) {
                        Color.Yellow
                    } else {
                        Color.Red
                    }
                )
            }

            for (i in (uiState.minutesFirstRowCount + 1)..11) {
                Rectangle(
                    width = shortRectangleWidth,
                    height = rectangleHeight,
                    color = Color.White,
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = defaultModifier,
        ) {
            for (i in 1..uiState.minutesSecondRowCount) {
                Rectangle(
                    width = longRectangleWidth,
                    height = rectangleHeight,
                    color = Color.Red,
                )
            }
            for (i in (uiState.minutesSecondRowCount + 1)..4) {
                Rectangle(
                    width = longRectangleWidth,
                    height = rectangleHeight,
                    color = Color.White,
                )
            }
        }
    }
}

@Composable
fun Rectangle(width: Float, height: Float, color: Color) {
    Box(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
            .background(color)
    )
}

@Composable
fun Circle(color: Color) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Black, CircleShape)
            .background(color)
    )
}
