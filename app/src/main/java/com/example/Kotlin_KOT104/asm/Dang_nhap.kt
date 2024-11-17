package com.example.Kotlin_KOT104.asm

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.Kotlin_KOT104.testapi.LoginReq
import com.example.Kotlin_KOT104.testapi.RegisterReq
import com.example.Kotlin_KOT104.testapi.ViewModelApp
import com.example.lab1_ps36752.R

//@Preview
@Composable
fun funDangNhap(navController: NavHostController,viewmodel: ViewModelApp = viewModel()) {
    val loginResponse by viewmodel.loginMessage

    var emailLogin by remember { mutableStateOf("") }  // Trạng thái cho email
    var passwordLogin by remember { mutableStateOf("") }  // Trạng thái cho password
    var errorMessage by remember { mutableStateOf("") }  // Trạng thái cho thông báo lỗi
    var passwordVisible by remember { mutableStateOf(false) } // Trạng thái xem mật khẩu có hiển thị hay không

    val context = LocalContext.current

    // Hàm kiểm tra và thực hiện đăng nhập
    fun checkLogin() {
        if (emailLogin.isBlank() || passwordLogin.isBlank()) {
            errorMessage = "Email và mật khẩu không được để trống."
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailLogin).matches()) {
            errorMessage = "Email không hợp lệ."
        } else {
            errorMessage = ""
            val loginReq = LoginReq(emailLogin, passwordLogin)
            viewmodel.login(loginReq)
        }
    }

// Lắng nghe phản hồi API
    LaunchedEffect(loginResponse) {
        val currentMessage = loginResponse // Tạo biến trung gian

        if (currentMessage != null && currentMessage.status) {
            Toast.makeText(context, currentMessage.message, Toast.LENGTH_SHORT).show()
            navController.navigate("Home")
        } else if (currentMessage != null && !currentMessage.status) {
            Toast.makeText(context, currentMessage.message, Toast.LENGTH_SHORT).show()
        }
    }
        Box(modifier = Modifier
            .background(Color.White)
            .fillMaxSize()){

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(Alignment.TopCenter)) {

                //logo
                Row(
                    modifier = Modifier
                        .wrapContentWidth(),
                    verticalAlignment = Alignment.CenterVertically

                    ) {
                    Divider(
                        color = Color.Gray, // Màu của đường kẻ
                        thickness = 2.dp,   // Độ dày của đường kẻ
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .width(125.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(10.dp)
                            .width(63.963.dp)
                            .height(63.963.dp),
                        contentScale = ContentScale.Crop)

                    Divider(
                        color = Color.Gray, // Màu của đường kẻ
                        thickness = 2.dp,   // Độ dày của đường kẻ
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .width(125.dp)
                    )
                }


                //Text xin chào
                Column(
                    Modifier
                        .padding(30.dp)
                        .fillMaxWidth())
                   {

                    Text(
                        text = "Hello !",
                        color = Color.Gray,
                        fontSize = 24.sp,
                        lineHeight = 10.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Normal
                    )
                    Row{
                        Text(
                            text = "WELCOME BACK",
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 10.sp,
                            fontFamily = FontFamily.Serif,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }

                }


                //Textinput va button

                Box(
                    modifier = Modifier
                        .shadow(10.dp)
                        .background(Color.White) // Đặt màu nền bên trong là màu trắng để dễ thấy bóng đổ
                        .align(Alignment.Start)
                        .width(345.dp)
                        .height(500.dp)

                ) {

                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {

                        Column (
                            modifier = Modifier
                        ){
                            TextField(
                                value = emailLogin, onValueChange = {emailLogin = it},
                                label = { Text(text = "Email", Modifier.padding (bottom = 30.dp, end = 10.dp))},
                                colors = OutlinedTextFieldDefaults.colors( unfocusedContainerColor = Color.White, focusedContainerColor = Color.White ),
                                textStyle = TextStyle(color = Color.Black),  // Đặt màu chữ là màu đen
                                modifier = Modifier
                                    .padding(top = 10.dp, start = 10.dp)
                                    .fillMaxWidth()
                                    .padding(bottom = 20.dp)
                            )
                            TextField(
                                value = passwordLogin, onValueChange = {passwordLogin = it},
                                label = { Text(text = "Password", Modifier.padding (bottom = 30.dp, end = 10.dp))},
                                colors = OutlinedTextFieldDefaults.colors( unfocusedContainerColor = Color.White, focusedContainerColor = Color.White ),
                                textStyle = TextStyle(color = Color.Black),  // Đặt màu chữ là màu đen
                                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(), // Hiện/ẩn mật khẩu
                                trailingIcon = {
                                    IconButton(onClick = {
                                        passwordVisible = !passwordVisible // Đổi trạng thái hiển thị mật khẩu
                                    }) {
                                        Icon(
                                            painter = painterResource(id = if (passwordVisible) R.drawable.showicon else R.drawable.hiddenicon),
                                            contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                            modifier = Modifier
                                                .size(25.dp)
                                        )
                                    }
                                },
                                modifier = Modifier
                                    .padding(top = 10.dp, start = 10.dp)
                                    .fillMaxWidth()
                            )

                            Text(
                                text = "Forgot Password",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(top = 50.dp)
                                    .align(Alignment.CenterHorizontally)
                            )

                            Spacer(modifier = Modifier.height(20.dp))
                        }


                        // Log in Button
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .shadow(4.dp, shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                                .background(Color.Black)
                                .height(50.dp),
                            contentAlignment = Alignment.Center
                        ) {

                            Button(
                                onClick = {
                                          checkLogin()
                                    // Gọi ViewModel để thực hiện đăng nhập

                                },
                                modifier = Modifier
                                    .width(300.dp)
                                    .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp)) // Bo viền đen
                                    .height(54.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor  = Color(0xF21D1C1C)
                                ),
                                shape = RoundedCornerShape(8.dp)
                            ){
                                Text(
                                    text = "Log in",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Sign up Link

                        val context = LocalContext.current

                        Button(
                            onClick = {
                               navController.navigate("funDangKi")
                            },
                            modifier = Modifier
                                .width(300.dp)
                            .height(54.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor  = Color.White
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = "SIGN UP",
                                color = Color.Black,
                                fontSize = 20.sp,
                            )
                        }
                    }

                    }
                }
            }
}


