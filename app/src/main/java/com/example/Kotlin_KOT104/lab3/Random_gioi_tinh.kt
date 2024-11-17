package com.example.Kotlin_KOT104.lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1_ps36752.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Random_gioi_tinh()
        }
    }
}

@Preview
@Composable
fun Random_gioi_tinh() {
    // State để lưu trữ số lần nhấn cho từng lựa chọn
    var singleVotes by remember { mutableStateOf(0) }
    var takenVotes by remember { mutableStateOf(0) }
    var lgbtVotes by remember { mutableStateOf(0) }

    // Tính tổng số lần nhấn
    val totalVotes = singleVotes + takenVotes + lgbtVotes

    // Tính phần trăm cho mỗi lựa chọn
    val singlePercentage = if (totalVotes > 0) (singleVotes.toFloat() / totalVotes) * 100 else 0f
    val takenPercentage = if (totalVotes > 0) (takenVotes.toFloat() / totalVotes) * 100 else 0f
    val lgbtPercentage = if (totalVotes > 0) (lgbtVotes.toFloat() / totalVotes) * 100 else 0f

    // Style cho phần trăm
    val percentageTextStyle = androidx.compose.ui.text.TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            // Hình ảnh
            Image(
                painter = painterResource(id = R.drawable.a7),
                contentDescription = "Hình ảnh",
                modifier = Modifier
                    .width(150.dp)
                    .height(200.dp)
            )

            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = "ĐỘC THÂN: ${singlePercentage.toInt()}%", color = Color.Green, style = percentageTextStyle)
                Text(text = "ĐÃ CÓ CHỦ: ${takenPercentage.toInt()}%", color = Color.Red, style = percentageTextStyle)
                Text(text = "LGBT: ${lgbtPercentage.toInt()}%", color = Color.Magenta, style = percentageTextStyle)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                singleVotes++
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "ĐỘC THÂN")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                takenVotes++
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "ĐÃ CÓ CHỦ")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                lgbtVotes++
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "LGBT")
        }
    }
}


