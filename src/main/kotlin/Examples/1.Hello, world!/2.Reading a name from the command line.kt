//要点：读取命令行参数
/**
 * println("Hello, ${args[0]}!")
 * Line 13 demonstrates string templates and array access.
 * 13行展示了 字符串模板 和 数组访问。
 * See this pages for details:
 * 详情参考以下网页：
 * http://kotlinlang.org/docs/reference/basic-types.html#strings
 * http://kotlinlang.org/docs/reference/basic-types.html#arrays
 */

fun main(args: Array<String>) {
//    if (args.size == 0) {   //IDE提示使用isEmpty
    if (args.isEmpty()) {
//        println("Please provide a name as a command-line argument")
        println("请在提供一个名字作为命令行参数")
        return
    }
    println("Hello, ${args[0]}!")
}

//Hello, guest!