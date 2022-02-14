package context

import kotlinx.coroutines.*



fun main() = runBlocking<Unit> {
    println("My job is ${coroutineContext[Job]}")

    launch {
        println("My job is ${coroutineContext[Job]}")
    }
    async {
        println("My job is ${coroutineContext[Job]}")
    }

    //isActive
    coroutineContext[Job]?.isActive ?: true

}
    //use 넣는이유는 close해서 메모리 누수를 막기위함입니다.
    // Thread 가 3개가 있다
    // coroutines context 실행하고 job/ dispacther
