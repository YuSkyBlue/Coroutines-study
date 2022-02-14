package context

import kotlinx.coroutines.*



fun main() = runBlocking<Unit> {
    val request = launch {
       repeat(3) { i ->
           launch {
               delay((i+1) * 200L)
               println("Coroutine $i is done")
           }
       }
        println("request : I'm done and I don't explicitly join my chlidren are still active ")
}
    println("Now processing of the request is complete")
}
    //use 넣는이유는 close해서 메모리 누수를 막기위함입니다.
    // Thread 가 3개가 있다
    // coroutines context 실행하고 job/ dispacther
    //GlobalScope는 main에서 cancel해도 취소가 되지않는다. 
