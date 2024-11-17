package com.example.Kotlin_KOT104.testapi

//danh mục sản phẩm
data class Category(val _id: String, val name: String, val image: String)

//danh sách sản phẩm
data class Products(val _id: String, val nameProduct: String, val price: Int, val image: String, val description: String, val category: String)

data class RegisterReq(val name: String, val email: String, val password: String)
data class RegisterRes(val status: Boolean, val message: String)

data class LoginReq(val email: String,val password: String)
data class LoginRes(val status: Boolean, val message: String)


