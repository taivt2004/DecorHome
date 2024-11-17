package com.example.Kotlin_KOT104.asm


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lab1_ps36752.R

@Composable
fun funThanhToan(navHostController: NavHostController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        navHostController.popBackStack()
                    }
                    .width(25.dp)
                    .height(25.dp)
            )
            Text(text = "Check out", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = "")
        }
        Row(
            modifier = Modifier
                .padding(top = 19.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Shipping Address", color = Color.Gray, fontSize = 18.sp)
            Image(
                painter = painterResource(id = R.drawable.baseline_edit_24),
                contentDescription = null,
                modifier = Modifier
                    .width(16.dp)
                    .height(20.dp)
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(5.dp)
                )
                .background(Color.White)
                .shadow(
                    elevation = 3.dp, // Độ cao của bóng
                    spotColor = Color(0xFF909090)
                )
        ) {
            Column {
                Text(
                    text = "Bruno Fernandes",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp)
                )
                // Đường kẻ ngang
                Divider(
                    color = Color.Gray, // Màu xám
                    thickness = 0.5.dp,   // Độ dày của đường
                )
                Text(
                    text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(20.dp)

                )
            }
        }
        Row(
            modifier = Modifier
                .padding(top = 19.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Payment", color = Color.Gray, fontSize = 18.sp)
            Image(
                painter = painterResource(id = R.drawable.baseline_edit_24),
                contentDescription = null,
                modifier = Modifier
                    .width(16.dp)
                    .height(20.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .clip(
                    RoundedCornerShape(5.dp)
                )
                .background(Color.White)
                .shadow(
                    elevation = 3.dp, // Độ cao của bóng
                    spotColor = Color(0xFF909090)
                )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.visa),
                    contentDescription = null,
                    modifier = Modifier
                        .width(120.dp)
                        .height(100.dp)
                )
                Text(
                    text = "**** **** **** 3947",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(top = 19.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Delivery method", color = Color.Gray, fontSize = 18.sp)
            Image(
                painter = painterResource(id = R.drawable.baseline_edit_24),
                contentDescription = null,
                modifier = Modifier
                    .width(16.dp)
                    .height(20.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .clip(
                    RoundedCornerShape(5.dp)
                )
                .background(Color.White)
                .shadow(
                    elevation = 3.dp, // Độ cao của bóng
                    spotColor = Color(0xFF909090)
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.brand),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .width(80.dp)
                        .height(100.dp)
                )
                Text(
                    text = "Fast (2-3days)",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            Column {
                Column(
                    modifier = Modifier
                        .padding(bottom = 15.dp)
                        .clip(
                            RoundedCornerShape(5.dp)
                        )
                        .background(Color.White)
                        .shadow(
                            elevation = 3.dp, // Độ cao của bóng
                            spotColor = Color(0xFF909090)
                        )
                        .padding(10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(7.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Order:", color = Color.Gray, fontSize = 20.sp)
                        Text(
                            text = "$ 95.00",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(7.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Delivery:", color = Color.Gray, fontSize = 20.sp)
                        Text(
                            text = "$ 5.00",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(7.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Total:", color = Color.Gray, fontSize = 20.sp)
                        Text(
                            text = "$ 100.00",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black // Đặt màu nền của nút thành màu đen
                    ),
                    shape = RoundedCornerShape(10.dp) // Bo tròn 10dp
                ) {
                    Text(text = "SUBMIT ORDER", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}