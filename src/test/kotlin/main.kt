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
}