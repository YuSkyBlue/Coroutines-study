package context

import kotlinx.coroutines.*

class Activtiy {
    private val mainScope = CoroutineScope(Dispatchers.Default)

    fun destory(){
        mainScope.cancel()
    }
    fun doSomething(){
        repeat(10){i->
            mainScope.launch {
                delay((i+1) * 200L)
                println("Coroutines $i is done")
            }
        }
    }

}

fun main() = runBlocking<Unit> {
   val activity = Activtiy()
    activity.doSomething()
    println("Launced coroutines")
    delay(500L)
    println("Destorying acitivty!")
    activity.destory()
    delay(1000)
    println("모든활동 끝 ")
}
    //use 넣는이유는 close해서 메모리 누수를 막기위함입니다.
    // Thread 가 3개가 있다
    // coroutines context 실행하고 job/ dispacther
    //GlobalScope는 main에서 cancel해도 취소가 되지않는다. 
