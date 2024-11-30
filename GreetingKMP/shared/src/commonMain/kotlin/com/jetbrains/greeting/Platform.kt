package com.jetbrains.greeting

interface Platform {
    val name: String
    val randomUUID: String
}

expect fun getPlatform(): Platform
expect fun randomUUID(): String

// expect / actual mechanism for properties
//expect val num: Int = 42
expect val num: Int