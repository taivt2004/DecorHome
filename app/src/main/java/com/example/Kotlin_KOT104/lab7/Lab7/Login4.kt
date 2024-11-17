package com.example.kotlin.Lab7

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun funLogin4(navController: NavController) {
    var password by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(
            text = "Delivery of",
            fontSize = 49.sp,
            color = Color(0xFF45BC1B),
            modifier = Modifier.padding(top = 100.dp).align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "products",
            fontSize = 49.sp,
            color = Color(0xFF45BC1B),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Let's get acquainted!",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 30.dp)
                .align(Alignment.CenterHorizontally),
            fontWeight = FontWeight(700)
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { "Enter phone number" },
            modifier = Modifier.padding(top = 32.dp).fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { "Enter phone number" },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),

            )
        Button(
            onClick = {

                navController.navigate("funHome")

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF45BC1B),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .height(54.dp)
        ) {
            Text(text = "Continue")
        }
        Text(
            text = "Skip this step",
            fontSize = 16.sp,
            color = Color(0xFF6AC949),
            modifier = Modifier
                .padding(top = 200.dp)
                .align(Alignment.CenterHorizontally),
            fontWeight = FontWeight(700),
        )
    }

}
