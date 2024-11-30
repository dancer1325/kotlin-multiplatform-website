package com.jetbrains.greeting

import android.os.Build
import java.util.*

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val randomUUID: String = randomUUID()
}

actual fun getPlatform(): Platform = AndroidPlatform()
actual fun randomUUID() = UUID.randomUUID().toString()
actual val num: Int = 1