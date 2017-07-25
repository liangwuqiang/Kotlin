import java.io.File
import java.util.StringTokenizer

fun readFile() {
    val path = "/home/lwq/Desktop/Kotlin/src/test/kotlin/"
    val filename = "mytext.txt"
    val file = File(path + filename)
    val contents = file.readText()

    StringTokenizer(contents, " ().:={}\"").toList()
        .map { it.toString() }
        .filter { it.length > 2 }
        .map { it.toLowerCase() }
        .sortedBy { it }
        .filter { it.min().toString() >= "a" && it.max().toString() < "z" }
        .forEach(::println)
}

fun main(args: Array<String>) {
    readFile()
}