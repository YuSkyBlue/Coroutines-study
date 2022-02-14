package context

import kotlinx.coroutines.*



fun main() = runBlocking<Unit> {
    val request = launch {
        GlobalScope.launch {
            println("job1: I' run ib GlobalScope and execute independently")
            delay(1000)
            println("job1: I'm not affected by cancellation of the request")
        }

        launch {
            delay(100)
            println("job2 : I am a child of the request coroutines")
            delay(1000)
            println("job2 : I will not execute this line if my parent request")
        }
    }

    delay(500)
    request.cancel()
    delay(1000)
    println("main: who whas survived request cancellation ")

}
    //use 넣는이유는 close해서 메모리 누수를 막기위함입니다.
    // Thread 가 3개가 있다
    // coroutines context 실행하고 job/ dispacther
    //GlobalScope는 main에서 cancel해도 취소가 되지않는다.
