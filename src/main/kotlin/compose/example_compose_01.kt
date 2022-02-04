package compose

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("The answer is : ${one+two}")
    }
    println("Complted in $time ms")
}


suspend fun doSomethingUsefulOne(): Int{
    println("dosometihngone")
    delay(1000L)
    return  13
}

suspend fun doSomethingUsefulTwo(): Int {
    println("dosometihngtwo")
    delay(1000L)
    return 29

}

