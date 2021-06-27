/*
 ------------------------Notes-------------------------------------
 var -> mutable/non-final
 val -> immutable/final
 const val -> use const with val whenever we are sure the value of a variable will be fixed (assigned inline at the compile time)
 val/ const val -> Both values are defined as final, the only difference is that const val is declared as public while val is private (including a getter).
 Nothing? -> Nothing? is actually the type that captures only the null
 -----------------------RESOURCES:---------------------------------
 Functions: https://kotlinlang.org/docs/basic-syntax.html#functions
 Variables: https://kotlinlang.org/docs/basic-syntax.html#variables
 Null Safety: https://kotlinlang.org/docs/null-safety.html
*/

const val PI = 3.14519

fun main() {
//    varValConst()

//    nullable() // datatype?
//    nullCheck() // if(variable!=null)
//    safeCallOperator() // ?.
//    safeCallWithLet() // ?.let{}
//    elvisOperator() // ?:
//    notNullAssertionOperator() //!!.

//    safeCast() // as?
//    nullableCollection() // filterNotNull()
}

fun varValConst() {
    var num1 = "Sushil"
    num1 = "Sushil Jangra"
    println(num1)

    val num2 = "Sushil"
    // num2="value changed" // can not re-assign a val
    println(num2)

    println("constant : $PI")
}

fun nullable() {
    val name1: String?
    name1 = null
    println(name1) //null

    val name2: String?
    name2 = "Sushil"
    println(name2) // Sushil

    var name3 = null // by default it is inferred to Nothing?
//    name3="s"// Error
    print(name3)
}

fun nullCheck() {
    val name: String? = "Sushil"
    println(name)
    val result = if (name != null) name.length else "Jangra"
    println(result)
}

fun safeCallOperator() {
    var somename: String? = null
    println(somename?.length) // null
    somename = "Sushil"
    println(somename?.length) // 6
}

fun safeCallWithLet() {
    var name: String?
    name = "Sushil"
    name?.let {
        println("Length = ${it.length}. This is printing because name is not null")
        println("This is another statement if name is not null")
    }
    name = null
    name?.let {
        println("This will not be printed")
    }

    val myList = listOf("Sushil", null)
    for (i in myList) {
        i?.let {
            // if not null
            print(i.length)
        }
    }
}

fun elvisOperator() {
    val name: String? = null

//    if (name != null)
//        print(name.length)
//    else
//        print("this is else value")

    println(name?.length ?: "this is else value")

//    safeCall + Let + elvisOperator
    name?.let {
        print("this means name is not null ${name.length}")
    } ?: print("this means name is null")
}

fun notNullAssertionOperator() {
    var name: String? = null
    name = "Sushil"
    print(name!!.length)
    name = if (name != null) null else "Jangra" // to make the name null
    print(name!!.length) // will throw NPE
}

fun safeCast() {
    val name: String? = "Sushil"
//    val number: Int? = name as Int// class cast exception
    val number: Int? = name as? Int // can not cast string->int
    print(number)
}

fun nullableCollection() {
    // filtering the null values using filterNotNull
    val nullableList = listOf("hello", null, "world!").filterNotNull()
//    for (i in nullableList)
//        println(i?.length)
    for (i in nullableList)
        println("length of i = ${i.length}")
}