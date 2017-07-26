/**
 * This is an example of a Type-Safe Groovy-style Builder
 * 这是个 类型安全 Groovy风格 建造器 的例子
 * Builders are good for declaratively describing data in your code.
 * 建造器有利于在你的代码中声明描述数据。
 * In this example we show how to describe an HTML page in Kotlin.
 * 在这个例子中， 我们演示了 怎样在Kotlin中描述 HTML页面。
 * See this page for details:
 * 详见以下网页：
 * http://kotlinlang.org/docs/reference/type-safe-builders.html
 */
package html

fun main(args: Array<String>) {
    val result =
            html {
                head {
//                    title { +"XML encoding with Kotlin" }
                    title { +"使用Kotlin进行XML编码" }
                }
                body {
//                    h1 { +"XML encoding with Kotlin" }
                    h1 { +"使用Kotlin进行XML编码" }
                    p { +"这个格式化可以用作 可替换的XML标识" }

                    // an element with attributes and text content
                    // 一个具有属性和文本内容的 元素
                    a(href = "http://jetbrains.com/kotlin") { +"Kotlin" }

                    // mixed content
                    // 固定的内容
                    p {
//                        +"This is some"
                        +"这是一些"
//                        b { +"mixed" }
                        b { +"固定的" }
//                        +"text. For more see the"
                        +"文本。详见"
                        a(href = "http://jetbrains.com/kotlin") { +"Kotlin" }
//                        +"project"
                        +"工程"
                    }
//                    p { +"some text" }
                    p { +"其它一些文本" }

                    // content generated from command-line arguments
                    // 从命令行参数中 产生的内容
                    p {
//                        +"Command line arguments were:"
                        +"命令行参数是："
                        ul {
                            for (arg in args)
                                li { +arg }
                        }
                    }
                }
            }
    println(result)
}

interface Element {
    fun render(builder: StringBuilder, indent: String)  //着色，建造器，意图
}

class TextElement(val text: String) : Element {
    override fun render(builder: StringBuilder, indent: String) {  //复写父接口函数
        builder.append("$indent$text\n")  //附加上 意图和传入的文本
    }
}

abstract class Tag(val name: String) : Element {  //抽象类 标签
    val children = arrayListOf<Element>()  //子类 元素数组
    val attributes = hashMapOf<String, String>()  //属性 Map

    protected fun <T : Element> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        children.add(tag)
        return tag
    }

    override fun render(builder: StringBuilder, indent: String) {  //复写render()方法
        builder.append("$indent<$name${renderAttributes()}>\n")
        for (c in children) {
            c.render(builder, indent + "  ")
        }
        builder.append("$indent</$name>\n")
    }

    private fun renderAttributes(): String? {
        val builder = StringBuilder()
        for (a in attributes.keys) {
            builder.append(" $a=\"${attributes[a]}\"")
        }
        return builder.toString()
    }


    override fun toString(): String {  //复写toString()方法
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}

abstract class TagWithText(name: String) : Tag(name) {
    operator fun String.unaryPlus() {
        children.add(TextElement(this))
    }
}

class HTML() : TagWithText("html") {
    fun head(init: Head.() -> Unit) = initTag(Head(), init)

    fun body(init: Body.() -> Unit) = initTag(Body(), init)
}

class Head() : TagWithText("head") {
    fun title(init: Title.() -> Unit) = initTag(Title(), init)
}

class Title() : TagWithText("title")

abstract class BodyTag(name: String) : TagWithText(name) {
    fun b(init: B.() -> Unit) = initTag(B(), init)
    fun p(init: P.() -> Unit) = initTag(P(), init)
    fun h1(init: H1.() -> Unit) = initTag(H1(), init)
    fun ul(init: UL.() -> Unit) = initTag(UL(), init)
    fun a(href: String, init: A.() -> Unit) {
        val a = initTag(A(), init)
        a.href = href
    }
}

class Body() : BodyTag("body")
class UL() : BodyTag("ul") {
    fun li(init: LI.() -> Unit) = initTag(LI(), init)
}

class B() : BodyTag("b")
class LI() : BodyTag("li")
class P() : BodyTag("p")
class H1() : BodyTag("h1")

class A() : BodyTag("a") {
    public var href: String
        get() = attributes["href"]!!
        set(value) {
            attributes["href"] = value
        }
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}
