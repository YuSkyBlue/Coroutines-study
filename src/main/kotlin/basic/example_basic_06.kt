package basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() = runBlocking {
    withTimeout(1300L){
        repeat(1000) { i ->
            println("I'm sleeping at $i ...")
            delay(500L)

        }
    }
}
        // 시간이 지나면 cancellation Exceptino 발생