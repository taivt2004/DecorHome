package com.example.lab1_ps36752.lab1

fun main() {
    nhap_so()
}


fun nhap_so(){

    var a = 0
    var b = 0
    do {
        print("nhập giờ bất đầu: ")
        a = readln().toInt()
        print("nhập giờ kết thúc: ")
        b = readln().toInt()
    } while (a < 7 || b > 23)
    var tong_gio_choi = b - a
    println("Tổng giờ chơi: $tong_gio_choi")

    var tong_tien = 0

    if (14<= a && a <= 16 ){
        tong_tien = 20000 +  ((tong_gio_choi - 2 ) *10000)*(75)/100
        println("Tổng tiền đã trừ của happy hours là: $tong_tien")
    }else{
        tong_tien = 20000 +  ((tong_gio_choi - 2 ) *10000)*(100-15)/100
        println("Tổng tiền là: $tong_tien")
    }
    return nhap_so()
}