package com.example.Kotlin_KOT104.testapi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import java.lang.reflect.Modifier



@Composable
fun funMainAPI(navController: NavController,viewModel: ViewModelApp = viewModel()) {
    val categorys by viewModel.categorys

    LaunchedEffect(Unit) {
        viewModel.getCategoryViewModel()
    }


    LazyColumn {
        items(categorys){
                item ->  Card {
            Column {
                Text(text = item._id)
                Text(text = item.name)
                AsyncImage(
                    model = item?.image,
                    contentDescription = "",
                    modifier = androidx.compose.ui.Modifier.width(100.dp).height(100.dp)

                )
            }

        }
        }
    }
}
