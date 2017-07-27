import java.io.File

/**
 * Created by lwq on 17-7-27.
 */
fun main(args: Array<String>) {
    val path = "/home/lwq/Desktop/Kotlin/src/test/kotlin/"
    val infile = File(path + "irregular.dict")
    val stringBuilder = StringBuilder()
    for (line in infile.readLines()){
        val name = line.split("[", "]")[0]
        val pronunciation = line.split("[", "]")[1]
        val annotation = line.split("[", "]")[2]
        if ("," in name) {
            for (item in name.split(",")){
                stringBuilder.append("$item[$pronunciation]$annotation\n")
            }
        } else {
            stringBuilder.append("$name[$pronunciation]$annotation\n")
        }
    }

    println(stringBuilder)
}