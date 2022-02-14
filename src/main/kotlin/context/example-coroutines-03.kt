package context

import kotlinx.coroutines.*

fun log1(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() {
    newSingleThreadContext("Ctx1").use { ctx1 ->
        newSingleThreadContext("Ctx2").use {ctx2->

            runBlocking(ctx1) {
                log("Started in ctx1")

                withContext(ctx2){
                    log("Working in ctx2")
                }
                log("Back to ctx1")
            }
        }
    }
    //use 넣는이유는 close해서 메모리 누수를 막기위함입니다.
    // Thread 가 3개가 있다 
}