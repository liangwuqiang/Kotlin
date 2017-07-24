//导入类

package ch02.ex3_2_3_UsingWhenToDealWithEnumClasses2

import ch02.colors.Color  //使用的类
import ch02.colors.Color.*  //使用类下的成员

fun getWarmth(color: Color) = when(color) {
    RED, ORANGE, YELLOW -> "warm"
    GREEN -> "neutral"
    BLUE, INDIGO, VIOLET -> "cold"
}

fun main(args: Array<String>) {
    println(getWarmth(Color.ORANGE))
}
