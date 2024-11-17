package com.example.Kotlin_KOT104.THI2

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun funDangKy(navController: NavController){

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repass by remember { mutableStateOf("") }

    val context = LocalContext.current


    fun checkLogin() {
        if (email.isBlank() || firstName.isBlank() || lastName.isBlank() || password.isBlank() || repass.isBlank()) {
            Toast.makeText(context, "Điền đầy đủ thông tin", Toast.LENGTH_SHORT).show()
        }else if(password.length <= 8){
            Toast.makeText(context, "Mật khẩu phải lớn hơn 8 kí tự", Toast.LENGTH_SHORT).show()
        }else if(password != repass){
            Toast.makeText(context, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
            navController.navigate("funProduct2")
        }
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xF22C9665)) ) {

        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {


            Image(painter = painterResource(R.drawable.baseline_arrow_back_24) , contentDescription = ""
                , modifier = Modifier.padding(bottom = 80.dp, top = 20.dp, end = 320.dp)
            )

            Column(
                Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            )

            {

                Text(
                    text = "Welcome to tradly",
                    fontSize = 24.sp,
                    lineHeight = 10.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                Row{
                    Text(
                        text = "Signup to your account",
                        color = Color.White,
                        fontSize = 18.sp,
                        lineHeight = 10.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                }
                

            }

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
            ) {
                //search
                TextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    placeholder = { Text(text = "First Name", color = Color.White) },

                    modifier = Modifier
                        .padding(10.dp)
                        .width(360.dp)
                        .height(50.dp)
                        .border(1.dp, Color.White, RoundedCornerShape(15.dp)), // Thêm border ở đây ,


                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xF22C9665),
                        unfocusedContainerColor = Color(0xF22C9665),
                        focusedIndicatorColor = Color(0xF22C9665),
                        unfocusedIndicatorColor = Color(0xF22C9665),
                    ),
                    shape = RoundedCornerShape(15.dp),
                )

                 //search
                TextField(
                    value = lastName,
                    onValueChange = {  lastName = it },
                    placeholder = { Text(text = "Last Name", color = Color.White) },
                    modifier = Modifier
                        .padding(10.dp)
                        .width(360.dp)
                        .height(50.dp)
                        .border(1.dp, Color.White, RoundedCornerShape(15.dp)), // Thêm border ở đây ,



                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xF22C9665),
                        unfocusedContainerColor = Color(0xF22C9665),
                        focusedIndicatorColor = Color(0xF22C9665),/// trong suot
                        unfocusedIndicatorColor = Color(0xF22C9665),/// trong suot
                    ),
                    shape = RoundedCornerShape(15.dp),
                )

                TextField(
                    value = email,
                    onValueChange = {  email = it },
                    placeholder = { Text(text = "Email ID/Phone Number", color = Color.White) },
                    modifier = Modifier
                        .padding(10.dp)
                        .width(360.dp)
                        .height(50.dp)
                        .border(1.dp, Color.White, RoundedCornerShape(10.dp)), // Thêm border ở đây ,



                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xF22C9665),
                        unfocusedContainerColor = Color(0xF22C9665),
                        focusedIndicatorColor = Color(0xF22C9665),/// trong suot
                        unfocusedIndicatorColor = Color(0xF22C9665),/// trong suot
                    ),
                    shape = RoundedCornerShape(10.dp),
                )

                TextField(
                    value = password,
                    onValueChange = {  password = it },
                    placeholder = { Text(text = "Password", color = Color.White) },
                    modifier = Modifier
                        .padding(10.dp)
                        .width(360.dp)
                        .height(50.dp)
                        .border(1.dp, Color.White, RoundedCornerShape(15.dp)), // Thêm border ở đây ,



                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xF22C9665),
                        unfocusedContainerColor = Color(0xF22C9665),
                        focusedIndicatorColor = Color(0xF22C9665),/// trong suot
                        unfocusedIndicatorColor = Color(0xF22C9665),/// trong suot
                    ),
                    shape = RoundedCornerShape(10.dp),
                )
                TextField(
                    value = repass,
                    onValueChange = {  repass = it },
                    placeholder = { Text(text = "Re-enter Password", color = Color.White) },
                    modifier = Modifier
                        .padding(10.dp)
                        .width(360.dp)
                        .height(50.dp)
                        .border(1.dp, Color.White, RoundedCornerShape(15.dp)), // Thêm border ở đây ,



                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xF22C9665),
                        unfocusedContainerColor = Color(0xF22C9665),
                        focusedIndicatorColor = Color(0xF22C9665),
                        unfocusedIndicatorColor = Color(0xF22C9665),
                    ),
                    shape = RoundedCornerShape(15.dp),
                )
            }




        }


        Row(
            modifier = Modifier
                .padding(20.dp)
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
                    containerColor  = Color.White
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "Sign In",
                    color = Color(0xF22C9665),
                    fontSize = 18.sp,
                )
            }

        }

        Row(modifier = Modifier
            .padding(20.dp)
            .align(Alignment.BottomCenter) // Căn nút ở phía dưới màn hình
            .padding(bottom = 120.dp)
        ) {
            Text(text = "Have a account ?", color = Color.White)
            Text(text = " Sign In", color = Color.White, fontWeight = FontWeight.Bold)
        }

    }



}