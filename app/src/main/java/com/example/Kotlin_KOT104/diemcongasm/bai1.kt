package com.example.Kotlin_KOT104.diemcongasm


fun kiemTraSoHoanThien(n: Int): Boolean {
    var tongUocSo = 0
    var i = 1

    while (i < n) {
        if (n % i == 0) {
            tongUocSo += i
        }
        i++
    }

    return tongUocSo == n
}

fun bai2(n: Int): Boolean {
    var ket_qua = 0
    var so_dau = 0
    var so_thu_hai = 1
    while (so_thu_hai <= n) {
        print("$so_dau")
        so_thu_hai += so_dau
        so_dau = so_thu_hai
    }
    println()
    return true
}

fun bai3(n: Int): Boolean {
    var soGoc = n
    var soDaoNguoc = 0
    var test = n

    while (test > 0 ){
        val chuSo = test % 10

        soDaoNguoc = soDaoNguoc * 10 + chuSo

        test /= 10
    }

    return soGoc == soDaoNguoc
}

fun main() {
    var so_n: Int

    do {
        println("Menu:")
        println("1. Kiểm tra số hoàn thiện")
        println("2. Fibonacci ")
        println("3. Số đối xứng")
        print("Chọn menu: ")

        so_n = readln().toInt()

        when (so_n) {
            1 -> {
                print("Nhập số để kiểm tra: ")
                val n = readln().toInt()
                if (kiemTraSoHoanThien(n)) {
                    println("$n là số hoàn thiện")
                } else {
                    println("$n không phải là số hoàn thiện")
                }
            }
            2 -> {
                println("Nhập số m thích: ")
                val n = readln().toInt()
                (bai2(n))
            }
            3 -> {
                println("Nhập số n: ")
                val n = readln().toInt()
                if(bai3(n)){
                    println("$n là số đối xứng")
                } else {
                    println("$n không phải là số đối xứng")
                }
            }

            else -> {
                println("Lựa chọn không hợp lệ, vui lòng chọn lại!")
            }
        }
    } while (so_n != 0)
}


