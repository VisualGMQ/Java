# Java快速入门（从C++到Java）

***
## Java和C++的小区别
* Java中表示空的关键字是`null`
* Java中所有变量，如果你使用了它但是没有给他赋初值的话，编译器会报错。也就是说java保证变量在使用之前一定初始化了。（你可以初始化为null来表示没有值）
* Java中所有可能抛出异常的操作你必须使用try,catch块将其包裹。但是C++不强制这样做。
* Java中的字符串是不能改变的，尽管这样做没有报错，但是字符串其实没有被改变：
    ```java
    String str = "123";
    str[2] = 'a';

    //str依然是"123"
    ```
* 基本数据类型不是类，但是Java为所有的基本数据类型创造了类(比如int-Integer)，这些类称为**闭包**。有时候函数让传递的是类而不是基本数据类型，要看清楚。
* ==符号比较的是对象的地址，`.equal()`函数比较的才是内容（重写了==或`.euqal()`的类除外）。
* Java很啰嗦。


***
## Java容器
和C++一样，Java有着自己的容器。但是Java的容器稍显复杂，我们先来看一下继承树：

![继承树1](./img/collections.png)
![继承树2](./img/map.png)
没错这里面其实能用的类没有几个，只有ArrayList（相当于C++中的vector），LinkedList（链表），HashSet（集合，不能存储重复的元素），TreeSet（红黑树）,HashMap（字典）, TreeMap（红黑树字典）, HashTable(哈希表)。
当然你可以通过向上转换的方式来实现其他的数据结构（或者容器），比如你可以这样写：

```java
Deque<Integer> deque = new LinkedList<Integer>();

Queue<Ineteger> queue = new LinkedList<Integer>();
```

这样你就可以使用队列和栈了。

所有的容器都是继承的Collection，它是所有容器的总接口。它又是继承的Iterable接口，Iterable接口让Collection有迭代功能。

### 容器差异
不同的容器使用方法不一样，比如ArrayList, HashSet和LinkedList使用`add()`方法加入数据，而HashMap则是`put()`方法。
其他差异见API文档咯。

### 容器的特性

* 所有的容器都自带有`toString`方法，你可以直接print它们。

* 所有的容器都是范型编程，你可以指定元素类型：
    ```java
    Collection<Integer> collection = new LinkedList<Integer>();
    ```
    或者不指定类型，这样的话类型默认为`Object`，你也可以理解为任意类型：
    ```java
    LinkedList ll = new LinkedList();
    ll.add((Float) 3.14f);
    ll.add((Integer) 5);
    ll.add((Boolean) false);
    ```

### 迭代器
和STL一样，每个容器都可以有迭代器：
```java
Iterator<Object> it = ll.iterator();
while (it.hasNext()) {
    System.out.println(it.toString());
    it.next();
}
```
容器通过`iterator()`方法返回其迭代器。

迭代器有如下常用的方法：

* hasNext()：用来判断是不是迭代到头了
* next()：跳到下一个元素（迭代器前进一步）
* remove()：删除当前元素
* toString()：输出数据的地址
* getClass()

注意迭代器不能输出当前元素，只能输出其地址（这一点和C++不一样）。

***
## Java目录操作
Java的目录操作很简单，只需要一个`File`类就可以了。
虽然叫做`File`，但是其实这个类并不是处理文件的，而是处理路径，文件夹的。也就是说他可以查看到文件的属性，但是不可以读写。

`File`类的构造函数中需要包含一个路径，可以是文件夹或者文件：
```java
File path = new File("./test/");
File path = new File("./test.txt");
```

你可以通过`exists()`来判断文件或者文件夹是否存在:
```java
if(path.exists())
```
如果不存在的话，可以创建:
```java
//is Directory:
path.mkdir();
path.mkdirs(); //if many directory in path

//is file:
path.createNewFile();
```
需要注意`createNewFile()`函数可能会抛出异常，需要try,catch。

如果是已经存在的文件或者文件夹，有一下常用方法：
* getName()：获得名称
* isDirectory()：判断是不是文件夹
* isFile()：判断是不是文件
* list()：如果是文件夹，会将文件夹下的所有文件和文件夹的名称作为String[]返回。
* canRead()/canWrite()：问价是否可读/可写
* length()：文件夹下文件/文件夹的个数
* getAbsolutePath()：获得绝对路径
* getPath()：获得路径，也就是你传入File构造函数的路径
* getParent()：获得当前文件/文件夹的父路径
* renameTo()：重命名
* delete()：删除

通过这些函数，我们可以写出一个递归遍历一个目录下的所有目录和文件的函数（见`DirOperator.java`中的`travleDir()`函数）

***
## Java输入输出操作
Java输入输出的类很多很多，首先还是来看一下继承图:

![继承树3](./img/io.jpg)

首先整个流分为字节流和字符流。所谓字符流，是读写都针对unicode编码的流。字节流就是针对字节读写的流了。这两种流都有对于文件和console的操作

首先我们来说字符流，字符流中对文件读写的一般都用`FileReader`和`FileWriter`。他们可以读写字符串。（例子请看IOOperator.java中的`readWriteFile()`函数）

针对console读写的类有`InputStreamReader`和`OutputStreamWriter`两个类。（具体例子见IOOperator.java的`readChar()`函数）

至于`BufferedReader`和`BufferedWriter`，顾名思义是带有缓冲的字节输入输出流。每次使用`read()`或者`write()`之后都必须使用`flush()`函数来强制将其输入到流中，方便大数据的一次性输入，节省时间。

当然，同理，字节流对文件的类是`FileOutputStream`和`FileInputStream`，以及缓冲的`BufferedInputStream`和`BufferedOutputStream`。它们的特点是只能对byte[]进行读写。一般可以用在二进制或者网络方面。

### 额外的类Scanner
Scanner是为控制台输入输出而定义的额外的类。因为`InputStreamReader`类每次只能读取一个char，所以我们有了Scanner类来对任意数据类型读取:
```java
Scanner scaner = new Scanner(System.in);
scaner.nextInt();       //读取int
scaner.next();          //读取String
scaner.nextBoolean();   //读取Boolean
```
scanner有一系列next方法可以针对不同的数据类型进行读取,很方便。