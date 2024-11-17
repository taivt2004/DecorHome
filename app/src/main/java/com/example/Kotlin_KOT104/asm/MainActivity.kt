package com.example.Kotlin_KOT104.asm


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.Kotlin_KOT104.lab4.funRandom_O
import com.example.Kotlin_KOT104.lab5.funList
import com.example.Kotlin_KOT104.lab6.funPikachu
import com.example.Kotlin_KOT104.testapi.funMainAPI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          Main()
        }
    }
}


@Preview
@Composable
fun Main() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "funManHinhChao" ) {
        composable("funManHinhChao") { funManHinhChao (navController) }
        composable("funDangNhap") { funDangNhap(navController)}
        composable("funDangKi") { funDangKi(navController)}
        composable("funChuc_mung") { funChuc_mung(navController)}
        composable("funRandom_O") { funRandom_O(navController)}
        composable("funList") { funList(navController) }
        composable("funPikachu") { funPikachu(navController) }
        composable("funScreens") { funScreens(navController) }
        composable("Home") { Home(navController) }
        composable("funMainAPI") { funMainAPI(navController) }
        composable("funThanhToan") { funThanhToan(navController) }
        composable("funCart"){ funCart(navController) }



        composable(
                "funChiTietSanPham/{productId}"
                , arguments = listOf(
                    navArgument("productId") {type = NavType.StringType })
                    ){ navBackStackEntry -> funChiTietSanPham(
                navController,
                productId = navBackStackEntry.arguments?.getString("productId").toString())}



    }

}


