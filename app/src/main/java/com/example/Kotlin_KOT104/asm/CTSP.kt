//package com.example.Kotlin_KOT104.asm
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Card
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import coil.compose.AsyncImage
//import com.example.Kotlin_KOT104.testapi.ViewModelApp
//
//@Composable
//fun funCTSP(navController: NavController, productId: String, viewModel: ViewModelApp = viewModel()) {
//
//
//    val detailProduct by viewModel.detailProduct
//
//
//
//
//    // Gọi API khi Composable được khởi tạo
//    LaunchedEffect(productId) {
//        viewModel.getDetailProduct(productId)
//    }
//
//    // Hiển thị chi tiết sản phẩm nếu có dữ liệu
//    detailProduct?.let { product ->
//        Column {
//            Text(text = "ID: ${product._id}")
//            Text(text = "Name: ${product.nameProduct}")
//            AsyncImage(
//                model = product.image,
//                contentDescription = "Product Image",
//                modifier = Modifier.width(100.dp).height(100.dp)
//            )
//            Text(text = "Price: ${product.price}")
//            Text(text = "Description: ${product.description}")
//
//        }
//    } ?: run {
//        // Hiển thị thông báo khi không có dữ liệu
//        Text(text = "Product not found")
//    }
//}
