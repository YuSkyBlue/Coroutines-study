package compose


import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    try {
        val time = measureTimeMillis {
            println("The answer is ${concurrentSum1()}")
        }
        kotlin.io.println("Completed in $time ms")
    } catch (e: Exception){
        println("오류가 뻑하고 났습니다. 아이고 ")
    }

}

suspend  fun concurrentSum1(): Int = coroutineScope {
    val  one = async { doSomethingUsefulOne7() }
    val  two = async { doSomethingUsefulTwo7() }
    delay(10)
    kotlin.io.println("Exception")
    throw Exception()
    one.await() + two.await()
}

suspend fun doSomethingUsefulOne7(): Int{
    kotlin.io.println("start, dosomethingUsefulOne")
    delay(1000L)
    kotlin.io.println("end, dosomethingUsefulOne")
    return  13
}

suspend fun doSomethingUsefulTwo7(): Int {
    kotlin.io.println("start, dosomethingUsefulTwo")
    delay(1000L)
    kotlin.io.println("end, dosomethingUsefulTwo")
    return 29

}
// 오호 동시에 실행해서 속도가 2024 => 1022 반으로 줄었다.
// async{ 함수 }  => println( ${one.await() + two.await()}
// one 이라는 Defered 객체를 : Job 으로 반환해서  값을 기다렸다가 반환
// asysnc (start= Coroutines.LAZY) 느린 객체 할당
