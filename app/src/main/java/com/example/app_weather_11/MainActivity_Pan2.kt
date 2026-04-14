package com.example.app_weather_11.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherScreen()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WeatherScreen() {
    val backGroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFA0B5EB),
            Color(0xFFEA52F8),
            Color(0xFF0066FF)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = backGroundGradient)
            .padding(15.dp)
    ) {
        Column {
            Text(
                text = "El Salvador",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold

            )

            Text(
                text = "25°C",
                color = Color.White,
                fontSize = 75.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Soleado",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "PRONOSTICO POR HORAS",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 12.sp,
            )

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                PronosticoHoras(hora = "Ahora", emoji = "☀️", temp = "28°")
                PronosticoHoras(hora = "14:00", emoji = "☀️", temp = "26°")
                PronosticoHoras(hora = "16:00", emoji = "⛅", temp = "24°")
                PronosticoHoras(hora = "18:00", emoji = "⛅", temp = "22°")
                PronosticoHoras(hora = "20:00", emoji = "🌙", temp = "20°")

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color.White.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(16.dp)),
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    Text(
                        text = "DETALLES",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 20.sp
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Detalles(title = "Humedad", value = "65%")
                        Detalles(title = "Viento", value = "12 km/h")
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Detalles(title = "Presion", value = "1012 hPa")
                        Detalles(title = "UV", value = "5")

                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "PRONOSTICO SEMANAL",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 20.sp
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color.White.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(16.dp)),
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PronosticoSemana(dia = "Lun", emoji = "☀️", temp = "28°","22°")
                    PronosticoSemana(dia = "Mar", emoji = "⛅", temp = "27°", "21°")
                    PronosticoSemana(dia = "Mie", emoji = "🌧️", temp = "26°", "20°")
                    PronosticoSemana(dia = "Jue", emoji = "⛅", temp = "25°", "19°")
                    PronosticoSemana(dia = "Vie", emoji = "🌦️", temp = "24°", "18°")
                }
            }

        }
    }

}

@Composable
fun PronosticoHoras(hora: String, emoji: String, temp: String)
{
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = hora,
            color = Color.White,
            fontSize = 20.sp,
        )
        Text(
            text = emoji,
            fontSize = 20.sp,
        )
        Text(
            text = temp,
            color = Color.White,
            fontSize = 20.sp,
        )
    }
}

@Composable
fun Detalles(title: String, value: String)
{
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 20.sp,
        )
        Text(
            text = value,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun PronosticoSemana(dia: String, emoji: String, temp: String, contra: String)
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = dia,
            color = Color.White,
            fontSize = 20.sp,
        )
        Text(
            text = emoji,
            fontSize = 20.sp,
        )
        Row {
            Text(
                text = temp,
                color = Color.White,
                fontSize = 20.sp,
            )
            Text(
                text = "/",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 20.sp,
            )
            Text(
                text = contra,
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 20.sp,
            )
        }
    }
}