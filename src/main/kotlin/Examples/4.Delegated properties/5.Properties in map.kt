//要点：通过 map 来给类成员传值，map的使用，
/**
 * Properties stored in a map.
 * 存储在 map 中的属性
 * This comes up a lot in applications like parsing JSON or doing other "dynamic" stuff.
 * 这在应用程序中很常见，就像解析 JSON 或者 做其它“动态”的素材。
 * Delegates take values from this map (by the string keys names of properties).
 * 代理从这个 map 中取值（通过属性名称的字符串做为关键字)
 * Of course, you can have var's as well,
 * 当然，你也可以使用变量实现，
 * that will modify the map upon assignment
 * 它会通过分派来修改 map，
 * (note that you'd need MutableMap instead of read-only Map).
 * (注意，你需要可变的Map，而不是只读Map）。
 */
package PropertiesInMap  //加包名是为了避免类名冲突

class User(val map: Map<String, Any?>) {
    //map作为构造函数的参数，用来给类属性赋值，有两个类属性，因此map有两个元素
    //为什么第二个元素定义为Any?，为什么不直接定义为Int或Int?呢？
    //在代理中不能使用Int
    val name: String by map
    val age: Int     by map
}

fun main(args: Array<String>) {
    val user = User(mapOf(  //注意map的创建，mapOf,arrayOf,arrayListOf
            "name" to "John Doe",
            "age"  to 25
    ))
    println("name = ${user.name}, age = ${user.age}")
//    foo()
}

//name = John Doe, age = 25

//-----------------------------以下是额外的内容
fun foo() {
    val array = arrayListOf<String>()  //:ArrayList<T>
    array.add("aaa")
    array.add("bbb")
    val array2 = arrayOf("aaa", "bbb")  //:Array<T>
    val map = mapOf("name" to "John Doe", "age" to 25)
    println(array)   //[aaa, bbb]
    println(array2)   //[Ljava.lang.String;@214c265e
    println(map)  //{name=John Doe, age=25}
    for (item in array) println(item)
    for (item in array2) println(item)
}