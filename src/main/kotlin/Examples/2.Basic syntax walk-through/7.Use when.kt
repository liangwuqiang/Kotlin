//要点：when语句
/**
 * See http://kotlinlang.org/docs/reference/control-flow.html#when-expression
 */

fun main(args: Array<String>) {
    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")
}

fun cases(obj: Any) {  //传入参数为Any
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}

class MyClass() {
}

//Greeting
//One
//Long
//Not a string
//Unknown