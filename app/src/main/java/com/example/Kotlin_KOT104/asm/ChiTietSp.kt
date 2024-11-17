package com.example.Kotlin_KOT104.asm


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.Kotlin_KOT104.testapi.ViewModelApp
import com.example.lab1_ps36752.R
import java.text.NumberFormat
import java.util.Locale


@Composable
fun funChiTietSanPham(navController: NavController,productId: String, viewModel: ViewModelApp = viewModel()) {

    val detailProduct by viewModel.detailProduct

    // Gọi API khi Composable được khởi tạo
    LaunchedEffect(productId) {
        viewModel.getDetailProduct(productId)
    }

    var ko by remember {
        mutableStateOf("0")
    }

    var quantity by remember {
        mutableStateOf(1)
    }

    fun tangGiamQuantity(x: Int){
        if(x==1){
            quantity++;
        }else if(quantity>1){
            quantity--;
        }

        if(quantity>9){
            ko="";
        }else{
            ko="0";
        }
    }

    // Hàm để định dạng số tiền thành dạng VND
    fun formatGiaTien(price: Int): String {
        val formatter = NumberFormat.getCurrencyInstance(Locale("vi", "VN"))
        return formatter.format(price)
    }

    detailProduct?.let { product ->
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        //horizontalAlignment = Alignment.CenterHorizontally // Căn giữa nội dung theo trục ngang
    ) {
        Box{
            AsyncImage(
                model = product.image,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(440.dp)
            )
            // Nút

            Button(
                onClick = {navController.popBackStack()},
                modifier = Modifier
                    .absoluteOffset(x= 5.dp, y = 40.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor  = Color.White,
                ),
                shape = RoundedCornerShape(6.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = null,
                    modifier = Modifier
                        .width(15.dp)
                        .height(20.dp),
                    contentScale = ContentScale.Crop,
                )
            }
        }
        /// Name product Minimal Stand
        Text(
            text = "${product.nameProduct}",
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp)
                .fillMaxWidth(),
            color = Color.Black,
            fontSize = 24.sp,
        )
        // price and quatity
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            //price
            Text(
                text = "Price: ${formatGiaTien(product.price)}",
                modifier = Modifier
                    .padding(start = 20.dp)
                    .width(200.dp),
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
            )
            //quatity
            IconButton(
                onClick = {tangGiamQuantity(1)},
            ) {
                Box(
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFFf3f3f3)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "+",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            //quatity
            Text(
                text = "${ko}${quantity.toString()}",
                modifier = Modifier
                    .width(50.dp),
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            IconButton(
                onClick = {tangGiamQuantity(-1)},
            ) {
                Box(
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFFf3f3f3)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "-",
                        color = Color.Black,
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        //sao
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Image(
                painter = painterResource(id = R.drawable.baseline_star_24),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .width(20.dp)
                    .height(20.dp),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "4.5",
                modifier = Modifier
                    .padding(start = 10.dp),
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            //reviews
            Text(
                text = "(50 reviews)",
                modifier = Modifier
                    .padding(start = 20.dp),
                color = Color.Gray,
                fontSize = 14.sp,
            )
        }

        // mieu ta
        Text(
            text = "${product.description}",
            modifier = Modifier
                .padding( start = 20.dp, end = 20.dp, top = 10.dp),
            color = Color.Gray,
            fontSize = 14.sp,
            textAlign = TextAlign.Justify
        )

        // 2 btn save and Add to cart
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            // btn save
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(start = 20.dp)
                    .width(60.dp)
                    .height(60.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFFf3f3f3)),
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.outline_bookmark_24),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                navController.navigate("funThanhToan")
                            }
                            .width(20.dp)
                            .height(20.dp),
                    )
                }
            }
            // btn Add to cart
            Button(
                onClick = {


                },
                modifier = Modifier
                    .padding(start = 20.dp)
                    .width(250.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor  = Color(0xF21D1C1C)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Add to cart",
                    color = Color.White,
                    fontSize = 20.sp,
                )
            }
        }

    }
    }
}
