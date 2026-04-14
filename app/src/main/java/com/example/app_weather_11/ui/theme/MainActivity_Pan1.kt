import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
@Preview
fun MainScreen() {
    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF72EAFF),
            Color(0xFF72C2FF),
            Color(0xFF003888)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = backgroundGradient)
            .padding(vertical = 150.dp, horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "El Salvador",
                color = Color.White,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "25°C",
                color = Color.White,
                fontSize = 100.sp,
                fontWeight = FontWeight.Bold
            )


            Text(
                text = "😎",
                fontSize = 50.sp,
                    )

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color.White.copy(alpha = 0.2f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    Arrangement.SpaceBetween
                ) {
                    Info(title = "HUM", value = "65%")
                    Info(title = "VIENTO", value = "12 km/h")
                    Info(title = "LLUVIA", value = "10%")
                }
            }

            Button(
                onClick = {},
                modifier = Modifier.padding(top = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Blue
                )
            ) {
                Text(
                    text = "Actualizar",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun Info (title: String, value: String) {
    Column() {
        Text(title,
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 20.sp,
        )
        Text(
            value,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}