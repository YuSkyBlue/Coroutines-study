package  compose

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(){
    val time= measureTimeMillis {
        val one = somethingUsefulOneAsync()
        val two = somethingUsefulTwoeAsync()
        runBlocking {
            println("The answer is ${one.await()+ two.await()}")
        }
    }
    println("Completed in $time ms")
}

fun somethingUsefulTwoeAsync() = GlobalScope.async { doSomethingUsefulOne3() }

fun somethingUsefulOneAsync() = GlobalScope.async { doSomethingUsefulOne3() }

suspend fun doSomethingUsefulOne3(): Int{
    println("dosometihngone")
    delay(1000L)
    return  13
}

suspend fun doSomethingUsefulTwo3(): Int {
    println("dosometihngtwo")
    delay(1000L)
    return 29

}