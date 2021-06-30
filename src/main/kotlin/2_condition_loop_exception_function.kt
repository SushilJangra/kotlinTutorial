/*----------------------Notes-----------------------
===>Some return types
Void-> from java (wrapper of void in Java). can return only null or nothing
Unit-> only one value that is Unit object. Same as "void" in Java
Nothing-> no values.  If a function has return type Nothing, then it cannot return normally. It either has to throw an exception, or enter an infinite loop.
          USES : Unreachable Code warning
                 Throw in a conditional ternary operator
                 Throw in a method that has a meaningful return type (avoids 'Missing return statement' error like in java)

* is the spread Operator (unpacks an array into the list of values)

----------------------Resources---------------------
https://proandroiddev.com/kotlins-vararg-and-spread-operator-4200c07d65e1
https://medium.com/thoughts-overflow/kotlin-has-nothing-but-there-is-nothing-like-nothing-in-java-cab98e4f4d26
*/

fun main() {
//    println(square(12))// simple function
//    println(square(number = 20)) // named argument

//    defaultFun(10) // tag = SomeName
//    defaultFun(11, "Hello") // tag = Hello

//    myVararg("Sushil")
//    myVararg("Sushil", "Hello", "World")
//    myVararg(*arrayOf("name", "World")) // SpreadOperator *

//    unitReturn()
//    nothingReturn()
//    voidReturn()
//    nothingTernaryUse()

//    DemoClass().simpleCalling(1)// object.functionName(singleArgument)
//    DemoClass() infixNotationFun 1 // object functionName singleArgument

//    print(singleExpFunction("Sushil"))
//    localFunction()

//    println(nonGenericFunction("some", "name"))
//    println(nonGenericFunction(1,2)) // Error
//    println(genericFunction("hello", "world"))
//    println(genericFunction(1, 2))

//    ternaryIF(1,3)
//    myWhen()// switch
//    whenWithoutArg()

//    forLoop()
//    nothingType()

}

fun square(number: Int): Int {
    return number * number
}

fun defaultFun(number: Int, tag: String = "SomeName") {
    println("Number : $number, tag : $tag")
}

fun myVararg(vararg names: String) { // names->array
    for (i in names)
        println(i)
}

fun unitReturn(): Unit { // return type Unit (Optional)
    print("Some message")
}

fun nothingTernaryUse() {
    var name: String? = null
    name = name?.toUpperCase() ?: nothingReturn()
}

fun nothingReturn(): Nothing? {
    throw Exception()
//    nothingReturn()
}

fun voidReturn(): Void? {
    print("demo")
    return null
}

class DemoClass {
    fun simpleCalling(value: Int) {
        print("value $value")
    }

    infix fun infixNotationFun(value: Int) {
        print("value $value")
    }
}

fun singleExpFunction(name: String): String = name.toUpperCase()

fun localFunction() {
    // A local function can also access local variables of outer functions (the closure)
    fun makeItUpperCase(name: String): String {
        return name.toUpperCase()
    }

    val someName = "Sushil Jangra"
    print(makeItUpperCase(someName))
}

fun <T> genericFunction(vararg t: T): ArrayList<T> {
    val myList: ArrayList<T> = ArrayList()
    for (t in t.iterator()) {
        myList.add(t)
    }
    return myList
}

fun nonGenericFunction(vararg array: String): ArrayList<String> {
    val myList: ArrayList<String> = ArrayList()
    for (i in array.withIndex()) {
        myList.add(i.value)
    }
    return myList
}

fun ternaryIF(n1: Int, n2: Int): Int {
//    val max = if (n1 > n2) n1 else n2 // Simple
    val max: Int = if (n1 > n2) { // using blocks to use more statements
        print("n1 is greater")
        n1 // last value in block is returned
    } else {
        print("n2 is greater")
        n2
    }
    return max
}

fun myWhen() {
    val value = 12
    val num: String = when (value) {
        in 1..10 -> "This is small number"
        !in 13..19 -> "This is not mid number"
        15 -> {
            print("This is \"a\" ")
            "aa"// last line is the value to be returned
        }
        is Int -> "bb"
        else -> "abcabc"
    }
    print(num)
}

fun whenWithoutArg() {
    val n = 12
    fun isEven(n: Int): Boolean {
        return n % 2 == 0
    }

    val demo = when {
        isEven(n) -> "Even Number"
        else -> "Odd Number"
    }
    print(demo)

}

fun forLoop() {
    for (i in 1..4) {
        if (i == 2)
            continue
        print("$i ")
    }
    println()//---------
    for (i in 4 downTo 1) {
        if (i == 3)
            break
        print("$i ")
    }
    println()//---------
    for (i in 2..6 step 3)
        print("$i ")
    println()//---------

    val array = arrayOf("some", "name", "here")
    for (i in array.indices) {
        print("${array[i]} ")// i is index
    }
    println()//---------
    // withIndex-method-1
    for (i in array.withIndex()) {
        print("${array[i.index]} ")
    }
    println()//---------
    /// withIndex-method-2
    for ((index, value) in array.withIndex()) {
        print("$value ")
    }
}

fun nothingType() {
    val person = Person()
    val s: String = person.demo?.name ?: throw Exception("DEMO EXCEPTION")
//    val s = person.demo?.name ?: "some"
    println(s)
}

class Person {
    var demo: Demo? = Demo("SomeName")
}

class Demo(demo: String) {
    val value = "somename"
    var name: String? = null
}
