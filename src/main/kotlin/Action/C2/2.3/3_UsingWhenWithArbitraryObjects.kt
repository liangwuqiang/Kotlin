//混色，颜色组合

package ch02.ex3_3_UsingWhenWithArbitraryObjects

import ch02.colors.Color
import ch02.colors.Color.*

fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {  //setOf()组合两个元素
            setOf(RED, YELLOW) -> ORANGE
            setOf(YELLOW, BLUE) -> GREEN
            setOf(BLUE, VIOLET) -> INDIGO
            else -> throw Exception("Dirty color")  //抛出异常，不在定义的范围
        }

fun main(args: Array<String>) {
    println(mix(BLUE, YELLOW))
}
