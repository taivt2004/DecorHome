package com.example.Kotlin_KOT104.asm


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lab1_ps36752.R



@Composable
fun funChuc_mung(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
    ) {

        Column(
            modifier = Modifier
                .padding(bottom = 140.dp)
                .fillMaxSize()
                .align(Alignment.Center), // Căn giữa toàn bộ phần văn bản trong màn hình
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally // Căn giữa nội dung theo trục ngang
        ) {
            Text(
                text = "SUCCESS!",
                color = Color.Black,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 10.sp,
                letterSpacing = 3.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(top = 50.dp)
            )


            Column(modifier = Modifier
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.notifi),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(20.dp)
                        .width(290.dp)
                        .shadow(10.dp)
                        .height(260.dp),
                    contentScale = ContentScale.Crop
                )

                Image(
                    painter = painterResource(id = R.drawable.checkmark),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(20.dp)
                        .width(50.dp)
                        .height(50.dp)
                )
            }


            Text(
                text = "Your order will be delivered soon.\n" +
                        "Thank you for choosing our app!",
                //color = Color.Gray,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                //lineHeight = 35.sp,
                textAlign = TextAlign.Justify,
            )

            // Nút
            val context = LocalContext.current
            Button(
                onClick = {
                  navController.navigate("funRandom_O")
                },
                modifier = Modifier
                    .padding(top = 50.dp)
                    .width(315.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor  = Color(0xF21D1C1C)
                ),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = "Track your orders",
                    color = Color.White,
                    fontFamily = FontFamily.Serif,
                    fontSize = 18.sp,
                )
            }

            OutlinedButton(
                onClick = {
                    navController.navigate("funDangNhap")
                },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(315.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor  = Color(0xF2FFFFFF)
                ),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = "BACK TO HOME",
                    color = Color.Black,
                    fontFamily = FontFamily.Serif,
                    fontSize = 18.sp,
                )
            }

        }
    }
}