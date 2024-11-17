package com.example.Kotlin_KOT104.lab1

fun main() {
    println("Nhập số a")
    val a = readln().toInt()

    val chuSoDauTien = timChuSoDauTien(a)
    println("Chữ số đầu tiên của $a là: $chuSoDauTien")


    if(a %2 == 0){
        println("$a là số chẵn")
    }else{
        println("$a là số lẻ")
    }

    if (kiemTraGiamDan(a)) {
        println("Các chữ số của $a giảm dần từ trái sang phải")
    } else {
        println("Các chữ số của $a không giảm dần từ trái sang phải")
    }
}



fun kiemTraGiamDan (a: Int): Boolean {
    var number = a
    var soCuoi = number % 10
    number /=10

    while (number > 0) {
        val soKeTiep = number % 10

        if(soKeTiep < soCuoi){
            return false
        }
        number /= 10
    }
    return true
}



fun timChuSoDauTien(a: Int): Int {
    var number = a
    while (number >= 10) {
        number /= 10
    }
    return number
}
