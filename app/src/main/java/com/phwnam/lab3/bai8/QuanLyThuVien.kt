package com.phwnam.lab3.bai8

import java.util.Scanner
import kotlin.system.exitProcess

class SinhVien (var ten: String, var tuoi: Int, var lop: String){

}

class TheMuon (var maPM: String, var ngayMuon: String, var hanTra: String, var sinhVien: SinhVien){
    override fun toString(): String {
        return "Mã PM: $maPM, Ngày Mượn: $ngayMuon, Hạn Trả: $hanTra, \n" +
                "Tên SV: ${sinhVien.ten}, Tuổi: ${sinhVien.tuoi}, Lớp: ${sinhVien.lop}"
    }
}

var danhSachTM = mutableListOf<TheMuon>()

fun main(){
    println(menu1())
}

fun themPhieuMuon(){
    val scanner = Scanner(System.`in`)
    do{
        // Nhập thông tin sinh viên
        println("Nhập thông tin sinh viên:")
        print("Họ tên: ")
        val tenSV = scanner.nextLine()
        print("Tuổi: ")
        val tuoiSV = scanner.nextInt()
        scanner.nextLine() // Đọc bỏ dòng new line sau khi nhập số tuổi
        print("Lớp: ")
        val lopSV = scanner.nextLine()

        val sinhVien = SinhVien(tenSV, tuoiSV, lopSV)

        // Nhập thông tin phiếu mượn
        println("Nhập thông tin phiếu mượn:")
        print("Mã phiếu mượn: ")
        val maPM = scanner.nextLine()
        print("Ngày mượn: ")
        val ngayMuon = scanner.nextLine()
        print("Hạn trả: ")
        val hanTra = scanner.nextLine()

        val theMuon = TheMuon(maPM, ngayMuon, hanTra, sinhVien)
        danhSachTM.add(theMuon)
        println("Thêm thành công")

        print("Thêm tiếp? (y/n): ")
        var tiepTuc = scanner.nextLine()
        if (tiepTuc == "n") {
            println("Kết thúc chương trình")
        }
    }while (tiepTuc == "y")
    menu1()
}

fun dspm(){
    danhSachTM.forEach { tm -> println(tm.toString()) }
    print("Trở về menu? (y/n): ")
    var s = readLine()
    if (s == "y") {
        menu1()
    }else{
        println("Kết thúc chương trình")
    }
}

fun menu1() {
    println("Quản lý thư viện")
    println("-------------------")
    println("1. Thêm phiếu mượn")
    println("2. Danh sách phiếu mượn")
    println("3. Xoá phiếu mượn")
    println("0. Thoát")
    println("-------------------")
    print("Lựa chọn: ")
    var s = readLine()
    when (s) {
        "1" -> themPhieuMuon()
        "2" -> dspm()
        "3" -> xoaPhieuMuon()
        "0" -> {
            println("Kết thúc chương trình")
            exitProcess(0)
        }
        else -> {
            println("Lựa chọn không hợp lệ")
            menu1()
        }
    }
}

fun xoaPhieuMuon() {
    do {
        println("Xoá phiếu mượn theo Mã PM")
        print("Nhập mã PM: ")
        var mspm = readLine()
        var PMxoa = danhSachTM.find { it.maPM == mspm }
        if (PMxoa == null) {
            println("Mã PM không tồn tại")
        } else {
            danhSachTM.remove(PMxoa)
            println("Xoá thành công")
        }
        print("Xoá tiếp? (y/n): ")
        var tiepTuc = readLine()
        if (tiepTuc == "n") {
            println("Kết thúc chương trình")
        }
    }while (tiepTuc == "y")
    menu1()
}

