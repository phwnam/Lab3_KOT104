package com.phwnam.lab3

class Trenlop {
}
fun main() {
    val soA = 5
    val soB = 10

    var tinhTong2 = {soA : Int , soB : Int ->
        val a = 10
        val b = 5
        val c = a + b
        (soA + soB)
    }

    println("Cách 1: Tổng 2 số là: ${tinhTong(soA, soB)}")
    println("Cách 2: Tổng 2 số là: ${tinhTong2(soA, soB)}")

    val chiaDoi = {soA: Float -> soA / 2}

    val nhanDoi : (Int) -> Int = {it * 2}

    println("Nhân đôi 5: ${nhanDoi(5)}")
    println("Chia đôi 5: ${chiaDoi(5f)}")

    //Scope function

    val a = 5
    val nhanDoi2 = a.let{
        it * 2
    }

    println("Nhân đôi số $a = ${nhanDoi2}")

    val str = "hehehehehe"
    println("Độ dài chuỗi $str là: ${getStringLength(str)}")


    val tenSV = "nguyen van long"
    val tenInHoa = with(tenSV){
        tenSV.toUpperCase()
    }
    println(tenInHoa)

    val xe1 = CarModel("Xe 1", 5000f)
    println(xe1)
    xe1.apply {
        tenXe = "Xe 1 ban moi 2024"
        giaXe = 550f
    }
    println(xe1)
}


fun tinhTong( soA : Int, soB : Int) : Int {
    return (soA + soB)
}



fun getStringLength (str: String?) : Int? {
    return str?.run{
        if (isEmpty())
            return 0
        length
    }
}
