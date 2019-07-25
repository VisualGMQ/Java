package com.gmq.test

fun main(){
    for(i in 1..10)
        print(" $i")
    var list = listOf("Apple", "Orange", "Banana")
    //遍历数组
    for(i in list) {
        if(i == "Banana")
            print("My favorate:")
        println(i)
    }
    //遍历数组下标
    for(i in list.indices)
        println(list[i])
    //遍历数组下标和值（使用.withIndex()函数）
    for((i, v) in list.withIndex())
        println("$i:$v")
    //带有步长的向下递减
    for(i in 10 downTo 1 step 2)
        print(" $i")
    var i = 0
    while (i<10){
        print(i)
        i++
    }
    var x = 10
    //当when作为表达式用的时候，必须有else值（除非所有条件都覆盖了），并且会返回匹配的值。
    //当when作为判断用的时候（比如下面这样），可以没有else，并且一定返回Unit
    var ret = when(x){
        in 1..10-> println("x in 1..10")
        !in 1..10-> println("x not in 1..10")
        is Int-> println("x is Int")
        2->println("x=2")
        else->{
            println("no match")
        }
    }

    println(ret)
}