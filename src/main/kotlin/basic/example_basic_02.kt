package basic

import kotlinx.coroutines.*

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        try {


        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                yield()
                println("Job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
        } catch (e: Exception){
            kotlin.io.println("Exception [$e]... ")
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit")

}
    // delay(1L) 넣어야 협조적인 코틀린 완성
    //yielde() 함수는 코루틴이 중단되었다가 재개 될 때 excpetion() 던진다.
    // Coroutine 이 협조적이여야 한다  try catch{} 문으로 확인
    //