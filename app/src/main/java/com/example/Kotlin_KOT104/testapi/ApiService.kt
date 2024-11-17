package com.example.Kotlin_KOT104.testapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

//interface định nghĩa api
interface ApiService {


    @GET("category/getCategories")
    suspend fun getCategory(): List<Category>

    @GET("products/allProduct")
    suspend fun getProducts(): List<Products>

    @GET("products/detailProduct")
    suspend fun getDetailProduct(@Query("productId") productId: String): Products


    @POST("users/dangki")
    suspend fun register(@Body registerReq: RegisterReq): RegisterRes

    @POST("users/dangnhap")
    suspend fun login(@Body loginReq: LoginReq): LoginRes


}

// Object để khởi tạo Retrofit
object RetrofitInstance {
    private const val BASE_URL = "http://192.168.218.225:3000/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}