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

}

data class Word(val name: String, val pronunciation: String, val comment: String)

fun openFile(fullFilename: String): ArrayList<Word> {
    val file = File(fullFilename)
    val lines = file.readLines()
    val arrayOfWord = arrayListOf<Word>()
    for (line in lines) {
        var word = line.split("[", "]")
        arrayOfWord.add(Word(word[0], word[1], word[2]))
    }
    return arrayOfWord
}

fun dealWord(word: String): String {
    val path = "/home/lwq/Desktop/Kotlin/src/test/kotlin/"
    val array = arrayOf("MyVocabulary.dict", "NewWord.dict",
            "Collins5.dict", "Collins4.dict", "Collins3.dict")
    for (i in array.indices) {
        val dict = openFile(path + array[i])
//        println(dict)
        for (item in dict) {
            if (item.name == word) {
                return "${item.comment}"
            }
        }
    }
//    var filename = "Collins5.dict"
//        val collins5 = openFile(path +filename)
//    filename = "Collins4.dict"
//        val collins4 = openFile(path +filename)
//    filename = "Collins3.dict"
//        val collins3 = openFile(path +filename)

//    for (item in collins5) {
//        if (item.name == word) {
//            return "${item.comment}"
//        }
//    }
//    for (item in collins4) {
//        if (item.name == word) {
//            return "${item.comment}"
//        }
//    }
//    for (item in collins3) {
//        if (item.name == word) {
//            return "${item.comment}"
//        }
//    }
    return ""
}

fun main(args: Array<String>) {
    println(dealWord("unique"))
}
