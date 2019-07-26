package com.gmq.test

import java.util.*

fun main(){
    //Kotlin本身的输入是调用Java的输入流来完成的
    //这里因为in本身是kotlin的关键字，所以在和java冲突的时候我们需要加上``来转译
    var scaner = Scanner(System.`in`)
    println("please input your name and age")
    var name = scaner.next()
    var age = scaner.nextInt()
    println("my name is $name, and age is $age")
}