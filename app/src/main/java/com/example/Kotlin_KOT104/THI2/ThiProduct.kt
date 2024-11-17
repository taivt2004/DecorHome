package com.example.Kotlin_KOT104.THI2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lab1_ps36752.R

@Composable
fun funProduct2(navController: NavController){

    data class product(val nameProduct: String,val imgProduct: Int, val brand: String , val price: String)

    val list1 = remember {
        mutableStateListOf(
            product("Strawberry Punch", R.drawable.productthi1,"Tradly","$25"),
            product("Lemonade", R.drawable.productthi2,"Tradly","$25"),
            product("Chocolate", R.drawable.productthi3,"Tradly","$25"),
            product("Whisky", R.drawable.productthi4,"Tradly","$25"),
            product("Chocolate Bakery", R.drawable.productthi1,"Tradly","$25")

        )
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {


        Row(modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color(0xF22C9665))
            .padding(top = 30.dp)
        ) {
            Image(painter = painterResource(R.drawable.baseline_arrow_back_24), contentDescription = "", modifier = Modifier.padding(end = 20.dp, top = 3.dp, start = 10.dp))
            Text(text = "Beverages", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.White, modifier = Modifier.padding(start = 100.dp))
        }




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
                items(list1) { item ->
                            Column(modifier = Modifier
                                .padding(5.dp)
                                .background(Color(0xF2E5ECEB))
                                .clip(RoundedCornerShape(16.dp)),

                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,

                            ) {
                                Image(painter = painterResource(item.imgProduct), contentDescription = "", modifier = Modifier.size(150.dp))
                                Text(text = "${item.nameProduct}", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                Row(
                                    horizontalArrangement = Arrangement.Center
                                )
                                {
                                    Image(painter = painterResource(R.drawable.logo4), contentDescription = "", modifier = Modifier.size(30.dp).padding(start = 10.dp))
                                    Text(text = "${item.brand}", modifier = Modifier.padding(end = 50.dp, top = 5.dp))
                                    Text(text = "${item.price}", color = Color(0xF22C9665), fontWeight = FontWeight.Bold, modifier = Modifier.padding(end = 20.dp, top = 5.dp))
                                }
                            }

                    }
                }
            }
        }


}