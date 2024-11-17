package com.example.Kotlin_KOT104.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class TestRemember : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {funRemember()  }
    }


}

@Preview
@Composable
fun funRemember() {

    var so1 by remember {
        mutableStateOf("")
    }

    var so2 by remember{
        mutableStateOf("")
    }

    var sum by remember {
        mutableStateOf(0)
    }

    fun Xuly() {
        sum = so1.toInt() + so2.toInt();
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xF2DDC4B7))
    ) {
        TextField(value = so1, onValueChange = {so1 = it}, label = { Text(text = "So 1", color = Color.White)},
            colors = OutlinedTextFieldDefaults.colors( unfocusedContainerColor = Color(0xF24D4541)),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            )


        TextField(value = so2, onValueChange = {so2 = it}, label = { Text(text = "So 2",color = Color.White)},
            colors = OutlinedTextFieldDefaults.colors( unfocusedContainerColor = Color(0xF24D4541)),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .padding(bottom = 20.dp))

        OutlinedButton(onClick = { Xuly() }, modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .padding(10.dp)) {
            Text(text = "Xac Nhan", color = Color.White)
        }
        Text(text = sum.toString())

    }
}