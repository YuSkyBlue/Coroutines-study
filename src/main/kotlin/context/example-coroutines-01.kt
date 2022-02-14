package context

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking <Unit> {
    launch {
        println(
            "main runBlocking" +
                    "Im working in thread ${Thread.currentThread().name}"
        )
    }

    launch(Dispatchers.IO) {
        println(
            "Unconfined        :" +
                    "Im working in thread ${Thread.currentThread().name}"
        )
    }
    launch(Dispatchers.Default) {
        kotlin.io.println(
            "Default        :" +
                    "Im working in thread ${java.lang.Thread.currentThread().name}"
        )
    }
    newSingleThreadContext("MyOwnThread").use{
        launch(it) {
            println("newSingleThreadContext:  I'm working in thread ${Thread.currentThread().name}")  }

    }

    //use 넣는이유는 close해서 메모리 누수를 막기위함입니다.
}