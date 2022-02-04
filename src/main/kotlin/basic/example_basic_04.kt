package basic

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch(Dispatchers.Default) {

        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i")
                delay(500L)
            }
        } finally {
            println("job: I'm running finally")
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
    // isActive => Exception을 던지지 않는다. coroutine 끝나면 False를 던짐
    // isActive 안에 resource는 job 이 끝나는지 확인하는 함수가 들어있다.
    // try {} finally => finally 는 resource 가 끝나는시점에 실행된다.
