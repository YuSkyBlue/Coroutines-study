package basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun  main(): Unit = runBlocking {
    val job = launch {
        repeat(1000){ i->
            println("job : I'm sleeping $i...")
            delay(500L)

        }
    }

    delay(1300L)
    println("Main: I'm tired of waiting")
    job.cancel()
    job.join()
        println("main : Now I can quit")
}

    // job.cancel() 코루틴 중단/ job.join()코루틴 중단후 참여
    // suspend fun() 중단

