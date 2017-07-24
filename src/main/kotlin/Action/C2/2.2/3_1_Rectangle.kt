//随机数的使用 , nextInt()产生不同的随机数
//怎样控制随机数的范围

package geometry.shapes

import java.util.Random

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    val a = random.nextInt()
    val b = random.nextInt()
    println(a)
    println(b)
    return Rectangle(a, b)

}

fun main(args: Array<String>) {
    val myRectangle = createRandomRectangle()
    println("${myRectangle.height}, ${myRectangle.width}")
}


//621808093
//1346091491
//621808093, 1346091491