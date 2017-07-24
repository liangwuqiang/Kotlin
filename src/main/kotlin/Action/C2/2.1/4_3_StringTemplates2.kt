//合并语句 if表达式，有返回值

package ch02.ex1_4_3_StringTemplates2

fun main(args: Array<String>) {
    println("Hello, ${if (args.size > 0) args[0] else "someone"}!")
}
