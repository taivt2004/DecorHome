package com.example.Kotlin_KOT104.THI

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lab1_ps36752.R
@Composable
fun funProduct(navController: NavController){

    var text by remember {
        mutableStateOf("")
    }
    data class product(val id: Int, val img: Int, var name: String, val price: Int, val voting: String)
    val list1 = remember {
        mutableStateListOf(
            product( 1, R.drawable.potato,"Potato", 1000, "4.5"),
            product( 2, R.drawable.carrot,"Carrot",2000,"5"),
            product( 3, R.drawable.onion,"Onion", 3000,"4.3"),
        )
    }

    Column(modifier = Modifier

        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 20.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = "Your city")
            Row {
                Image(
                    painter = painterResource(R.drawable.location),
                    contentDescription = null,
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp)
                )
                Text(
                    text = "Tallin",
                    modifier = Modifier
                        .width(50.dp)
                        .align(Alignment.CenterVertically),
                    //horizontalAlignment = Alignment.CenterHorizontally
                )
                Image(
                    painter = painterResource(R.drawable.mui_ten_xuong),
                    contentDescription = null

                )
            }
        }

        //search
        TextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text(text = "Search") },
            modifier = Modifier
                .width(350.dp)
                .height(60.dp),


            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xF2A3E65D),
                unfocusedContainerColor = Color(0xF2A3E65D),
                focusedIndicatorColor = Color(0x008FD776),
                unfocusedIndicatorColor = Color(0x008FD776),
            ),
            shape = RoundedCornerShape(40.dp),
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.search_24),
                    contentDescription = "icon search",
                    modifier = Modifier.size(24.dp)
                )
            }
        )

        //list 1

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 150.dp),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(650.dp)
            ) {
                itemsIndexed(list1) { index, item ->
                        Card(
                            modifier = Modifier
                                .padding(10.dp)
                                .width(100.dp)
                                .height(242.dp)
                                .background(Color.White)
                                .clickable {

                                },
                                shape = RoundedCornerShape(30.dp)


                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.White)
                                    .padding(5.dp),

                                ) {

                                Column() {
                                    Image(painter = painterResource(item.img), contentDescription = "")
                                    Text(text = "${item.name}")
                                    Text(text = "${item.price}")
                                    Text(text = "${item.voting}")
                                }


                            }
                        }
            }
        }
        }
        }
    }