package com.example.Kotlin_KOT104.THI

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.Kotlin_KOT104.testapi.RegisterReq
import com.example.lab1_ps36752.R

@Composable
fun funLogin(navController: NavController){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current

    fun checkLogin() {
        if (email.isBlank()) {
            Toast.makeText(context, "Tên không được để trống", Toast.LENGTH_SHORT).show()
        } else if (password.isBlank()) {
            Toast.makeText(context, "Mật khẩu không được để trống", Toast.LENGTH_SHORT).show()
        }else if(password.length >= 8){
            Toast.makeText(context, "Mật khẩu phải lớn hơn 8 kí tự", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
            navController.navigate("funProduct")
        }

    }
    Box(modifier = Modifier
        .padding(10.dp)
        .fillMaxSize()
        .background(Color.White) ) {
        
        Column(modifier = Modifier.fillMaxSize()) {
            Image(painter = painterResource(R.drawable.baseline_arrow_back_24) , contentDescription = ""
                , modifier = Modifier.padding(bottom = 80.dp, top = 20.dp)
            )

            Column(
                Modifier
                    .padding(5.dp)
                    .fillMaxWidth())
            {

                Text(
                    text = "Welcome back to",
                    fontSize = 24.sp,
                    lineHeight = 10.sp,
                    fontWeight = FontWeight.Bold,
                )
                Row{
                    Text(
                        text = "Mega Mall",
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 10.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                }


                Text(
                    text = "Silahkan masukan data untuk login",
                    color = Color.Black,
                    fontSize = 17.sp,
                    lineHeight = 10.sp,
                    modifier = Modifier.padding(top = 40.dp)
                )

            }

            Column(modifier = Modifier
                .padding(5.dp)
            ) {
                Text(text = "Email/Phone",modifier = Modifier.padding(bottom = 10.dp))
                //search
                TextField(
                    value = email,
                    onValueChange = { abc -> email = abc.uppercase() },
                    placeholder = { Text(text = "") },
                    modifier = Modifier
                        .width(360.dp)
                        .height(60.dp),


                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xF2A2A3A2),
                        unfocusedContainerColor = Color(0xF2A2A3A2),
                        focusedIndicatorColor = Color(0x008FD776),/// trong suot
                        unfocusedIndicatorColor = Color(0x008FD776),/// trong suot
                    ),
                    shape = RoundedCornerShape(10.dp),
                )

                Text(text = "Password", modifier = Modifier.padding(bottom = 10.dp, top = 30.dp))
                //search
                TextField(
                    value = password,
                    onValueChange = {  password = it },
                    placeholder = { Text(text = "") },
                    modifier = Modifier
                        .width(360.dp)
                        .height(60.dp),


                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xF2A2A3A2),
                        unfocusedContainerColor = Color(0xF2A2A3A2),
                        focusedIndicatorColor = Color(0x008FD776),/// trong suot
                        unfocusedIndicatorColor = Color(0x008FD776),/// trong suot
                    ),
                    shape = RoundedCornerShape(10.dp),
                )
            }




        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter) // Căn nút ở phía dưới màn hình
                .padding(bottom = 150.dp), // Tùy chỉnh khoảng cách từ nút đến đáy màn hình
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    checkLogin()
                },
                modifier = Modifier
                    .width(360.dp)
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor  = Color(0xF2054277)
                ),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(
                    text = "Sign In",
                    color = Color.White,
                    fontSize = 18.sp,
                )
            }
        }

        Text(
            text = "Forgot password",
            color = Color.Black,
            fontSize = 17.sp,
            modifier = Modifier.padding(top = 800.dp, start = 15.dp)
        )
        Text(
            text = "Sign Up",
            color = Color.Black,
            fontSize = 17.sp,
            modifier = Modifier.padding(top = 800.dp, start = 300.dp)
        )

    }



}