package com.example.Kotlin_KOT104.asm

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.Kotlin_KOT104.testapi.ViewModelApp
import com.example.lab1_ps36752.R
import java.text.NumberFormat
import java.util.Locale


@Composable
fun Home(navHostController: NavHostController, viewModel: ViewModelApp = viewModel()) {

    val categorys by viewModel.categorys

    val products by viewModel.products

    var selectedCategoryId by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        viewModel.getCategoryViewModel()
        viewModel.getAllProducts()
    }

    // Lọc sản phẩm dựa trên danh mục đã chọn
    val filteredProducts = if (selectedCategoryId != null) {
        //it.category lấy id của category từ model product
        products.filter { it.category == selectedCategoryId }
    } else {
        products
    }


    // Hàm để định dạng số tiền thành dạng VND
    fun formatGiaTien(price: Int): String {
        val formatter = NumberFormat.getCurrencyInstance(Locale("vi", "VN"))
        return formatter.format(price)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(20.dp)) {

        // Header
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(R.drawable.search_24),
                contentDescription = null
            )
            Column {
                Text(
                    text = "Make home",
                    fontSize = 18.sp,
                    color = Color(0xFF909090)
                )
                Text(
                    text = "BEAUTIFUL",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
            Image(
                painter = painterResource(R.drawable.baseline_shopping_cart_24),
                contentDescription = null,
                Modifier.clickable(indication = null, interactionSource = remember { MutableInteractionSource() }){
                    navHostController.navigate("funCart")
                }
            )
        }

        // Categories
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.padding(top = 20.dp)
        ) {
            // Thêm mục "Popular"
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(if (selectedCategoryId == null) Color(0xFFE0E0E0) else Color(0xFFF5F5F5))
                        .clickable {
                            selectedCategoryId = null
                        }
                        .padding(5.dp),
                ) {
                    AsyncImage(
                        model = R.drawable.baseline_star_24,
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(top = 10.dp)
                    )
                    Text(
                        text = "Popular",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF999999),
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }

            // Lặp qua danh sách categorys
            items(categorys) { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(if (selectedCategoryId == item._id) Color(0xFFE0E0E0) else Color(0xFFF5F5F5))
                        .clickable {
                            selectedCategoryId = item._id
                        }
                        .padding(5.dp),
                ) {
                    AsyncImage(
                        model = item.image,
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(top = 10.dp)
                    )
                    Text(
                        text = item.name,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF999999),
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }
        }

        // Products
        val context = LocalContext.current
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filteredProducts) { item -> // Sử dụng danh sách sản phẩm đã lọc
                Card(
                    modifier = Modifier
                        .size(width = 157.dp, height = 236.dp)
                        .background(color = Color.White)
                        .clickable {
                        //    navHostController.navigate("funChiTietSanPham/${item._id}")
                        },
                    colors = CardDefaults.cardColors(containerColor = Color.Gray) // Đặt màu nền là trắng

                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        // Ảnh sản phẩm phủ hết
                        AsyncImage(
                            model = item.image,
                            contentDescription = null,
                            modifier = Modifier
                                .clickable {
                                    navHostController.navigate("funChiTietSanPham/${item._id}")

                                }
                                .fillMaxSize() // Để ảnh phủ hết
                                .clip(RoundedCornerShape(8.dp)), // Bo góc cho ảnh
                            contentScale = ContentScale.Crop
                        )
                        // Đặt tên sản phẩm và giá lên ảnh
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomStart) // Căn chỉnh đến dưới bên trái
                                .background(Color.Black.copy(alpha = 0.5f)) // Nền mờ cho tên và giá
                                .padding(8.dp) // Padding cho tên và giá
                        ) {
                            Text(
                                text = item.nameProduct,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                            Text(
                                text = formatGiaTien(item.price),
                                color = Color.White,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }

    }
}




