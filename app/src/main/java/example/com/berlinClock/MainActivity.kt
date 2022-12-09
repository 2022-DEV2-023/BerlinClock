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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import example.com.berlinClock.ui.theme.BerlinClockTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val defaultModifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)

        val displayMetrics = DisplayMetrics()

        @Suppress("DEPRECATION")
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        val width = displayMetrics.widthPixels / displayMetrics.density
        val longRectangleWidth = width / 5
        val shortRectangleWidth = width / 14
        val rectangleHeight = 50.0f

        setContent {
            BerlinClockTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = defaultModifier,
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = defaultModifier,
                        ) {
                            Circle()
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = defaultModifier,
                        ) {
                            for (i in 1..4) {
                                Rectangle(
                                    width = longRectangleWidth,
                                    height = rectangleHeight,
                                )
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = defaultModifier,
                        ) {
                            for (i in 1..4) {
                                Rectangle(
                                    width = longRectangleWidth,
                                    height = rectangleHeight
                                )
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = defaultModifier,
                        ) {
                            for (i in 1..11) {
                                Rectangle(
                                    width = shortRectangleWidth,
                                    height = rectangleHeight
                                )
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = defaultModifier,
                        ) {
                            for (i in 1..4) {
                                Rectangle(
                                    width = longRectangleWidth,
                                    height = rectangleHeight,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Rectangle(width: Float, height: Float) {
    Box(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
            .background(Color.Red)
    )
}

@Composable
@Preview(showBackground = true)
fun Circle() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Black, CircleShape)
            .background(Color.Red)
    )
}
