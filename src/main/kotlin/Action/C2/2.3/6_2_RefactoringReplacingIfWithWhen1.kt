//使用when语句来进一步优化程序结构 ,思路上有点绕，不是那么直观。多练习，以掌握它。

package ch02.ex3_6_2_RefactoringReplacingIfWithWhen1

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
        when (e) {
            is Num ->
                e.value
            is Sum ->
                eval(e.right) + eval(e.left)
            else ->
                throw IllegalArgumentException("Unknown expression")
        }

fun main(args: Array<String>) {
    println(eval(Sum(Num(1), Num(2))))
}
