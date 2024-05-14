package com.phwnam.lab3.bai7

class Nguoi ( var hoTen : String, var tuoi: Int, var queQuan: String, )

class GiaoVien ( var nguoi: Nguoi,var msgv: String, var luongCung: Float, var luongThuong: Float, var tienPhat: Float) {
    fun hienThiThongTin(): String {
        return "================\nTên: ${nguoi.hoTen}, Tuổi: ${nguoi.tuoi}, Quê quán: ${nguoi.queQuan}, MSGV: $msgv,\n" +
                "Lương cứng: ${luongCung}đ, Lương thưởng: ${luongThuong}đ, Tiền phạt: ${tienPhat}đ"
    }
}
