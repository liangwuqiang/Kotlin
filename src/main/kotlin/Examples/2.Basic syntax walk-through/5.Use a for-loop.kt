//要点：for循环，数组属性indices
/**
 * For loop iterates through anything that provides an iterator.
 * `For`循环 通过可迭代对象 来进行迭代。
 * See http://kotlinlang.org/docs/reference/control-flow.html#for-loops
 */
fun main(args: Array<String>) {
    for (arg in args)
        println(arg)

    // or
    println()
    for (i in args.indices)  //使用数组的属性.indices
        println(args[i])
}

//guest1 guest2 guest3
//guest1
//guest2
//guest3
//
//guest1
//guest2
//guest3