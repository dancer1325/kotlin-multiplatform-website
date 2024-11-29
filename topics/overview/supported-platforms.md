[//]: # (title: Stability of supported platforms)

* level of stability / platform
  * -- depend on --
    * Core Kotlin Multiplatform technology -- for code sharing --
    * Compose Multiplatform UI framework

## Core Kotlin Multiplatform technology stability levels

* **Experimental**
  * == ONLY "for trial use" 
    * -> can be drop it | ANY minute

* **Best effort**
  * == safe to use | MOST scenarios
    * There MIGHT be unexpected breaking changes
    * You may experience issues | migration

* **Stable**
  * == can be used it | MOST conservative scenarios
  * it's developed / follows [backward compatibility rules](https://kotlinfoundation.org/language-committee-guidelines/)

* see [Stability levels of Kotlin components](https://kotlinlang.org/docs/components-stability.html#current-stability-of-kotlin-components)

### Current platform stability levels for the core Kotlin Multiplatform technology

| Platform                 | Stability level |
|--------------------------|-----------------|
| Android                  | Stable          |
| iOS                      | Stable          |
| Desktop (JVM)            | Stable          |
| Server-side (JVM)        | Stable          |
| Web based on Kotlin/Wasm | Alpha           |
| Web based on Kotlin/JS   | Stable          |
| watchOS                  | Best effort     |
| tvOS                     | Best effort     |

* see [support | OTHER native platforms](https://kotlinlang.org/docs/native-target-support.html).

## Compose Multiplatform UI framework stability levels

* **pre-stable**
  * **Experimental**
    * == UNDER development
      * Some features MIGHT 
        * NOT be available
        * have performance issues or bugs
      * There MIGHT be breaking changes
  * **Alpha**
    * == "use at your own risk, expect migration issues"
      * NO final shape yet
  * **Beta**
    * == "you can use it, and we'll do our best to minimize migration issues for you":
      * ALMOST done == NOT 100% finished yet

* **Stable**
  * == "you can use it even in the most conservative of scenarios"
    * == comprehensive API /
      * allows you to write applications
        * beautiful,
        * production-ready 
      * NO encountering performance OR other issues
    * steps for API-breaking changes
      * deprecation announcement
      * \+ 2 versions later

### Current platform stability levels for Compose Multiplatform UI framework

| Platform                 | Stability level |
|--------------------------|-----------------|
| Android                  | Stable          |
| iOS                      | Beta            |
| Desktop (JVM)            | Stable          |
| Web based on Kotlin/Wasm | Alpha           |

## What's next?

* see [Recommended IDEs](recommended-ides.md)
