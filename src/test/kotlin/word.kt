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
        val word = line.split("[", "]")
        arrayOfWord.add(Word(word[0], word[1], word[2]))
    }
    return arrayOfWord
}

fun dealWord(word: String): String {  //只处理一个单词
    val path = "/home/lwq/Desktop/Kotlin/src/test/kotlin/"
    val array = arrayOf("MyWord.dict", "NewWord.dict",
            "Collins5.dict", "Collins4.dict", "Collins3.dict")
    val flag = arrayOf(0)
    for (i in array.indices) {
        val dict = openDictFile(path + array[i])
        for (item in dict) {
            if (item.name.toLowerCase() == word.toLowerCase()) {
                flag[0] = 1
                return when(i) {
                    0 -> "<font color='black'>$word</font>"
                    1 -> "<font color='grey'>$word</font>"
                    2 -> "<font color='green'>$word</font>"
                    3 -> "<font color='blue'>$word</font>"
                    4 -> "<font color='red'>$word</font>"
                    else -> "<font color='orange'>$word</font>"
                }
            }
        }
    }
    if (flag[0] == 0) {
        return "<font color='orange'>$word</font>"
    }
    return ""
}

fun html() {
    val string1 = """
<!DOCTYPE html>
<html5>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
       用于测试单词的颜色显示
    </title>
</head>
<body>
<p>
    <font color="BLUE">这是一段示例用的代码</font>
"""
    val string2 = """
</p>
</body>
</html5>
"""
    val path = "/home/lwq/Desktop/Kotlin/src/test/kotlin/"
    var filename = "test.txt"
    val test = File(path + filename)
    var str = ""
    val array = arrayListOf<String>()
    array.add(string1)
    for (char in test.readText()) {
        if (char in 'A'..'z') {
            str += char.toString()
            continue
        }
        if (str != "") {
            array.add(dealWord(str))
            str = ""
        }
        array.add(char.toString())
    }
    array.add(string2)
    for (item in array) str += item
    println(str)
    filename = "test.html"

}
fun main(args: Array<String>) {
    html()
}
