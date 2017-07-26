package word

import java.io.File

enum class Color(val red: Int, val green: Int, val blue: Int) {
    //颜色对照表 http://www.917118.com/tool/color_3.html
    WHITE(255, 255, 255),  //白色  背景色
    BLACK(0, 0, 0),  //黑色  用于自己的词库，正常色
    GREEN(0, 139, 0),  //green4 绿色  柯林斯5星
    BLUE(0, 0, 205),  //blue3 蓝色  柯林斯4星
    RED(205, 0 , 0),  //Red3 红色  柯林斯3星
    GREY(105, 105, 105),  //灰色  超出范围的词
    VIOLET(238, 130, 238),  //violet 紫色  备用
    ORANGE(238, 154, 0),  //Orange2 橙色  备用
    CYAN(0, 205, 205);  //Cyan3 青色  备用

    fun getColor() = (red * 255 + green) *255 + blue

}

data class Word(val name: String, val pronunciation: String, val comment: String)

fun openDictFile(fullFilename: String): ArrayList<Word> {
    val file = File(fullFilename)
    val lines = file.readLines()
    val arrayOfWord = arrayListOf<Word>()
    for (line in lines) {
        if ("[" in line && "]" in line) {
            val word = line.split("[", "]")
            arrayOfWord.add(Word(word[0], word[1], word[2]))
        } else {
//            println(line)
            arrayOfWord.add(Word(line, "", ""))
        }
//        val word = line.split("[", "]")
    }
    return arrayOfWord
}

fun dealWord(word: String): String {  //只处理一个单词
    val path = "/home/lwq/Desktop/Kotlin/src/test/kotlin/"
    val array = arrayOf("MyWord.dict", "NewWord.dict"
            ,"Collins5.dict", "Collins4.dict", "Collins3.dict"
    //        ,"Collins2.dict", "Collins1.dict", "Collins0.dict"
    )

    for (i in array.indices) {
        val dict = openDictFile(path + array[i])
        for (item in dict) {
            if (word.toLowerCase() == item.name.toLowerCase()
                || word.toLowerCase() == item.name.toLowerCase()+"s"
                || word.toLowerCase() == item.name.toLowerCase()+"d"
                || word.toLowerCase() == item.name.toLowerCase()+"ed"
                || word.toLowerCase() == item.name.toLowerCase()+"ing"
                || word.toLowerCase() == item.name.toLowerCase()+"er"
                || word.toLowerCase() == item.name.toLowerCase()+"\'s"
                || word.toLowerCase() == item.name.toLowerCase()+"\'d"
                || word.toLowerCase() == item.name.toLowerCase()+"\'ve"  //I 've never seen a cat
                ) {
                return when(i) {
                    0 -> "<font color='green'>$word</font>"  //熟词
                    1 -> "<font color='orange'>$word</font>"  //生词
                    2 -> "<font color='green'>$word</font>"  //5星
                    3 -> "<font color='blue'>$word</font>"  //4星
                    4 -> "<font color='red'>$word</font>"  //3星
                    5 -> "<font color='violet'>$word</font>"  //2星
                    6 -> "<font color='violet'>$word</font>"  //1星
                    7 -> "<font color='violet'>$word</font>"  //0星
                    else -> "<font color='grey'>$word</font>"
                }
            }
        }
    }

    val unknownFile = File(path + "Unknown.dict")
    unknownFile.appendText("$word \n")
    return "<font color='grey'>$word</font>"
}

fun html() {
    val path = "/home/lwq/Desktop/Kotlin/src/test/kotlin/"
    val inputfile = File(path + "test.txt")
    val word = StringBuilder()
    val text = StringBuilder()
    //文档开头部分
    text.append("""
        <!DOCTYPE html>
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>单词分级颜色显示</title>
            </head>
            <body>
                <p> <font color="BLUE">这是一段示例用的代码</font> </p>
                <p>
    """)
    for (line in inputfile.readLines()) {
        for (char in line) {
            if (char in 'A'..'Z' ||char in 'a'..'z' ||char == '\'') {
                word.append(char.toString())
                continue
            }
            if (word.toString() != "") {
    //            println(dealWord(word.toString()))
                text.append(dealWord(word.toString()))
                word.delete(0, word.length)
            }
            text.append(char.toString())
        }
        text.append("</p> <P>")
    }
    //文档结尾部分
    text.append("""
                </p>
            </body>
        </html>
    """)
//    println(text)
    val outputfile = File(path + "test.html")
    outputfile.writeText(text.toString())
}
fun main(args: Array<String>) {
    html()
}
