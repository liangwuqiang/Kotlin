//要点：学会lazy的使用
/**
 * Delegates.lazy() is a function that returns a delegate that implements a lazy property:
 * 代理。lazy()函数可以代理实现lazy（懒)属性：
 * the first call to get() executes the lambda expression passed to lazy() as an argument
 * get()方法的首次调用 是把lamda表达式作为参数传给lazy()
 * and remembers the result, subsequent calls to get() simply return the remembered result.
 * 并记住结果，随后调用的get()方法只是简单返回被记忆的结果。
 * If you want thread safety, use blockingLazy() instead:
 * 如果你想要线程安全，就使用 `blockingLazy()` 替代：
 * it guarantees that the values will be computed only in one thread,
 * 它保证了值只在一个线程中进行计算，
 * and that all threads will see the same value.
 * 那一种却是所有线程都能看到同样的值。
 */

class LazySample {  //无构造函数的类，属性需要初始化？？
    val lazy: String by lazy {
        //懒惰，延迟初始化，这整个是一条语句（分多行写）
        println("computed!")
        "my lazy"  //代码段的最后一个语句 是返回值
    }
}

fun main(args: Array<String>) {
    val sample = LazySample()
    println("lazy = ${sample.lazy}")  //第一次要有赋值过程，因为还没有结果
    println("lazy = ${sample.lazy}")  //第二次只要结果，不要过程
}

//computed!
//lazy = my lazy
//lazy = my lazy