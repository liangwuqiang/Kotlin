//跟中函数执行的先后循序

package ch02.ex3_7_BlocksAsBranchesOfIfAndWhen

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun evalWithLogging(e: Expr): Int =
        when (e) {
            is Num -> {
                println("num: ${e.value}")
                e.value
            }
            is Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                println("sum: $left + $right")
                left + right   //最后的表达式是该语句块的返回值
            }
            else -> throw IllegalArgumentException("Unknown expression")
        }

fun main(args: Array<String>) {
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}

//num: 1
//num: 2
//sum: 1 + 2
//num: 4
//sum: 3 + 4
//7