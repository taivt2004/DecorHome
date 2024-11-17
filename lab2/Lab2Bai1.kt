package com.example.lab1_ps36752.lab2

fun main () {
    println("Nhập vào 1 số nguyên n: ")
    val soNguyenN = readln().toInt()

    println("Nhập vào một số thực x để tính x^n: ")
    val x = readln().toDouble()

    xuatSo(soNguyenN)
    xuatSoChan(soNguyenN)
    xuatSoLe(soNguyenN)

    val S1 = tinhS1(soNguyenN)
    val S2 = tinhS2(soNguyenN)
    val S3 = tinhS3(soNguyenN)
    val S4 = tinhS4(x, soNguyenN)
    val tongChuSo = tongChuSo(soNguyenN)

    println("Tổng S1 (1 + 2 + ... + $soNguyenN) là: $S1")
    println("Tổng S2 (-1 + 2 - 3 + ... + (-1)^n * $soNguyenN) là: $S2")
    println("Tổng S3 (1/2 + 2/3 + ... + $soNguyenN/(${soNguyenN+1})) là: $S3")
    println("S4 (x^$soNguyenN) là: $S4")
    println("Tổng các chữ số của $soNguyenN là: $tongChuSo")

}

//a) các số trong phạm vi từ 1-n
fun xuatSo(soNguyenN: Int){
    print("Tất cả số trong phạm vi từ 1-$soNguyenN là: ")
    for (i in 1..soNguyenN){
        print("$i ")
    }
    println()
}

//b) các số chẵn trong phạm vi từ 1-n
fun xuatSoChan(soNguyenN: Int){
    print("Tất cả số chẵn trong phạm vi từ 1-$soNguyenN là: ")
    for(i in 1..soNguyenN){
            if(i % 2 == 0){
                print("$i ")
            }
        }
    println()
}

//c) xuất ra các số lẻ không chia hết cho 3 trong phạm vi từ 1-n
fun xuatSoLe(soNguyenN: Int){
    print("Tất cả số lẻ trong phạm vi từ 1-$soNguyenN là: ")
    for(i in 1..soNguyenN){
        if(i % 2 != 0){
            print("$i ")
        }
    }
    println()
}

// d) Tính S1 = 1 + 2 + ... + n
fun tinhS1(soNguyenN: Int): Int {
    var sum = 0
    for (i in 1..soNguyenN) {
        sum += i
    }
    return sum
}

// d) Tính S2 = -1+-2-3+4-...+(-1)^n*n
fun tinhS2(soNguyenN: Int): Int {
    var a = 0
    for (i in 1..soNguyenN) {
        a += if (i % 2 == 0) i else -i
    }
    return a
}

// d) Tính S3 = 1/2 + 2/3 + 3/4 + ... + n/(n+1)
fun tinhS3(soNguyenN: Int): Double {
    var sum = 0.0
    for (i in 1..soNguyenN) {
        sum += i.toDouble() / (i + 1)
    }
    return sum
}

// d) Tính S4 = x^n
fun tinhS4(x: Double, soNguyenN: Int): Double {
    return Math.pow(x, soNguyenN.toDouble())
}

// e) Tính tổng các chữ số của n
fun tongChuSo(soNguyenN: Int): Int {
    var n = soNguyenN
    var sum = 0
    while (n != 0) {
        sum += n % 10
        n /= 10
    }
    return sum
}