//要点：`in`范围，范围的表示法1..5，分别用于条件判断和循环，
/**
 * Check if a number lies within a range.
 * 检查数值是否包含于范围中。
 * Check if a number is out of range.
 * 检查数值是否超出范围。
 * Check if a collection contains an object.
 * 检查集合是否包含特定对象。
 * See http://kotlinlang.org/docs/reference/ranges.html#ranges
 */

fun main(args: Array<String>) {
    val x = args[0].toInt()
    //Check if a number lies within a range:
    //检查数值是否包含在范围中：
    val y = 10
    if (x in 1..y - 1)
        println("OK")

    //Iterate over a range:
    //通过范围迭代：
    for (a in 1..5)
        print("${a} ")  //这里{}多余了

    //Check if a number is out of range:
    //检查数值是否超出范围：
    println()
    val array = arrayListOf<String>()  //创建数组arrayListOf
    array.add("aaa")  //使用数组类.add函数 添加元素
    array.add("bbb")
    array.add("ccc")

    if (x !in 0..array.size - 1)  //数组大小.size
//        println("Out: array has only ${array.size} elements. x = ${x}")
        println("超出: 数组只有 ${array.size} 个元素. x = ${x}")

    //Check if a collection contains an object:
    //检查集合是否包含特定对象：
    if ("aaa" in array) // collection.contains(obj) is called //collection.contains(obj)被调用
//        println("Yes: array contains aaa")
        println("是: 数组包含 aaa")

    if ("ddd" in array) // collection.contains(obj) is called
//        println("Yes: array contains ddd")
        println("是: 数组包含 ddd")
    else
//        println("No: array doesn't contains ddd")
        println("不: 数组不包含 ddd")
}

//4
//OK
//1 2 3 4 5
//超出: 数组只有 3 个元素. x = 4
//是: 数组包含 aaa
//不: 数组不包含 ddd