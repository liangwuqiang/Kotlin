import java.io.File
import java.util.StringTokenizer

fun readFile() {
    val path = "/home/lwq/Desktop/Kotlin/src/test/kotlin/"
    val filename = "Collins5.dict"

    val file = File(path + filename)
    val contents = file.readLines()

//    StringTokenizer(contents, " ().:={}\"").toList()
//        .map { it.toString() }
//        .filter { it.length > 2 }
//        .map { it.toLowerCase() }
//        .sortedBy { it }
//        .filter { it.min().toString() >= "a" && it.max().toString() < "z" }
//        .forEach(::println)
    for (line in contents) {
        println( line.split('[',']')[0])
//            println(line)
    }
}

fun main(args: Array<String>) {
    readFile()
    val array=arrayListOf<String>()
    array.add("dsfsdf")
    array.add("dfsdfsdetwet34")
    array.add("fgdsuykjklf")
    println(array)
    var str1 = ""
    for (item in array) str1 += item
    println(str1)
    var flag =0
    for (item in array) {
        flag =1
    }
}