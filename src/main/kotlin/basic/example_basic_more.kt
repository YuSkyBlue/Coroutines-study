package basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {

    launch {
        repeat(5) {i ->
            println("Coroutine A, $i")

        }
    }
    launch {
        repeat(5){i->
            println("Coroutine B, $i")

        }

    }
    println("Coroutine Outer")


}