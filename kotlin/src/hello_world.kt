package com.gmq.test

import kotlin.reflect.typeOf

fun main(){
    //使用val定义常量，可以自动推断类型
    val PI = 3.14159
    //如果没有指定类型，小数默认为Double，如果想要指定Float，不仅需要给出类型，还需要在值后面加上f来表示是Float
    val e:Float = 2.71828f
    //用var来定义变量
    var name:String = "VisualGMQ"
    var age:Int = 18
    var height:Float = 170f //170 or 170.0 is invalid
    var empty = null    //空值(null不是Unit类型,Unit是只有一个值Unit的类型)
    /*
    kotlin之间的变量是不能隐式转换的，甚至Int到Long，Float到Double都不行，完完全全不能转换。
    但是运算之后会自动转换到大范围的类型
    var a:Float = 3.4f
    var b:Double = a
    var c:Int = 3
    var d:Long = c
    */
    println("hello world")
    //"字符串模版"，像Bash一样通过$来使用变量，或者通过${}来使用函数或者表达式
    println("my name is $name, and my age is $age, totle are ${age+height}");
}