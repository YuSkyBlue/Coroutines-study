package compose

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async (start= CoroutineStart.LAZY){ doSomethingUsefulOne2() }
        val two = async (start= CoroutineStart.LAZY){  doSomethingUsefulTwo2()}

        one.start()
        two.start()
        println("The answer is : ${one.await()+ two.await()}")
    }
    println("Complted in $time ms")
}


suspend fun doSomethingUsefulOne2(): Int{
    println("dosometihngone")
    delay(1000L)
    return  13
}

suspend fun doSomethingUsefulTwo2(): Int {
    println("dosometihngtwo")
    delay(1000L)
    return 29

}
 // 오호 동시에 실행해서 속도가 2024 => 1022 반으로 줄었다.
 // async{ 함수 }  => println( ${one.await() + two.await()}
// one 이라는 Defered 객체를 : Job 으로 반환해서  값을 기다렸다가 반환
// asysnc (start= Coroutines.LAZY) 느린 객체 할당
