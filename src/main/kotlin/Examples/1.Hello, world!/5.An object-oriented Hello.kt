//要点：类的简单定义及其使用
/**
 * Here we have a class with a primary constructor and a member function.
 * 这里是一个具有主构造函数和成员函数的类。
 * Note that there's no `new` keyword used to create an object.
 * 注意，创建对象没有使用`new`关键字
 * See http://kotlinlang.org/docs/reference/classes.html#classes
 */

class Greeter(val name: String) {  //类属性的定义，类函数的定义
    fun greet() {
        println("Hello, ${name}");  //多余的分号
    }
}

fun main(args: Array<String>) {
    Greeter(args[0]).greet()  //前面部分是类的实例化，后面是使用类函数
}

//Hello, guest1