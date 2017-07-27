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
//        } else {
//            println(line)
//            arrayOfWord.add(Word(line, "", ""))
        }
//        val word = line.split("[", "]")
    }
    return arrayOfWord
}

fun dealWord(word: String): String {  //只处理一个单词
    val homePath = "/home/lwq/Desktop/Kotlin/src/test/kotlin/"
    val dictPath = homePath + "dict/"
    val array = arrayOf("MyWords", "NewWords"  //我的词库，生词表
        , "A-Z", "irregular"                 //字母表，不规则动词
        ,"Collins5", "Collins4", "Collins3"  //柯林斯分频词库
    //  ,"Collins2", "Collins1.dict", "Collins0"
    )

    for (i in array.indices) {
        val dict = openDictFile(dictPath + array[i] +".dict")
        for (item in dict) {
            if (word.toLowerCase() == item.name.toLowerCase()
                || word.toLowerCase() == item.name.toLowerCase()+"s"  //复数
                || word.toLowerCase() == item.name.toLowerCase()+"d"  //过去式
                || word.toLowerCase() == item.name.toLowerCase()+"ed"  //过去式
                || word.toLowerCase() == item.name.toLowerCase()+"ing"  //进行时
//                || word.toLowerCase() == item.name.toLowerCase()+"er"
                || word.toLowerCase() == item.name.toLowerCase()+"\'s"
                || word.toLowerCase() == item.name.toLowerCase()+"\'d"
                || word.toLowerCase() == item.name.toLowerCase()+"\'ve"  //I 've never seen a cat
                ) {
                return when(array[i]) {
                    "MyWords" -> "<font color='green'>$word</font>"  //我的词库，已掌握
                    "NewWords" -> "<font color='orange'>$word</font>"  //生词表，未掌握
                    "A-Z" -> "<font color='orange'>$word</font>"  //字母表
                    "irregular" -> "<font color='orange'>$word</font>"  //不规则动词
                    "Collins5" -> "<font color='green'>$word</font>"  //5星
                    "Collins4" -> "<font color='blue'>$word</font>"  //4星
                    "Collins3" -> "<font color='red'>$word</font>"  //3星
//                    "Collins2" -> "<font color='violet'>$word</font>"  //2星
//                    "Collins1" -> "<font color='violet'>$word</font>"  //1星
//                    "Collins0" -> "<font color='violet'>$word</font>"  //0星
                    else -> "<font color='grey'>$word</font>"
                }
            }
        }
    }

    val unknownFile = File(homePath + "output/Unknown.dict")
    unknownFile.appendText("$word \n")
    return "<font color='grey'>$word</font>"
}

fun html() {
    val path = "/home/lwq/Desktop/Kotlin/src/test/kotlin/"
    val inputfile = File(path + "text/test.txt")
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
                <h1>说明：</h1>
                    <p><font color="GREEN">[绿色]常用</font></p>
                    <p><font color="BLUE">[蓝色]普通</font></p>
                    <p><font color="RED">[红色]不常用</font></p>
                    <p><font color="ORANGE">[橙色]不规则变化</font></p>
                    <p><font color="GREY">[灰色]没能识别</font></p>

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
    val outputfile = File(path + "output/test.html")
    outputfile.writeText(text.toString())
}
fun main(args: Array<String>) {
    html()
}
