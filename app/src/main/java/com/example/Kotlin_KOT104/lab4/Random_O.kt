package com.example.Kotlin_KOT104.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlin.random.Random


@Composable
fun funRandom_O(navController: NavHostController) {
    var randomValues by remember { mutableStateOf(generateRandomProblem()) }
    var hiddenIndex by remember { mutableStateOf(Random.nextInt(3)) }
    var userInput by remember { mutableStateOf(TextFieldValue("")) }
    var isCorrect by remember { mutableStateOf(false) }
    var showResult by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            for (i in 0..2) {
                if (i == hiddenIndex) {
                    BasicTextField(
                        value = userInput,
                        onValueChange = { userInput = it },
                        modifier = Modifier
                            .width(60.dp)
                            .height(60.dp)
                            .background(Color.Gray)
                            .padding(8.dp)
                    )
                } else {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .width(60.dp)
                            .height(60.dp)
                            .background(Color.Gray)
                            .padding(8.dp)
                    ) {
                        Text(text = randomValues[i])
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
            }

            Text("=")
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .background(Color.Gray)
                    .padding(8.dp)
            ) {
                Text(text = randomValues[3])
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val inputValue = userInput.text
            isCorrect = inputValue == randomValues[hiddenIndex]
            showResult = true

            if (isCorrect) {
                randomValues = generateRandomProblem()
                hiddenIndex = Random.nextInt(3)
                userInput = TextFieldValue("")
                showResult = false
            }

        }) {
            Text("Kiểm tra")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (showResult) {
            if (isCorrect) {
                Text("Chính xác! Đã chuyển sang bài tiếp theo.")
            } else {
                Text("Sai rồi! Hãy thử lại.")
            }
        }
    }
}

// Hàm sinh phép toán ngẫu nhiên
fun generateRandomProblem(): List<String> {
    val operand1 = Random.nextInt(1, 20)
    val operand2 = Random.nextInt(1, 20)
    val operator = listOf("+", "-", "*").random()

    // Tính toán kết quả dựa trên toán tử
    val result = when (operator) {
        "+" -> operand1 + operand2
        "-" -> operand1 - operand2
        "*" -> operand1 * operand2
        else -> 0
    }

    return listOf(operand1.toString(), operator, operand2.toString(), result.toString())
}