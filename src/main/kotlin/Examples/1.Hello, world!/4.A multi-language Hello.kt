//要点：if语句的返回值，when语句的用法
/**
 * In this example, `val` denotes a declaration of a read-only local variable,
 * 在这里例子中，`val`用于只读局部变量的声明，
 * that is assigned an pattern matching expression.
 * 它被赋值为 一个模式匹配表达式。
 * See http://kotlinlang.org/docs/reference/control-flow.html#when-expression
 */

fun main(args: Array<String>) {
    val language = if (args.size == 0) "EN" else args[0]  //处理无参数情况，并变量赋值

    println(when (language) {  //使用when语句过滤
        "EN" -> "Hello!"
        "FR" -> "Salut!"
        "IT" -> "Ciao!"
//        else -> "Sorry, I can't greet you in $language yet"
        else -> "抱歉, 我不会用 $language 语言来欢迎你"
    })
}

//Salut!