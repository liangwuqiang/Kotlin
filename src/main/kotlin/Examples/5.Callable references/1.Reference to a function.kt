//要点：对列表中的元素进行过滤.filter(::方法)
/**
 * "Callable References" or "Feature Literals",
 * “可调用的引用” 或者 “特征化字面量”
 * i.e. an ability to pass named functions or properties as values.
 * 例如：一种将命名函数或者属性 作为值 来传递的能力。
 * Users often ask "I have a foo() function, how do I pass it as an argument?".
 * 用户们常问：“我有个foo()函数，我怎么把它作为参数来传递呢？”。
 * The answer is: "you prefix it with a `::`".
 * 回答是：“你在它前面加 `::` ”。
 */
package referenceToAFunction  //额外添加，以避免同名函数的冲突

fun main(args: Array<String>) {
    val numbers = listOf(1, 2, 3)  //产生一个列表
//    println(numbers)
    println(numbers.filter(::isOdd))  //对列表元素进行过滤，直接将函数传给filter
}

fun isOdd(x: Int) = x % 2 != 0  //是否为偶数，返回布尔值


//[1, 2, 3]
//[1, 3]