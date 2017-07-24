//类属性的定义， val属性 get函数 ,返回的布尔值

package ch02.ex2_2_CustomAccessors

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun main(args: Array<String>) {
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
}
