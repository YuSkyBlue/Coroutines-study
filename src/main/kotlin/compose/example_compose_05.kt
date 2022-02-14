package compose


import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    try {

        val time = measureTimeMillis {
            val one = somethingUsefulOneAsync1()
            val two = somethingUsefulTwoeAsync1()

            println("my exceptions")
            throw  Exception("my exceptions")
            runBlocking {
                println("The answer is : ${one.await()+ two.await()}")
            }
        }
        println("Complted in $time ms")
    } catch (e : Exception){

    }
}


fun somethingUsefulOneAsync1() =GlobalScope.async {
    println("start, soemthingUsefulOneAsync")
    val res = doSomethingUsefulOne4()
    println("end, soemthingUsefulOneAsync")
    res
}
fun somethingUsefulTwoeAsync1() =GlobalScope.async {
    println("start, soemthingUsefulTwoAsync")
    val res = doSomethingUsefulTwo4()
    println("end, soemthingUsefulTwoAsync")
    res
}
suspend fun doSomethingUsefulOne4(): Int{
    println("dosometihngone")
    delay(1000L)
    return  13
}

suspend fun doSomethingUsefulTwo4(): Int {
    println("dosometihngtwo")
    delay(1000L)
    return 29

}
// 오호 동시에 실행해서 속도가 2024 => 1022 반으로 줄었다.
// async{ 함수 }  => println( ${one.await() + two.await()}
// one 이라는 Defered 객체를 : Job 으로 반환해서  값을 기다렸다가 반환
// asysnc (start= Coroutines.LAZY) 느린 객체 할당
