package com.example.Kotlin_KOT104.asm



import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.Kotlin_KOT104.lab4.funRandom_O
import com.example.Kotlin_KOT104.lab5.funList
import com.example.Kotlin_KOT104.lab6.funPikachu



@Composable
fun funScreens(navController: NavHostController) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)
    ) {
        Button(onClick = { navController.navigate("funList") }) {
            Text(text = "Lab 5")
        }

        Button(onClick = { navController.navigate("funPikachu") }) {
            Text(text = "Lab 6")
        }

        Button(onClick = { navController.navigate("funDangNhap") }) {
            Text(text = "ASM")
        }
    }
}
