//要点：代理的observable()，数据是如何流动的？
//我的理解：首先要给observale()一个初始参数，observable本身包含两参数。另一个参数是handler(处理器)。
//handler(处理器) 包含三个参数。1.属性值的引用，2.observable()引入的原值，3.通过类的setter方法取得的新值。
//处理器将取得的三个参数 导出到一个println()函数中进行处理。
/**
 * The observable() function takes two arguments: initial value and a handler for modifications.
 * observable()函数需要提取两参数： 初始值 和 用于修改的 handler（处理者、管理员）。
 * The handler gets called every time we assign to `name`, it has three parameters:
 * handler的getter方法，每次调用都要要求指派 `name`， 它有三个参数：
 * a property being assigned to, the old value and the new one.
 * 一个被指定的属性，原值 和 新值。
 * If you want to be able to veto the assignment, use vetoable() instead of observable().
 * 如果你不想要这样的指派，就使用 vetoable() 替代 observable() 。
 */
package observableProperty  //加包名是为了避免类名冲突，自己额外添加的

import kotlin.properties.Delegates

class User {
    var name: String by Delegates.observable("no name") {
        d, old, new ->
        println("$old - $new")  //将变量传入到一个函数中去，lambda表达式
    }
}

fun main(args: Array<String>) {
    val user = User()
    user.name = "Carl"  //执行类的setter方法
}

//no name - Carl