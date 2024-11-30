[//]: # (title: Use platform-specific APIs)

* goal
  * how to use platform-specific APIs | developing multiplatform applications & libraries

## Kotlin multiplatform libraries

* == common Kotlin API /
  * different implementation / platforms
  * 👀see [this curated list](https://github.com/terrakok/kmm-awesome) 👀
    * MANY libraries to implement 
      * networking,
      * logging,
      * analytics,
      * access device 

* recommendations
  * FIRST, check if you can use this multiplatform library
  * ELSE -> use a platform-specific API

## Expected and actual functions and properties

* == 👀language mechanism -- to access -- platform-specific APIs | developing common logic👀
  * see [expected and actual declarations](https://kotlinlang.org/docs/multiplatform-expect-actual.html)
    ![Using expected and actual functions and properties](/images/connect-apis/expect-functions-properties.svg)

* goal of this section
  * expected and actual functions and properties
    * use cases
      * SIMPLE cases
    * _Example:_ 
      * expected `platform()` | common source set & actual implementations | platform source sets
      * Kotlin compiler -- merges -- the expected + actual declarations == 1 `platform()` function / its actual implementation 
      * invocation of the expected `platform()` function | generated platform code -- will call the -- correct actual implementation

### Example: generate a UUID

* see [GreetingKMP](/GreetingKMP)

![Generating UUID with expected and actual declarations](/images/connect-apis/expect-generate-uuid.svg)

* Android implementation -- uses the -- APIs | Android
* iOS implementation -- uses the -- APIs | iOS / -- can be access from -- Kotlin/Native code

## Interfaces | common code

* interfaces | common code + implementations | platform source sets
  * uses
    * platform-specific logic is too big and complex

    ![Using interfaces](/images/connect-apis/expect-interfaces.svg)
  * 👀ways to inject the platform dependencies 👀
    * [Use expected and actual functions](#expected-and-actual-functions)
    * [Provide implementations through different entry points](#different-entry-points)
    * [Use a dependency injection framework](#dependency-injection-framework)

### Expected and actual functions

* expected function / returns a value of this interface
* actual functions / return its subclasses

* _Example:_ see [GreetingKMP](/GreetingKMP)

### Different entry points

* TODO:
If you control the entry points, you can construct implementations of each platform artifact without using
expected and actual declarations. 
To do so, define the platform implementations in the shared Kotlin Multiplatform module,
but instantiate them in the platform modules:

```kotlin
// Shared Kotlin Multiplatform module
// In the commonMain source set:
interface Platform

fun application(p: Platform) {
    // application logic
}
```

```kotlin
// In the androidMain source set:
class AndroidPlatform : Platform
```

```kotlin
// In the iosMain source set:
class IOSPlatform : Platform
```

```kotlin
// In the androidApp platform module:
import android.app.Application
import mysharedpackage.*

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        application(AndroidPlatform())
    }
}
```

```Swift
// In the iosApp platform module (in Swift):
import shared

@main
struct iOSApp : App {
    init() {
        application(IOSPlatform())
    }
}
```

On Android, you should create an instance of `AndroidPlatform` and pass it to the `application()` function, while on iOS, you
should similarly create and pass an instance of `IOSPlatform`. These entry points don't need to be the entry points of your
applications, but this is where you can call the specific functionality of your shared module.

Providing the right implementations with expected and actual functions or directly through entry points works well for
simple scenarios. However, if you use a dependency injection framework in your project,
we recommend using it in simple cases to ensure consistency.

### Dependency injection framework

A modern application typically uses a dependency injection (DI) framework to create a loosely coupled architecture. The
DI framework allows injecting dependencies into components based on the current environment.

Any DI framework that supports Kotlin Multiplatform can help you inject different dependencies for different platforms.

For example, [Koin](https://insert-koin.io/) is a dependency injection framework that supports Kotlin Multiplatform:

```kotlin
// In the common source set:
import org.koin.dsl.module

interface Platform

expect val platformModule: Module
```

```kotlin
// In the androidMain source set:
class AndroidPlatform : Platform

actual val platformModule: Module = module {
    single<Platform> {
        AndroidPlatform()
    }
}
```

```kotlin
// In the iosMain source set:
class IOSPlatform : Platform

actual val platformModule = module {
    single<Platform> { IOSPlatform() }
}
```

Here, Koin DSLs create modules that define components for injection. You declare a module in common code with
the `expect` keyword and then provide a platform-specific implementation for each platform using the `actual` keyword.
The framework takes care of selecting the correct implementation at runtime.

When you use a DI framework, you inject all of the dependencies through this framework. The same logic applies to handling
platform dependencies. We recommend continuing to use DI if you already have it in your project, rather than using the expected
and actual functions manually. This way, you can avoid mixing two different ways of injecting dependencies.

You also don't have to always implement the common interface in Kotlin. You can do it in another language, like
Swift, in a different _platform module_. If you choose this approach, you should then provide the implementation from the iOS platform module using the DI
framework:

![Using dependency injection framework](expect-di-framework.svg){width=700}

This approach only works if you put the implementations in the platform modules. It isn't very scalable, as your Kotlin
Multiplatform module can't be self-sufficient and you'll need to implement the common interface in a different module.

<!-- If you're interested in having this functionality expanded to a shared module, please vote for this issue in Youtrack and describe your use case. -->

## What's next?

* see [Expected and actual declarations](https://kotlinlang.org/docs/multiplatform-expect-actual.html)