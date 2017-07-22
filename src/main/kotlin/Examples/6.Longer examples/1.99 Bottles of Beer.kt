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
//        printBottles(99)
        printBottles(3)
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

//    println("The \"${bottlesOfBeer(bottleCount)}\" song\n")
    println("\"${bottlesOfBeer(bottleCount)}\" 歌\n")

    var bottles = bottleCount  //初始化循环次数
    while (bottles > 0) {
        val bottlesOfBeer = bottlesOfBeer(bottles)  //取得需要显示的啤酒瓶数
//        print("$bottlesOfBeer on the wall, $bottlesOfBeer.\nTake one down, pass it around, ")
        print("$bottlesOfBeer 在墙上， $bottlesOfBeer.\n拿下来，传递一圈， ")
        bottles--
//        println("${bottlesOfBeer(bottles)} on the wall.\n")
        println("${bottlesOfBeer(bottles)} 在墙上。\n")
    }
//    println("No more bottles of beer on the wall, no more bottles of beer.\n" +
//            "Go to the store and buy some more, ${bottlesOfBeer(bottleCount)} on the wall.")
    println("墙上没有啤酒瓶了，没有啤酒瓶。去商店里买些，${bottlesOfBeer(bottleCount)}在墙上。")
}

fun bottlesOfBeer(count: Int): String =
        when (count) {
//            0 -> "no more bottles"
            0 -> "没有"
//            1 -> "1 bottle"
            1 -> "1 个"
//            else -> "$count bottles"
            else -> "$count 个"
//        } + " of beer"
        } + " 啤酒瓶"

/*
 * An excerpt from the Standard Library
 * 来自标准库的一个引用
 */


// This is an extension property, i.e. a property that is defined for the type Array<T>,
// 这是个扩展属性，例如，一个属性被定义为 Array<T> 类型，
// but does not sit inside the class Array
// 但是它不在 Array 类的内部
val <T> Array<T>.isEmpty: Boolean get() = size == 0  //根据数组是否有元素，返回布尔值
//val <T> Array<T>.isEmpty: Boolean get() = (size == 0)


//"3 个 啤酒瓶" 歌
//
//3 个 啤酒瓶 在墙上， 3 个 啤酒瓶.
//拿下来，传递一圈， 2 个 啤酒瓶 在墙上。
//
//2 个 啤酒瓶 在墙上， 2 个 啤酒瓶.
//拿下来，传递一圈， 1 个 啤酒瓶 在墙上。
//
//1 个 啤酒瓶 在墙上， 1 个 啤酒瓶.
//拿下来，传递一圈， 没有 啤酒瓶 在墙上。
//
//墙上没有啤酒瓶了，没有啤酒瓶。去商店里买些，3 个 啤酒瓶在墙上。