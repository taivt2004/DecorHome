package com.example.Kotlin_KOT104.THI2


import com.example.Kotlin_KOT104.asm.Home
import com.example.Kotlin_KOT104.asm.funChuc_mung
import com.example.Kotlin_KOT104.asm.funDangKi
import com.example.Kotlin_KOT104.asm.funDangNhap
import com.example.Kotlin_KOT104.asm.funScreens
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.Kotlin_KOT104.lab4.funRandom_O
import com.example.Kotlin_KOT104.lab5.funList
import com.example.Kotlin_KOT104.lab6.funPikachu
import com.example.kotlin.Lab7.funLogin1
import com.example.kotlin.Lab7.funLogin2
import com.example.kotlin.Lab7.funLogin3
import com.example.kotlin.Lab7.funLogin4
import com.example.kotlin.funHome

class MainThi2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            funMainThi2()
        }

    }
}


@Preview
@Composable
fun funMainThi2() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "funDangKy" ) {
        composable("funDangKy") { funDangKy (navController) }
        composable("funProduct2") { funProduct2(navController) }

    }

}


