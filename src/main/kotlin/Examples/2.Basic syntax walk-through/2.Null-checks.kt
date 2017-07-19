//要点：空值检查，异常处理try..catch..，异常事件 NumberFormatException
/**
 * A reference must be explicitly marked as nullable to be able hold a null.
 * 一个引用可以取空值的话，必须明确地标记为可空
 * See http://kotlinlang.org/docs/reference/null-safety.html#null-safety
 */
package multiplier

// Return null if str does not hold a number
// 如果str不是数字，就返回空值
fun parseInt(str: String): Int? {  //函数返回可空整数
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {  //异常处理 NumberFormatException
//        println("One of the arguments isn't Int")
        println("其中一个参数不是整数")
    }
    return null
}

fun main(args: Array<String>) {
    if (args.size < 2) {
//        println("No number supplied");
        println("需要提供数据")
    } else {
        val x = parseInt(args[0])  //调用函数进行数据处理
        val y = parseInt(args[1])

        // We cannot say 'x * y' now because they may hold nulls
        // 我们还不能 'x * y'，因为它们有可能是空值
        if (x != null && y != null) {
            print(x * y) // Now we can 现在可以了
        } else {
//            println("One of the arguments is null")
            println("其中一个参数是空值")
        }
    }
}

//参数：2 3
//6