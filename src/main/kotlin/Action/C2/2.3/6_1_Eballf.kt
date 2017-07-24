//使用if..else if.. 以提高程序的运行效率，连函数体都不需要了，直接使用表达式。这个表达式有点复杂。

package ch02.EvalIf

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
        if (e is Num) {
            e.value
        } else if (e is Sum) {
            eval(e.right) + eval(e.left)
        } else {
            throw IllegalArgumentException("Unknown expression")
        }

fun main(args: Array<String>) {
    println(eval(Sum(Num(1), Num(2))))
}
