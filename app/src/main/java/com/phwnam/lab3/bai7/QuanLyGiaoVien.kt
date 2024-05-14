package com.phwnam.lab3.bai7

import java.util.Scanner
import kotlin.system.exitProcess

class QuanLyGiaoVien {
}

fun main(){
    println(menu() )
}

var danhSachGV = mutableListOf<GiaoVien>()

fun themGV() {
    val scanner = Scanner(System.`in`)
    do {
        println("Thêm giáo viên")
        print("Nhập tên giáo viên: ")
        var tenGV = scanner.nextLine()
        print("Nhập tuổi: ")
        var tuoi = scanner.nextInt()
        scanner.nextLine()
        print("Nhập quê quán: ")
        var quequan = scanner.nextLine()
        val nguoi = Nguoi(tenGV,tuoi, quequan)

        print("Nhập msgv: ")
        var msgv = scanner.nextLine()

        print("Nhập lương cứng: ")
        var luongCung = scanner.nextFloat()
        print("Nhập lương thưởng: ")
        var luongThuong = scanner.nextFloat()
        print("Nhập tiền phạt: ")
        var tienPhat = scanner.nextFloat()
        scanner.nextLine()


        var gv = GiaoVien(nguoi, msgv, luongCung, luongThuong, tienPhat)
        danhSachGV.add(gv)
        println("Thêm thành công")

        print("Thêm tiếp? (y/n): ")
        var tiepTuc = scanner.nextLine()
        if (tiepTuc == "n") {
            println("Kết thúc chương trình")
        }
    } while (tiepTuc == "y")
    menu()
}

fun dsgv(){
    danhSachGV.forEach { gv -> println(gv.hienThiThongTin()) }
    print("Trở về menu? (y/n): ")
    var s = readLine()
    if (s == "y") {
        menu()
    }else{
        println("Kết thúc chương trình")
    }
}

fun xoaGiaoVien() {
    do {
        println("Xoá giáo viên theo Mã GV")
        print("Nhập mã GV: ")
        var msgv = readLine()
        var GVxoa = danhSachGV.find { it.msgv == msgv }
        if (GVxoa == null) {
            println("Mã GV không tồn tại")
        } else {
            danhSachGV.remove(GVxoa)
            println("Xoá thành công")
        }
        print("Xoá tiếp? (y/n): ")
        var tiepTuc = readLine()
        if (tiepTuc == "n") {
            println("Kết thúc chương trình")
        }
    }while (tiepTuc == "y")
    menu()
}

fun tinhLuong(){
    do {
        println("Tính lương giáo viên theo Mã GV")
        print("Nhập mã GV: ")
        var msgv = readLine()
        var GVtinh = danhSachGV.find { it.msgv == msgv }
        if (GVtinh == null) {
            println("Mã GV không tồn tại")
        } else {
            var luongThuc = GVtinh.luongCung + GVtinh.luongThuong - GVtinh.tienPhat
            println("Lương thực của giáo viên là: ${luongThuc}đ")
        }
        print("Tính tiếp? (y/n): ")
        var tiepTuc = readLine()
        if (tiepTuc == "n") {
            println("Kết thúc chương trình")
        }
    }while (tiepTuc == "y")
    menu()
}

fun menu() {
    println("Quản lý giáo viên")
    println("-------------------")
    println("1. Thêm giáo viên")
    println("2. Danh sách giáo viên")
    println("3. Xoá giáo viên")
    println("4. Tính lương")
    println("0. Thoát")
    println("-------------------")
    print("Lựa chọn: ")
    var s = readLine()
    when (s) {
        "1" -> themGV()
        "2" -> dsgv()
        "3" -> xoaGiaoVien()
        "4" -> tinhLuong()
        "0" -> {
            println("Kết thúc chương trình")
            exitProcess(0)
        }
        else -> {
            println("Lựa chọn không hợp lệ")
            menu()
        }
    }
}