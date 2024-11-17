package com.example.Kotlin_KOT104.asm

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.Kotlin_KOT104.testapi.RegisterReq
import com.example.Kotlin_KOT104.testapi.RegisterRes
import com.example.Kotlin_KOT104.testapi.ViewModelApp
import com.example.lab1_ps36752.R


@Composable
fun funDangKi(navController: NavHostController, viewmodel: ViewModelApp = viewModel()) {

    val registerRes by viewmodel.message

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) } // Trạng thái xem mật khẩu có hiển thị hay không
    var passwordVisible2 by remember { mutableStateOf(false) } // Trạng thái xem mật khẩu có hiển thị hay không
    var rePassword by remember { mutableStateOf("") }

    val context = LocalContext.current
    // LaunchedEffect để lắng nghe message
    LaunchedEffect(registerRes) {
        val currentMessage = registerRes // Tạo biến trung gian

        if (currentMessage != null && currentMessage.status) {
            Toast.makeText(context, currentMessage.message, Toast.LENGTH_SHORT).show()
            navController.navigate("funDangNhap")
        } else if (currentMessage != null && !currentMessage.status) {
            Toast.makeText(context, currentMessage.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun checkLogin() {
        if (name.isBlank()) {
            Toast.makeText(context, "Tên không được để trống", Toast.LENGTH_SHORT).show()
            return
        }

        if (email.isBlank()) {
            Toast.makeText(context, "Email không được để trống", Toast.LENGTH_SHORT).show()
            return
        }

        if (password.isBlank()) {
            Toast.makeText(context, "Mật khẩu không được để trống", Toast.LENGTH_SHORT).show()
            return
        }

        if (rePassword.isBlank()) {
            Toast.makeText(context, "Vui lòng nhập lại mật khẩu", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != rePassword) {
            Toast.makeText(context, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show()
            return
        }

        val registerRequest = RegisterReq(name, email, password)
        viewmodel.register(registerRequest)
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

                //val context
                val context = LocalContext.current
                Row{
                    Button(
                        onClick = {
                            //chuyển trang
                           navController.navigate("funChuc_mung")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor  = Color.White
                        )
                    ) {
                        Text(
                            text = "WELCOME",
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 10.sp,
                            fontFamily = FontFamily.Serif,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }

                }

            }



            Box(
                modifier = Modifier
                    .shadow(10.dp)
                    .background(Color.White) // Đặt màu nền bên trong là màu trắng để dễ thấy bóng đổ
                    .align(Alignment.Start)
                    .width(345.dp)
                    .height(550.dp)

            ) {

                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    Column (
                        modifier = Modifier
                            .padding(10.dp)
                    ){

                        TextField(
                            value = name, onValueChange = {name = it},
                            label = { Text(text = "Name")},
                            colors = OutlinedTextFieldDefaults.colors( unfocusedContainerColor = Color.White ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 20.dp) // Đặt chiều rộng tối đa
                        )
                        TextField(
                            value = email, onValueChange = {email = it},
                            label = { Text(text = "Email")},
                            colors = OutlinedTextFieldDefaults.colors( unfocusedContainerColor = Color.White ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 20.dp) // Đặt chiều rộng tối đa
                        )
                        TextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text(text = "Password") },
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(), // Hiện/ẩn mật khẩu
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedContainerColor = Color.White
                            ),
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
                                .fillMaxWidth()
                                .padding(bottom = 20.dp) // Đặt chiều rộng tối đa
                        )
                        TextField(
                            value = rePassword, onValueChange = {rePassword = it},
                            label = { Text(text = "Re Password")},
                            visualTransformation = if (passwordVisible2) VisualTransformation.None else PasswordVisualTransformation(), // Hiện/ẩn mật khẩu
                            colors = OutlinedTextFieldDefaults.colors( unfocusedContainerColor = Color.White ),
                            trailingIcon = {
                                IconButton(onClick = {
                                    passwordVisible2 = !passwordVisible2 // Đổi trạng thái hiển thị mật khẩu
                                }) {
                                    Icon(
                                        painter = painterResource(id = if (passwordVisible2) R.drawable.showicon else R.drawable.hiddenicon),
                                        contentDescription = if (passwordVisible2) "Hide password" else "Show password",
                                        modifier = Modifier
                                            .size(25.dp)
                                    )
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 20.dp) // Đặt chiều rộng tối đa
                        )


                        Spacer(modifier = Modifier.height(20.dp))
                    }


                    // Log in Button
                    val context = LocalContext.current

                    Button(
                        onClick = {
                            checkLogin()
                        },
                        modifier = Modifier
                            .width(300.dp)
                            .height(54.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor  = Color(0xF21D1C1C)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "SIGN UP",
                            color = Color.White,
                            fontFamily = FontFamily.Serif,
                            fontSize = 18.sp,
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Sign up Link
                    Row(modifier = Modifier

                        .wrapContentWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Already have account? ",
                            color = Color.Black,
                            fontSize = 14.sp,
                            modifier = Modifier
                        )
                        Text(
                            text = "SIGN IN",
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .clickable {
                                    navController.navigate("funDangNhap")
                                }
                        )
                    }

                }

            }
        }

}
}


