package com.example.lab1_ps36752.lab1

fun main() {
    // Nhập số tiền của laptop
    print("Nhập số tiền của laptop: ")
    val soTienLaptop = readln().toInt()

    // Gọi hàm tính lãi suất
    tinhLaiSuat(soTienLaptop)
}

fun tinhLaiSuat(soTienLaptop: Int) {

    val laiSuat = 0.01

    val thoiGianTra = 6

    val tienTraMoiThang = soTienLaptop / thoiGianTra

    var soTienGocConLai = soTienLaptop - tienTraMoiThang

    println("Tháng | Số tiền gốc còn lại | Số tiền cần trả | Tiền lãi | Tổng số tiền phải trả")

    for (thang in 1..thoiGianTra) {

        val tienLai = (soTienGocConLai + tienTraMoiThang) * laiSuat

        val tongTienPhaiTra = tienTraMoiThang + tienLai

        println("$thang       | ${soTienGocConLai} đ        | $tienTraMoiThang đ        | ${tienLai.toInt()} đ   | ${tongTienPhaiTra.toInt()} đ")

        // Cập nhật số tiền gốc còn lại sau khi trả góp
        soTienGocConLai -= tienTraMoiThang
    }
}

