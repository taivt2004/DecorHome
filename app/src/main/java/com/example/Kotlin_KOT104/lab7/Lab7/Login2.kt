package com.example.kotlin.Lab7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun funLogin2(navController: NavController){
    var text1 by remember {
        mutableStateOf("")
    }
    var text2 by remember {
        mutableStateOf("")
    }
    var text3 by remember {
        mutableStateOf("")
    }
    var text4 by remember {
        mutableStateOf("")
    }
    val focusRequesters = List(4) { FocusRequester() }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(
            text = "Delivery of",
            fontSize = 49.sp,
            color = Color.Green,
            modifier = Modifier
                .padding(top = 100.dp)
                .align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "products",
            fontSize = 49.sp,
            color = Color.Green,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Authorization or registration",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 30.dp)
                .align(Alignment.CenterHorizontally),
            fontWeight = FontWeight(700)
        )
        Text(
            text = "We have sent a message to \nphone +7 999 123 45 67",
            fontSize = 16.sp,
            color = Color(0xFF6B6D7B),
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally),
        )
        //otp
        Row (
            modifier = Modifier
                .padding(top = 20.dp)
                .width(252.dp)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = text1,
                onValueChange = { value ->
                    if (value.length <= 1) {
                        text1 = value
                        // Chuyển đến ô tiếp theo nếu giá trị không rỗng và không phải ô cuối cùng
                        if (value.isNotEmpty()) {
                            // Dùng focusManager để di chuyển focus đến ô tiếp theo
                            focusRequesters[1].requestFocus()
                        }
                    }
                },
                colors = OutlinedTextFieldDefaults.colors( unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.Green,
                ),
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .padding(4.dp)
                    .focusRequester(focusRequesters[0]), // Gắn mỗi ô với FocusRequester tương ứng
                singleLine = true,
                textStyle = TextStyle(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )
            OutlinedTextField(
                value = text2,
                onValueChange = { value ->
                    if (value.length <= 1) {
                        text2 = value
                        // Chuyển đến ô tiếp theo nếu giá trị không rỗng và không phải ô cuối cùng
                        if (value.isNotEmpty()) {
                            // Dùng focusManager để di chuyển focus đến ô tiếp theo
                            focusRequesters[2].requestFocus()
                        }
                    }
                },
                colors = OutlinedTextFieldDefaults.colors( unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.Green,
                ),
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .padding(4.dp)
                    .focusRequester(focusRequesters[1]), // Gắn mỗi ô với FocusRequester tương ứng
                singleLine = true,
                textStyle = TextStyle(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )
            OutlinedTextField(
                value = text3,
                onValueChange = { value ->
                    if (value.length <= 1) {
                        text3 = value
                        // Chuyển đến ô tiếp theo nếu giá trị không rỗng và không phải ô cuối cùng
                        if (value.isNotEmpty()) {
                            // Dùng focusManager để di chuyển focus đến ô tiếp theo
                            focusRequesters[3].requestFocus()
                        }
                    }
                },
                colors = OutlinedTextFieldDefaults.colors( unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.Green,
                ),
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .padding(4.dp)
                    .focusRequester(focusRequesters[2]), // Gắn mỗi ô với FocusRequester tương ứng
                singleLine = true,
                textStyle = TextStyle(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )
            OutlinedTextField(
                value = text4,
                onValueChange = { value ->
                    if (value.length <= 1) {
                        text4 = value
                    }
                },
                colors = OutlinedTextFieldDefaults.colors( unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.Green,
                ),
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .padding(4.dp)
                    .focusRequester(focusRequesters[3]), // Gắn mỗi ô với FocusRequester tương ứng
                singleLine = true,
                textStyle = TextStyle(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )
        }

        Button(
            onClick = {navController.navigate("funLogin3")},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF45BC1B),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .height(54.dp)
        ) {
            Text(text = "Request code via 59")
        }
        Text(
            text = "By clicking on the \"Confirm Login\" button, I agree to the terms of use of the service",
            fontSize = 12.sp,
            color = Color(0xFF8F8F8F),
            modifier = Modifier
                .padding(top = 30.dp)
                .align(Alignment.CenterHorizontally)
        )
    }

}
