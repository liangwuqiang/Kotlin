//接口的使用，根据表达式所属类来执行相应的语句，因为继承了相同的接口，所以可以进行比较，筛选

package ch02.ex3_5_SmartCastsCombiningTypeChecksAndCasts

interface Expr   //定义了一个接口，没有本体定义
class Num(val value: Int) : Expr  //继承接口的Num类
class Sum(val left: Expr, val right: Expr) : Expr  //继承接口的Sum类

fun eval(e: Expr): Int {
    if (e is Num) {  //1.如果e只是个数值
        val n = e as Num
        return n.value  //是否可以直接返回e.value，去掉中间变量
    }
    if (e is Sum) {   //2.如果e是求和的表达式
        return eval(e.right) + eval(e.left)  //这是个递归调用
    }
    throw IllegalArgumentException("Unknown expression")  //3.抛出异常
}

fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}
