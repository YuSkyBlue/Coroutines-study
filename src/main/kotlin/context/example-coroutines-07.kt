package context

import kotlinx.coroutines.*



fun main() = runBlocking<Unit> {
    launch(
        Dispatchers.Default +
                CoroutineName("test")) {

        println("I'm working in thread ${Thread.currentThread().name}")

    }
}
    //use 넣는이유는 close해서 메모리 누수를 막기위함입니다.
    // Thread 가 3개가 있다
    // coroutines context 실행하고 job/ dispacther
    //GlobalScope는 main에서 cancel해도 취소가 되지않는다. 
