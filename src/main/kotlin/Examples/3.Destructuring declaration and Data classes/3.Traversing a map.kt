//要点：map的构建，在map中遍历
/**
 *  Kotlin Standard Library provide component functions for Map.Entry
 *  Kotlin标准库中提供了部件函数 用于Map.Entry
 */

fun main(args: Array<String>) {
    val map = hashMapOf<String, Int>()  //产生一个map，为什么不用mapOf()呢？变长和固定长
    map.put("one", 1)
    map.put("two", 2)

    for ((key, value) in map) {  //遍历map，是不是有点解构的意思
        println("key = $key, value = $value")
    }
}

//key = one, value = 1
//key = two, value = 2

//例子4-5
//class User(val map: Map<String, Any?>) {
//    //map作为构造函数的参数，用来给类属性赋值，有两个类属性，因此map有两个元素
//    //为什么第二个元素定义为Any?，为什么不直接定义为Int或Int?呢？
//    //在代理中不能使用Int
//    val name: String by map
//    val age: Int     by map
//}