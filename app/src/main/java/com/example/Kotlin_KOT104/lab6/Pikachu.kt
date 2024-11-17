package com.example.Kotlin_KOT104.lab6

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.lab1_ps36752.R


@Composable
fun funPikachu(navController: NavHostController) {
    data class imgPikachu(val SrcImg: Int?)

    val listImg = remember {
        mutableStateListOf(
            imgPikachu(R.drawable.pokemon1),
            imgPikachu(R.drawable.pokemon2),
            imgPikachu(R.drawable.pokemon1),
            imgPikachu(R.drawable.pokemon2),
            imgPikachu(R.drawable.pokemon3),
            imgPikachu(R.drawable.pokemon3),
            imgPikachu(R.drawable.pokemon4),
            imgPikachu(R.drawable.pokemon4),
        )
    }

    val context = LocalContext.current

    // Biến lưu trạng thái hai lần nhấn
    var click1 by remember { mutableStateOf(-1) }
    var click2 by remember { mutableStateOf(-1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xF24D4541))
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 120.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(listImg) { index, item ->
                if (item.SrcImg != null) {
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .width(100.dp)
                            .height(100.dp)
                            .clickable {
                                if (click1 == -1) {
                                    // Người dùng nhấn lần đầu
                                    click1 = index
                                } else if (click2 == -1 && click1 != index) {
                                    // Người dùng nhấn lần thứ hai và khác vị trí
                                    click2 = index

                                    if (listImg[click1].SrcImg == listImg[click2].SrcImg) {
                                        // Nếu hai ảnh giống nhau, ẩn cả hai
                                        listImg[click1] = imgPikachu(null) // Ẩn phần tử
                                        listImg[click2] = imgPikachu(null) // Ẩn phần tử
                                    } else {
                                        // Nếu không giống nhau, reset lại
                                        click1 = -1
                                        click2 = -1
                                    }
                                    // Reset lại biến nhấn
                                    click1 = -1
                                    click2 = -1
                                } else {
                                    // Nhấn cùng một hình hai lần thì không làm gì
                                }
                            }
                    ) {
                        // Hiển thị ảnh trong Card nếu ảnh không bị ẩn
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(5.dp)
                        ) {
                            Image(
                                painter = painterResource(id = item.SrcImg!!),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                } else {

                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .width(100.dp)
                            .height(100.dp)
                            .background(Color.Transparent) // Giữ ô trống
                    )
                }
            }
        }
    }
}
