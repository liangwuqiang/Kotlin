//要点：自定义代理的方法，属性的get和set，注意传递的参数。
/**
 * There's some new syntax: you can say `val 'property name': 'Type' by 'expression'`.
 * 有些新的语法：你可以这样表达 `val 属性名: 类型为 by表达式`。
 * The expression after by is the delegate,
 * by之后的表达式是个代理，
 * because get() and set() methods corresponding to the property will be delegated to it.
 * 因为响应属性的get()和set()方法，将在这里面代理。
 * Property delegates don't have to implement any interface,
 * 属性代理可以不实现任何其它接口，
 * but they have to provide methods named getValue() and setValue() to be called.</p>
 * 但是它们必须提供被调用的getValue()和setValue()方法。
 */

import kotlin.reflect.KProperty

class Example {
    var p: String by Delegate() //通过代理来赋值

    override fun
            toString() = "Example Class" //复写toString()函数
}

class Delegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        //注意这两个参数类型，Any? KProperty<*>，分别对应类和属性。
//        return "$thisRef, thank you for delegating '${prop.name}' to me!"
        return "$thisRef, 感谢你给我代理了 '${prop.name}' !"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
//        println("$value has been assigned to ${prop.name} in $thisRef")
        println("$value 被指定到 ${prop.name} ，在 $thisRef 中")
    }
}

fun main(args: Array<String>) {
    val e = Example()
    println(e.p)  //取值，getValue()返回字符串
    e.p = "NEW"  //赋值，setValue()，有打印输出语句
}

//Example Class, 感谢你给我代理了 'p' !
//NEW 被指定到 p ，在 Example Class 中
