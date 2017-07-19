//要点：逐个读取命令行的多个参数
/**
 * Line 2 demonstrates the for-loop, that would have been called "enhanced"
 * 行2展示了for循环，它被称之为“高级版”
 * if there were any other for-loop in Kotlin.
 * 如果Kotlin中还有其它的for循环的话。
 * See http://kotlinlang.org/docs/reference/basic-syntax.html#using-a-for-loop
 */

fun main(args: Array<String>) {
    for (name in args)
        println("Hello, $name!")
}

//Hello, guest1!
//Hello, guest2!
//Hello, guest3!