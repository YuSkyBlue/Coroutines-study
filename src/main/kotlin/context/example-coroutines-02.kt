package context

import kotlinx.coroutines.*

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() = runBlocking <Unit> {
    val a =async {
        log("I'm computing a piece of the answer")
        6
    }
    val b = async {
        log("I'm computing another piece of the answer")
        7
    }
    log("The answer is ${a.await() * b. await()}")

    //use 넣는이유는 close해서 메모리 누수를 막기위함입니다.
    // Thread 가 3개가 있다
}