/*
*------------------------------------------Notes-----------------------------------------------
* Lambda expressions and anonymous functions are function literals.
* Function literals are functions that are not declared but passed immediately as an expression.
*
* */
fun main() {
//    lambdaAsExpression() // var a = {}
//    callableReferenceOperator() // ::
//    simpleLambda()
//    simpleHighOrderFun()
//    callTypes()
//    lambdaPassing()
//    explicitAndImplicitParameterName()
//    lambdaReturn()
//    lambdaWithoutParameters()

//    withExtensionFunction()
//    underScoreNamedParameter()

//    anonymousFunction()
//    functionLiterals()
}

fun lambdaAsExpression() {
    val num = { a: Int, b: Int -> a + b }
    println(num(2, 5))
}

fun callableReferenceOperator() {
    //top-level, local, member, or extension function
    val list = listOf("name", "some")
    println(list.size)//2
    println(list::size.get())//2

    //top-level, member, or extension property
    val name = "Sushil"
    println(name::length.get())//6

    //constructor
//    val hello1 = Hello
    val hello1 = Hello("Sushil")
    println(hello1.name)
//    val hello2 = ::Hello
    val hello2 = ::Hello.invoke("some") // using invoke for parameter passing
    println(hello2.name)
}

class Hello(var name: String)

fun simpleLambda() {
//        val myLambda = { i: Int -> i + 1 } // return type Int is inferred
    val myLambda: (Int) -> Int = { i -> i + 1 }
    println(myLambda(10))//11
}

fun simpleHighOrderFun() {
    val someLambda: (Int, String) -> (String) = { someNum, someString -> "$someNum $someString" }

    //    val someLambda: Int.(String) -> String = { someString -> "$this $someString" }
    fun hoFun(myFun: (Int, String) -> String): String = myFun(1, "hello")
    println(hoFun(someLambda))
}

fun callTypes() {
    val someLambda: Int.(String) -> String = { someString -> "$this $someString" }
    println(someLambda(1, "Sushil")) // simple call
    println(someLambda.invoke(1, "Sushil")) // using invoke operator
    println(1.someLambda("Sushil")) // using extension-like call
}

fun lambdaPassing() {
    val myLambda = { a: Int, b: Int -> a + b }
    someFun("Sushil", myLambda)
    someFun("Sushil", { a: Int, b: Int -> a + b }) // passing lambda directly
    someFun("Sushil") { a: Int, b: Int -> a + b } // passing trailing lambdas (if lambda is the last expression)
}

fun someFun(name: String, myLambdaFunction: (Int, Int) -> Int) {
    print("name : $name,Calculation: 2+4=${myLambdaFunction(2, 4)}")
}

fun explicitAndImplicitParameterName() {
//        val someLambda: (Int) -> Unit = { a -> print(a.toString()) } // explicit name of parameter - a
    val someLambda: (Int) -> Unit = { print(it.toString()) } //implicit name if parameter - it (only 1 argument)
    someLambda(5)
}

fun lambdaReturn() {
    var mylist = (1..20).toList()
    println(mylist)

    // simple return
//    mylist = mylist.filter { it % 2 == 0 } // if it%2==0 returns the boolean value
//    println(mylist)

    // return last statement
//    mylist = mylist.filter {
//        val isEven = it % 2 == 0
//        isEven
//    }
//    println(mylist)

    // return using labeled return statement
    mylist = mylist.filter {
        val isEven = it % 2 == 0
//        return isEven // ERROR : this will return to the calling function not to the filter function
        return@filter isEven
    }
    print(mylist)
}

fun lambdaWithoutParameters() {
    val myLambda = { print("This is no argument lambda") }
    myLambda()
//    myLambda.invoke()
}

fun withExtensionFunction() {
    var numbers = (1..10).toList()
    val sum = numbers.customSum { it % 3 == 0 }
    println("Sum is $sum")

    numbers = numbers.filter { it % 3 == 0 }
    print("Sum of ${numbers.joinToString(",")} is $sum")
}

fun List<Int>.customSum(myFun: (Int) -> Boolean): Int {
    var sum = 0
    for (number in this)
        if (myFun(number))
            sum += number
    return sum
}

fun underScoreNamedParameter() {
    //unused parameter can be named as _
    val nameLambda: (String, String) -> Unit = { name, _ -> print(name) }
    nameLambda("Sushil", "MCA")
}

fun anonymousFunction() {
    var number = 0
    println(fun(name: String): Int {
        ++number // anonymous function can access values from outer scope called Closure
        return name.length
    }.invoke("Sushil"))
    println(number)
}

fun functionLiterals() {
    // here receiver object is passed in the fun and referenced as this
    // Similar to ExtensionFunctions
    val some: Int.(Int) -> Boolean = { n2 -> (this + n2) % 2 == 0 }
    print(7.some(5))
}