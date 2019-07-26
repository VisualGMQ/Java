package com.gmq.test

//函数采用fun定义，函数的参数需要通过:指定类型，函数如果有返回值，需要在函数末尾用:指定返回值类型。没有返回值不用指定，默认返回Unit。
fun sum(a:Int, b:Int):Int{
    return a+b
}

//kotlin不允许传入null，除非你在参数类型后加上?来表示可以传入（包括返回值也是）,这被称为"null safty"
fun say(msg:String?){
    //验证是否为null
    if(msg == null)
        println("you have nothing to say")
    println(msg)
}

//kotlin支持局部函数，局部函数可以使用外围函数的变量
fun outer(v:Int){
    fun inner(){
        println("I am inner function, I can use v:$v")
    }
    inner()
}

//如果函数体只有一句话,那么可以直接在最后加上=来直接指定函数体和返回值，这叫做"单表达式函数",当返回值类型可以推断的时候可以不写返回值类型
//函数参数可以有默认值，而且不必放在最后
fun multi(a:Float=3f, b:Float) = a*b

//函数可以在前面加上<T>来使用范型(Java术语)或者模版(C++术语)，T代表任意的一种类型
//你也可以通过vararg来声明可变参数
fun <T> travel(vararg arr:T){
    for(i in arr)
        print(" $i")
    println()
}

//kotlin的函数可以作为参数
//函数有类型，通过()里面指定参数类型，通过->指定返回值类型。所有的函数参数必须满足这个类型（或者说是映射）
fun alg(a:Int, b:Int, algfunc:(x:Int, y:Int)->Int/*两个整型映射到整型的函数*/){
    println("function as parameter")
    println(algfunc(a, b))
}

/*
匿名函数，只能在一些函数作为参数的时候使用
fun(a:Int, b:Int):Int{
    return a+b
}
*/

fun main(){
    println("3+4=${sum(3,4)}")
    //当有默认值的参数在前面的时候，你可以通过指定其他参数的名称来赋值，从而跳过默认值参数
    println("3*4=${multi(b=4f)}")
    //会输出Kotlin.Unit表示没有返回值
    println(say("this is a message"))

    var elements = arrayOf("apple", "orange", "banana", "nihoutao")
    //传入可变参数
    travel(3,1,2,4,5);
    //如果你要传入数组的话，可以在数组前面加上*(伸展操作符)来传入
    travel("fruitstart", *elements, "fruitend")

    outer(3)

    //lambda表达式，kotlin支持函数式编程，函数可以是变量。lambda表达式通过{}扩起来，通过->连接参数和函数体
    var minus = {a:Int, b:Int -> a-b}
    println("4-3=${minus(4, 3)}")

    //通过lambda传入函数参数
    alg(4,5, {x:Int, y:Int -> x-y})
}