//要点：is检查，类型判断
/**
 * The `is` operator checks if an expression is an instance of a type and more.
 * `is`操作符检查一个表达式是否是一种或多种类型的实例。
 * If we is-checked an immutable local variable or property,
 * 如果我们用`is`检查的是一个不变的 局部变量 或 属性，
 * there's no need to cast it explicitly to the is-checked type.
 * 就不需要明确地对它使用 `is`进行类型检查。
 * See this pages for details:
 * 详见以下网页：
 * http://kotlinlang.org/docs/reference/classes.html#classes-and-inheritance
 * http://kotlinlang.org/docs/reference/typecasts.html#smart-casts
 */
fun main(args: Array<String>) {
    println(getStringLength("aaa"))
    println(getStringLength(1))
}

fun getStringLength(obj: Any): Int? {  //参数类型 Any，任何类型
    if (obj is String)  //类型判断
        return obj.length // no cast to String is needed //String不需要`is`检查
    return null
}

//3
//null