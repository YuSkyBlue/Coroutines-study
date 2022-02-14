package nomagic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() : Unit{
    GlobalScope.launch {
        val userData =  fetchUserData()
        val userCache = cacheUserData(userData)
        updateTextView1(userCache)
    }
}

suspend fun  fetchUserData() = "user_name"

suspend  fun cacheUserData(user: String) = user

fun updateTextView1(user: String) = user
