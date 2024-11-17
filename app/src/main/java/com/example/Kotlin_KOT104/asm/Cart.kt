package com.example.Kotlin_KOT104.asm


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.lab1_ps36752.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funCart(navHostController: NavHostController) {
    var promoCode by remember { mutableStateOf("") }


    data class NhanVien(val tenSP: String, val gia: Int, val anh: String)

    val listSP = remember {
        mutableStateListOf(
            NhanVien("Minimal Stand",  6000,  "https://bizweb.dktcdn.net/100/429/325/products/o1cn012shzpl1psjdbflbf7-2214670281839-0-cib.jpg?v=1696941369057"),
            NhanVien("Coffee Table",9000,"https://i.etsystatic.com/50202702/r/il/e7fa81/6116251090/il_794xN.6116251090_im88.jpg"),
            NhanVien("Minimal Desk",  7000, "https://i.etsystatic.com/26514007/r/il/b310e5/3653094048/il_570xN.3653094048_d2ul.jpg"),
            NhanVien("Office Desk ",  8000, "https://i.etsystatic.com/43456467/r/il/955758/5035821966/il_1140xN.5035821966_mtv7.jpg"),
            NhanVien("Office Desk 2 ",  9000, "https://i.etsystatic.com/50202702/r/il/6e0032/6166026163/il_1140xN.6166026163_nyqy.jpg"),
        )
    }



    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = null,
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() })
                    {
                        navHostController.popBackStack()
                    }
            )
            Text(text = "My cart", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = "")
        }





        //list sp

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(550.dp)
        ) {
            items(listSP){ item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp, bottom = 14.dp)
                ) {
                    Box(modifier = Modifier) {
                        AsyncImage(
                            model = item.anh,
                            contentDescription = null,
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .clip(RoundedCornerShape(16.dp))
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp)
                    ) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = ""+item.tenSP, color = Color.Gray, fontSize = 14.sp)
                                Image(
                                    painter = painterResource(id = R.drawable.xmark),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(20.dp)
                                        .height(20.dp)
                                )
                            }
                            Text(text = "" +item.gia, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            Row(
                                modifier = Modifier.padding(top = 25.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                    Box(
                                        modifier = Modifier
                                            .width(30.dp)
                                            .height(30.dp)
                                            .clip(RoundedCornerShape(5.dp))
                                            .background(Color(0xFFf3f3f3)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(text = "+", color = Color.Black)
                                    }

                                Text(text = "01", modifier = Modifier.padding(start = 10.dp, end = 10.dp))

                                Box(
                                    modifier = Modifier
                                        .width(30.dp)
                                        .height(30.dp)
                                        .clip(RoundedCornerShape(5.dp))
                                        .background(Color(0xFFf3f3f3)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(text = "-", color = Color.Black)
                                }
                            }
                        }
                    }
                }
                // Đường kẻ ngang
                Divider(
                    color = Color.Gray, // Màu xám
                    thickness = 0.5.dp,   // Độ dày của đường
                )

            }
        }




        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            Column{
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextField(
                        value = promoCode, // Sử dụng biến trạng thái
                        onValueChange = {
                            promoCode = it
                        }, // Cập nhật giá trị khi người dùng nhập liệu
                        placeholder = { Text(text = "Enter your promo code") }, // Thêm placeholder cho TextField
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFe7e7e7), // Màu nền trắng
                            focusedIndicatorColor = Color.Transparent, // Ẩn viền khi được chọn
                            unfocusedIndicatorColor = Color.Transparent // Ẩn viền khi không được chọn
                        )
                    )
                    Button(
                        onClick = { /*TODO*/ }, modifier = Modifier
                            .width(50.dp)
                            .height(55.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black // Đặt màu nền của nút thành màu đen
                        ),
                        shape = RoundedCornerShape(5.dp) // Bo tròn 10dp
                    ) {
                        Text(text = ">", color= Color.White)
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Total:", color = Color.Gray, fontSize = 20.sp)
                    Text(
                        text = "$ 95.00",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = {
                              navHostController.navigate("funThanhToan")
                              },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black // Đặt màu nền của nút thành màu đen
                    ),
                    shape = RoundedCornerShape(10.dp) // Bo tròn 10dp
                ) {
                    Text(text = "Check out", color = Color.White)
                }
            }
        }
    }
}