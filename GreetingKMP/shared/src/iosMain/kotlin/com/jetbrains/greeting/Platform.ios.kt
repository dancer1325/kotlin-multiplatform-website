package com.jetbrains.greeting

import platform.Foundation.NSUUID
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val randomUUID: String = randomUUID()
}

actual fun getPlatform(): Platform = IOSPlatform()
actual fun randomUUID(): String = NSUUID().UUIDString()
actual val num: Int = 2