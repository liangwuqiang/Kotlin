//要点：多泛型的使用，解构声明的用法
/**
 * This example introduces a concept that we call destructuring declarations.
 * 这个例子介绍了一个概念，我们称之为解构声明。
 * It creates multiple variable at once.
 * 它同时创建多个变量。
 * Anything can be on the right-hand side of a destructuring declaration,
 * 解构声明的右边可以是任何对象,
 * as long as the required number of component functions can be called on it.
 * 该对象可以调用所需数量的部件函数。
 * See http://kotlinlang.org/docs/reference/multi-declarations.html#multi-declarations
 */

fun main(args: Array<String>) {
    val pair = Pair(1, "one")  //调用构造函数 将类实例化

    val (num, name) = pair  //解构赋值，逐一对应类中的各个部件

    println("num = $num, name = $name")
}

class Pair <K, V> (val first: K, val second: V) { //类使用了两种泛型
    operator fun component1(): String {
        return first.toString()
    }

    operator fun component2(): V {
        return second
    }
}

//num = 1, name = one
