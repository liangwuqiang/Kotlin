//要点：通过初始化函数给类属性赋初值
/**
 * Users frequently ask what to do when you have a non-null var,
 * 用户们经常会问，当你有一个非空变量时 该怎样去做，
 * but you don't have an appropriate value to assign to it in constructor
 * 但是你在构造函数中 又没有恰当的值可以指定给它
 * (i.e. it must be assigned later)?
 * （例如，它必须晚点再指定）？
 * You can't have an uninitialized non-abstract property in Kotlin.
 * 在 Kotlin 中，你不能拥有一个没出初始化的非抽象属性。
 * You could initialize it with null,
 * 你可以把它初始化为空，
 * but then you'd have to check every time you access it.
 * 但是你不得不在每次访问它的时候进行检查。
 * Now you have a delegate to handle this.
 * 现在你使用代理来处理这样的事情。
 * If you read from this property before writing to it,
 * 如果你在给它赋值之前，读取这个属性的话，
 * it throws an exception,
 * 它会抛出一个异常，
 * after the first assignment it works as expected.
 * 当首次给它指定值之后，它就能正常工作了。
 */
package notNullProperty  //加包名是为了避免类名冲突

import kotlin.properties.Delegates

class User {
    var name: String by Delegates.notNull()
    //属性没有赋初值
    //默认的构造函数内有给属性赋值。
    fun init(name: String) {  //初始化函数，用于给属性赋值
        this.name = name
    }
}

fun main(args: Array<String>) {
    val user = User()
    // user.name -> IllegalStateException  如果此时取值的话，非法状态表达式
    user.init("Carl")  //通过初始化函数给类属性赋初值
    println(user.name)
}

//Carl