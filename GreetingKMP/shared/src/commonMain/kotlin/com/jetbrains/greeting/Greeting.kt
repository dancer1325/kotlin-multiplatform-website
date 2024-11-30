package com.jetbrains.greeting

// if you use platform-specifc APIs | common source set -> IDE highlights as warning
//import java.util.Random
import kotlin.random.Random

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
  //      val firstWord = if (Random().nextBoolean()) "Hi!" else "Hello!"
        //return "Hello, ${platform.name}!"

        val firstWord = if (Random.nextBoolean()) "Hi!" else "Hello!"
        return "$firstWord [$num] Guess what this is! > ${platform.name.reversed()}!"
    }

    fun generateRandomUUID(): String {
        return platform.randomUUID
    }

}