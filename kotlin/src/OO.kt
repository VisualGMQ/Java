package com.gmq.test

//类的申明和Java一致
//每一个类都有一个主构造函数，紧跟在类名后面（如果没有注解或者访问修饰符可以省略constructor关键字)
//标有open的类是可以被继承的，类默认是final的（不可被继承）
open class Person /*constructor可省略*/constructor(name:String, age:Int, height:Float){
    //和Java一样属性和变量分开定义
    //默认为public修饰
    var age:Int = 0
        //如果变量没有修饰符（是public的），你可以手动给出setter和getter方法
        get() = field    //你可以直接在变量声明后面给出get和set方法，通过get和set关键字,但是这个时候变量要被初始化
        set(value) { field = value } //setter的参数可以是任意名称，默认为value
    var name:String
        get() = field
        private set //你也可以直接用访问修饰符来允许/禁止getter或者setter
    private var height:Float
    //public变量默认实现getter和setter
    public var school:String = "AnHui university of no water and no electricity"    //你可以给变量初值

    //在init关键字后面实现主构造函数的函数体
    init {
        this.name = name
        this.age = age
        this.height = height
    }

    //对于private和protected函数，需要手动写setter和getter函数
    public fun getHeight() = height

    //类还可以有次构造函数，每一个次构造函数后面都必须用this关键字调用一次主构造函数
    constructor(school:String):this("VisualGMQ", 20, 175f){
        this.school = school
    }

    //加上open的方法和属性才能被重写
    open public fun message(){
        println("I am person")
    }
}

//采用和C++相似的继承方式。但是如果要调用父类的构造函数，需要在继承的时候就调用（默认调用无参构造函数）
class Student(name:String, age:Int, height: Float, issolo:Boolean): Person(name, age, height){
    var issolo:Boolean

    init{
        this.issolo = issolo
    }

    //重写的时候必须加上override关键字
    override fun message(){
        println("I am student")
    }
}

//如果类没有主构造函数，那么你必须在次构造函数中用super关键字来调用构造函数
class teacher:Person{
    var major:String
    constructor(school: String):super(school){
        major = "computer science"
    }

    override fun message(){
        //通过super关键字调用父类的实现
        super.message()
        println("I am a teacher")
    }
}

//你也可以声明一个接口
interface behavior{
    fun walk(){
        println("I can walk")
    }
}

//你也可以使用抽象类，抽象函数前面不需要加open
abstract class Biology{
    abstract fun borth()
}

fun main(){
    //直接通过类名加上括号来调用构造函数，没有new关键字
    var person:Person = Person("GMQValius", 18, 165f)
    person.school = "AnHui university of no water and no electricity"
    println(person.name)
    person.message()
    //person.name = "HAHA" invalid
}