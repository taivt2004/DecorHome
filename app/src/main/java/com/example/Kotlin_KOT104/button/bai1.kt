package com.example.Kotlin_KOT104.button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.floor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApp()
        }
    }
}

@Preview
@Composable
fun MyComposeApp() {
    // Hàm random toán tử
    fun randomOperator(): String {
        val operators = listOf("+", "-", "*", "/")
        return operators.random()
    }
    // Random số và kết quả
    var so1 by remember { mutableStateOf(floor((Math.random() * 10 + 1)).toString()) }
    var so2 by remember { mutableStateOf(floor((Math.random() * 10 + 1)).toString()) }
    var result by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var operator by remember { mutableStateOf(randomOperator()) }

    // Hàm tính toán kết quả dựa trên toán tử
    fun calculateResult(): Double  {
        val a = so1.toDouble()
        val b = so2.toDouble()
        return when (operator) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> if (b != 0.0) a / b else 0.0 // Xử lý chia cho 0
            else -> 0.0
        }
    }



    // Khởi tạo giá trị kết quả ngẫu nhiên
    result = if (Math.random() > 0.5) {
        // Đôi khi đúng, đôi khi sai
        calculateResult().toString()
    } else {
        floor((Math.random() * 20 + 1)).toString() // Random kết quả sai
    }

    // Hàm xử lý kiểm tra kết quả
    fun xuly(isCorrect: Boolean) {
        val a = so1.toDoubleOrNull()
        val b = so2.toDoubleOrNull()
        val res = result.toDoubleOrNull()

        if (a == null || b == null || res == null) {
            message = "Giá trị nhập không hợp lệ!"
            return
        }

        val correctResult = calculateResult()

        if (isCorrect) {
            if (correctResult == res) {
                message = "Chính xác! Kết quả của $so1 $operator $so2 là $correctResult"
                // Random lại khi đúng
                so1 = floor((Math.random() * 10 + 1)).toString()
                so2 = floor((Math.random() * 10 + 1)).toString()
                operator = randomOperator()
                result = if (Math.random() > 0.5) {
                    calculateResult().toString() // Đôi khi đúng
                } else {
                    floor((Math.random() * 20 + 1)).toString() // Random kết quả sai
                }
            } else {
                message = "Sai rồi! Kết quả đúng là $correctResult"
            }
        } else {
            if (correctResult != res) {
                message = "Chính xác! Kết quả không phải là $result"
                // Random lại khi đúng
                so1 = floor((Math.random() * 10 + 1)).toString()
                so2 = floor((Math.random() * 10 + 1)).toString()
                operator = randomOperator()
                result = if (Math.random() > 0.5) {
                    calculateResult().toString() // Đôi khi đúng
                } else {
                    floor((Math.random() * 20 + 1)).toString() // Random kết quả sai
                }
            } else {
                message = "Sai rồi! Kết quả đúng là $correctResult"
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Cyan)
            .padding(16.dp)
    ) {
        Text(text = "Phép toán: $so1 $operator $so2 = $result", modifier = Modifier.padding(bottom = 16.dp))

        // Nút "Đúng"
        Button(
            onClick = { xuly(true) },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text(text = "Đúng")
        }

        // Nút "Sai"
        Button(
            onClick = { xuly(false) }
        ) {
            Text(text = "Sai")
        }

        // Hiển thị thông báo kết quả
        Text(text = message, modifier = Modifier.padding(top = 16.dp))
    }
}