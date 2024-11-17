package com.example.Kotlin_KOT104.lab7.Lab7

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

class Lab7 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainLab7()
        }

    }
}


@Preview
@Composable
fun MainLab7() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "funLogin1" ) {
        composable("funLogin1") { funLogin1 (navController) }
        composable("funLogin2") { funLogin2(navController) }
        composable("funLogin3") { funLogin3(navController) }
        composable("funLogin4") { funLogin4(navController) }
        composable("funHome") { funHome(navController) }
        composable("funList") { funList(navController) }
        composable("funPikachu") { funPikachu(navController) }
        composable("funScreens") { funScreens(navController) }
       // composable("Home") { Home(navController) }
    }

}


