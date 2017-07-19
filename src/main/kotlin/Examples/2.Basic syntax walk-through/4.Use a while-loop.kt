//要点：while循环
/**
 * `while` and `do..while` work as usual.
 * `while` 和 `do..while` 像通常一样使用
 * See http://kotlinlang.org/docs/reference/control-flow.html#while-loops
 */
fun main(args: Array<String>) {
    var i = 0
    while (i < args.size)
        println(args[i++])
}

//guest1 guest2 guest3 guest4
//guest1
//guest2
//guest3
//guest4