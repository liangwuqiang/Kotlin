//要点：数据类，通过函数实例化数据类，
/**
 *  Data class gets component functions,
 *  数据类 获得的（特有的） 部件函数，
 *  one for each property declared in the primary constructor, generated automatically,
 *  在主构造函数中的每一个属性声明，自动产生部件函数，
 *  same for all the other goodies common for data:
 *  对数据类来说，和其它类中好用的普通的函数相同  //goodies commen??
 *  toString(), equals(), hashCode() and copy().
 *  See http://kotlinlang.org/docs/reference/data-classes.html#data-classes
 */
package dataClasses  //额外添加，避免类名冲突

data class User(val name: String, val id: Int)  //数据类的定义

fun getUser(): User {  //通过一个函数来实例化数据类
    return User("Alex", 1)  //返回类实例，和类的直接实例化有什么区别吗？
}

fun main(args: Array<String>) {
    val user = getUser()
    println("name = ${user.name}, id = ${user.id}")

    // or

    val (name, id) = getUser()  //解构赋值法
    println("name = $name, id = $id")

    // or

    println("name = ${getUser().component1()}, id = ${getUser().component2()}")
    //类中是不是默认就有部件的定义？

    //额外添加的内容
//    val user2 = User("Tom", 2)
//    println("name = ${user2.name}, id = ${user2.id}")
//    println(user2.component1())
//    println(user2.component2())
}

//name = Alex, id = 1
//name = Alex, id = 1
//name = Alex, id = 1
//name = Tom, id = 2
//Tom
//2