package basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

fun main() = runBlocking {
    val result = withTimeoutOrNull(1300L){
        repeat(1000) { i ->
            println("I'm sleeping at $i ...")
            delay(500L)

        }
        "Done"  //굳이 안넣어줘도 됩니다.
    }
    println("Resuit is $result")
}
        // 시간이 지나면 cancellation Exceptino 발생

//TODO Job
// - cancel()
//

//TODO Cancellation is cooperative
// - way1 : to periodcally invoke a suspending
// - way2 : explicitly check the cancellation status(isActive)

//TODO Timeout
// - withTimeout
// - wtihTimeoutOrNull
