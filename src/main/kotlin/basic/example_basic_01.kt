package basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread


fun main() = runBlocking {

    GlobalScope.launch {
        repeat(1000){i ->
            println("I'm sleeping $i")
            delay(500L)
        }
    }

    delay(1300L)
}

    //TODO Coroutine Builder
    // - launch
    // - runBlocking

    //TODO Scope
    // - CoroutineScope
    // - GlobalScope

    //TODO Suspend function
    // - suspend
    // - delay()
    // - join



     // dealy, thread , runBlocking , job 선언 job.join()
    // structure(jon.join() 많을때   val job1 == this.launch 메인스코프로 이동
    // this 도 필요없다 이미 runBlocking 안에 this가 선언되어있기때문에
    //fun myWorld() 생성후 suspend 기호를 붙여야한다
    // repeat(100_000) 해서 thread와 coroutines 성능비교
    // coroutine 이 살아있다고 해서 프로세스를 살려주는것이 아니다 즉. 메인함수가 리턴이 될시에 모든 함수 종료



//    //GlobalScope 전체 라이프 타임을 가진 스코프
//    thread{
//        Thread.sleep(1000L)
//        println("world!")
//    }
//    println("Hello, ")
//    Thread.sleep(2000L)


