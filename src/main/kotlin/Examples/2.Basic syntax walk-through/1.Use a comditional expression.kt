//要点：if表达式，从命令行读取的字符创需要.toInt()，单行函数的定义
//简明扼要，不废话，去掉多余的东西
/**
 * `if` is an expression, i.e. it returns a value.
 * `if`是个表达式，例如，它能返回一个值。
 * Therefore there is no ternary operator (condition ? then : else),
 * 所以Kotlin中没有三元操作符 (condition ? then : else),
 * because ordinary `if` works fine in this role.
 * 因为普通的`if`能够很好地扮演这种角色。
 * See http://kotlinlang.org/docs/reference/control-flow.html#if-expression
 */
fun main(args: Array<String>) {
    println(max(args[0].toInt(), args[1].toInt()))
}

fun max(a: Int, b: Int) = if (a > b) a else b