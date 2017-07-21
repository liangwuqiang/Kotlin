//要点：将函数组合在一起的方法，过滤条件是：字符串长度是偶数，泛型的转换，
/**
 * The composition function return a composition of two functions passed to it:
 * 组合函数返回的是 两个函数传递进去的组合：
 * compose(f, g) = f(g(*)).
 * Now, you can apply it to callable references.
 * 现在，你可以把它应用到 可调用的引用 中去。
 */

fun main(args: Array<String>) {
    val oddLength = compose(::isOdd, ::length)  //将函数组合在一起
    val strings = listOf("a", "ab", "abc")  //创建的字符串列表
    println(strings.filter(oddLength))  //将组合在一起的函数传给.filter进行过滤
}

fun isOdd(x: Int) = x % 2 != 0  //是否为偶数，返回布尔值
fun length(s: String) = s.length  //字符串长度，返回整形数

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {  //注意这泛型的转换
    return { x -> f(g(x)) }  //lambda表达式，将一个值传给组合的函数
}

//[a, abc]
