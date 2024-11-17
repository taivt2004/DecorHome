package com.example.Kotlin_KOT104.lab5

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun funList(navController: NavHostController) {


    data class NhanVien(val maNV: Int, val tenNV: String, val luongCB: Int)



    val listNV = remember {
        mutableStateListOf(
            NhanVien(1, "Nguyễn Văn A", 6000),
            NhanVien(2, "Nguyễn Văn B", 9000),
            NhanVien(3, "Nguyễn Văn C", 7000),
            NhanVien(4, "Nguyễn Văn D", 12000),
            NhanVien(5, "Nguyễn Văn E", 11000),
            NhanVien(6, "Nguyễn Văn F", 14000)
        )
    }
    val context = LocalContext.current

    var ID by remember { mutableStateOf("") }

    var Ten by remember { mutableStateOf("") }

    var Luong by remember { mutableStateOf("") }



    fun XoaNhanVien(maNV: Int) {

        val nhanVienIndex = listNV.indexOfFirst { it.maNV == maNV }

        listNV.removeAt(nhanVienIndex)

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xF24D4541))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp),
        ) {

            // Danh sách nhân viên
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 150.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            ) {
                items(listNV) { item ->
                    Card(modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clickable {
                            ID = item.maNV.toString()
                            Ten = item.tenNV
                            Luong = item.luongCB.toString()
                        })
                    {

                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(
                                    text = "Mã nhân viên: " + item.maNV.toString(),
                                    fontSize = 15.sp
                                )
                                Text(
                                    text = "Tên: " + item.tenNV,
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                Text(text = "Lương: " + item.luongCB.toString(), fontSize = 15.sp)
                            }


                        OutlinedButton(onClick = {XoaNhanVien(item.maNV)}, modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)) {
                            Text(text = "Xóa", color = Color.Black)
                        }


                        }

                        //
                    }

            }
        }

        fun SuaNhanVien() {
            if (ID.isBlank()) {
                Toast
                    .makeText(context, "Vui lòng nhập ID để sửa!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                try {
                    val idToEdit = ID.toInt()

                    // Tìm nhân viên với ID tương ứng
                    val nhanVienIndex = listNV.indexOfFirst { it.maNV == idToEdit }

                    if (nhanVienIndex == -1) {
                        // Nếu ID không tồn tại trong danh sách, hiển thị thông báo lỗi
                        Toast
                            .makeText(context, "ID nhân viên không tồn tại", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        // Nếu ID tồn tại, thực hiện cập nhật thông tin nhân viên
                        val updatedTen = Ten
                        val updatedLuong = Luong.toIntOrNull() ?: 0

                        // Cập nhật nhân viên với thông tin mới
                        listNV[nhanVienIndex] = NhanVien(idToEdit, updatedTen, updatedLuong)

                        ID = ""
                        Ten = ""
                        Luong = ""

                        Toast
                            .makeText(context, "Cập nhật thông tin thành công!", Toast.LENGTH_SHORT)
                            .show()
                    }
                } catch (e: NumberFormatException) {
                    Toast
                        .makeText(context, "Lỗi: ID hoặc Lương không hợp lệ!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        fun ThemNhanVien() {
            if (ID.isNotBlank() && Ten.isNotBlank() && Luong.isNotBlank()) {
                try {
                    val newId = ID.toInt()
                    val newTen = Ten
                    val newLuong = Luong.toInt()

                    // Kiểm tra xem ID đã tồn tại trong danh sách hay chưa
                    val idExists = listNV.any { it.maNV == newId }

                    if (idExists) {
                        // Nếu ID đã tồn tại, hiển thị thông báo lỗi
                        Toast
                            .makeText(context, "ID đã tồn tại", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        // Nếu ID chưa tồn tại, thêm nhân viên mới vào danh sách
                        val newNhanVien = NhanVien(newId, newTen, newLuong)
                        listNV.add(newNhanVien)

                        // Xóa dữ liệu trong TextField
                        ID = ""
                        Ten = ""
                        Luong = ""
                    }
                } catch (e: NumberFormatException) {
                    // Xử lý trường hợp ID hoặc Lương không phải là số
                    Toast
                        .makeText(context, "Lỗi: ID hoặc Lương không hợp lệ!", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                // Xử lý khi các trường còn trống
                Toast
                    .makeText(context, "Lỗi: Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT)
                    .show()
            }
        }


        // TextField
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {

            TextField(
                value = ID,
                onValueChange = {ID = it},
                label = { Text(text = "ID", color = Color.Black) },
                colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xF2CCB9AF)),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )
            TextField(
                value = Ten,
                onValueChange = {Ten = it},
                label = { Text(text = "Tên", color = Color.Black) },
                colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xF2CCB9AF)),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )
            TextField(
                value = Luong,
                onValueChange = {Luong = it},
                label = { Text(text = "Lương", color = Color.Black) },
                colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xF2CCB9AF)),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )

            OutlinedButton(onClick = { SuaNhanVien()}, modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)) {
                Text(text = "Sửa", color = Color.White)
            }
            OutlinedButton(onClick = { ThemNhanVien()}, modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)) {
                Text(text = "Thêm", color = Color.White)
            }
        }
    }






}


