package com.example.Kotlin_KOT104.testapi

import android.util.Log
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import org.json.JSONObject
import retrofit2.HttpException


class ViewModelApp : ViewModel(){

    private val _categorys = mutableStateOf<List<Category>>(emptyList())
    val categorys: State<List<Category>> = _categorys

    private val _message = mutableStateOf<RegisterRes?>(null)
    val message : State<RegisterRes?> = _message

    private val _loginMessage = mutableStateOf<LoginRes?>(null)
    val loginMessage: State<LoginRes?> = _loginMessage

    private val _products = mutableStateOf<List<Products>>(emptyList())
    val products: State<List<Products>> = _products

    private val _detailProduct = mutableStateOf<Products?>(null)
    val detailProduct: State<Products?> = _detailProduct


    //lấy danh mục sp
    fun getCategoryViewModel() {
        viewModelScope.launch {
            try {
                _categorys.value = RetrofitInstance.api.getCategory()
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======",e.toString())
            }
        }
    }

    //lấy danh mục sp
    fun getAllProducts() {
        viewModelScope.launch {
            try {
                _products.value = RetrofitInstance.api.getProducts()
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======",e.toString())
            }
        }
    }

    //lấy ctsp
    fun getDetailProduct(productId: String) {
        viewModelScope.launch {
            try {
                // Gọi API để lấy chi tiết sản phẩm
                val response = RetrofitInstance.api.getDetailProduct(productId)
                _detailProduct.value = response
            } catch (e: Exception) {
            }
        }
    }




    //gửi yêu cầu đăng kí
    fun register(register: RegisterReq) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.register(register)
                _message.value = response
            } catch (e: Exception) {
                Log.d("Register Error", e.toString())
                _message.value = RegisterRes(false, "Lỗi không xác định")
            }
        }
    }


    fun login(login: LoginReq) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.login(login)
                _loginMessage.value = response  // Cập nhật giá trị trả về
            } catch (e: Exception) {
                Log.d("Login Error", e.toString()) // Thêm log lỗi
                _loginMessage.value = LoginRes(status = false, message = "Đăng nhập thất bại. Vui lòng thử lại.")

            }
        }
    }
}
