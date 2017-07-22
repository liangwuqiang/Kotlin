/**
 * This example implements the famous "99 Bottles of Beer" program
 * 这个例子实现了著名的“99瓶啤酒”程序
 * See http://99-bottles-of-beer.net/
 *
 * The point is to print out a song with the following lyrics:
 * 该程序打印出一首抒情诗：
 *
 *     The "99 bottles of beer" song
 *     “99瓶啤酒”歌
 *
 *     99 bottles of beer on the wall, 99 bottles of beer.
 *     Take one down, pass it around, 98 bottles of beer on the wall.
 *
 *     98 bottles of beer on the wall, 98 bottles of beer.
 *     Take one down, pass it around, 97 bottles of beer on the wall.
 *
 *       ...
 *
 *     2 bottles of beer on the wall, 2 bottles of beer.
 *     Take one down, pass it around, 1 bottle of beer on the wall.
 *
 *     1 bottle of beer on the wall, 1 bottle of beer.
 *     Take one down, pass it around, no more bottles of beer on the wall.
 *
 *     No more bottles of beer on the wall, no more bottles of beer.
 *     Go to the store and buy some more, 99 bottles of beer on the wall.
 *
 * Additionally, you can pass the desired initial number of bottles to use (rather than 99)
 * 另外，你可以传递想要的初始瓶数来使用（而不是99瓶），
 * as a command-line argument
 * 作为命令行参数
 */
package bottles

fun main(args: Array<String>) {
    if (args.isEmpty) {   //检查参数是否为空，无参数时设置默认参数99
        printBottles(99)
    } else {
        try {
            printBottles(args[0].toInt())  //命令行参数转成整数，有可能不是数字，这里进行异常测试
        } catch (e: NumberFormatException) {  //异常情况是NumberFormatException
//            println("You have passed '${args[0]}' as a number of bottles, " +
//                    "but it is not a valid integer number")
            println("你传进来 ${args[0]} 作为瓶数，但它不是有效整数。")
        }
    }
}

fun printBottles(bottleCount: Int) {
    if (bottleCount <= 0) {
//        println("No bottles - no song")
        println("没有瓶子，也就没有歌")
        return
    }

    println("The \"${bottlesOfBeer(bottleCount)}\" song\n")

    var bottles = bottleCount
    while (bottles > 0) {
        val bottlesOfBeer = bottlesOfBeer(bottles)
        print("$bottlesOfBeer on the wall, $bottlesOfBeer.\nTake one down, pass it around, ")
        bottles--
        println("${bottlesOfBeer(bottles)} on the wall.\n")
    }
    println("No more bottles of beer on the wall, no more bottles of beer.\n" +
            "Go to the store and buy some more, ${bottlesOfBeer(bottleCount)} on the wall.")
}

fun bottlesOfBeer(count: Int): String =
        when (count) {
            0 -> "no more bottles"
            1 -> "1 bottle"
            else -> "$count bottles"
        } + " of beer"

/*
 * An excerpt from the Standard Library
 */


// This is an extension property, i.e. a property that is defined for the
// type Array<T>, but does not sit inside the class Array
val <T> Array<T>.isEmpty: Boolean get() = size == 0
