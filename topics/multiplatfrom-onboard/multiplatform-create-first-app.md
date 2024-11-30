[//]: # (title: Create your first cross-platform app)

* goal
  * create Kotlin Multiplatform app /
    * share logic
    * native UI for
      * Android (Jetpack Compose UI)
      * iOS (SwiftUI)

* steps
  * Create your first cross-platform app
  * Update the UI
  * Add dependencies
  * Share more logic
  * Wrap up your project

* Kotlin Multiplatform
  * technology -- simplifies the -- development of cross-platform projects
  * use cases
    * share code between mobile platforms
    * write platform-specific code

* see [JetBrains Fleet](../tools/fleet.md)

## Set up the environment

* see [Kotlin Multiplatform development](../multiplatform-setup.md)
  * install the [Kotlin Multiplatform plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform) | Android Studio
  * launch Xcode 
  * Run `Kdoctor`

## Create the project with a wizard

1. Open the [Kotlin Multiplatform wizard](https://kmp.jetbrains.com)
2. "GreetingKMP" | **New project** tab, "com.jetbrains.greeting" | project ID 
3. platforms **Android** and **iOS**
4. | iOS, select the **Do not share UI** option 
   1. == keep the UI native
5. Click the **Download** button and unpack the resulting archive.

    ![Kotlin Multiplatform wizard](/images/multiplatform-create-app/multiplatform-web-wizard-1.png)

## Examine the project structure

* Kotlin Multiplatform project's modules
  * _shared_
    * == Kotlin module / has the code shared between platforms
    * uses [Gradle](https://kotlinlang.org/docs/gradle.html)
    * 👀can be used -- as a -- 👀
      * regular framework or
        * default behavior if you create the project -- via -- Kotlin Multiplatform wizard 
      * [CocoaPods dependency](https://kotlinlang.org/docs/native-cocoapods.html)
    * == `androidMain` + `commonMain` + `iosMain`
      * EACH of them 
        * are [_Source set_](https://docs.gradle.org/current/dsl/org.gradle.api.tasks.SourceSet.html)
        * -- target -- DIFFERENT platforms
      * `commonMain`
        * == shared Kotlin code + platform source sets
      * `androidMain`
        * used by Kotlin/JVM
      * `iosMain`
        * used by Kotlin/Native
      ![Source sets and modules structure](/images/multiplatform-create-app/basic-project-structure-2.png)
    * if shared module is built into an Android library -> Kotlin code -- is treated as -- Kotlin/JVM
    * if shared module is built into an iOS framework -> Kotlin code -- is treated as -- Kotlin/Native
    ![Common Kotlin, Kotlin/JVM, and Kotlin/Native](/images/multiplatform-create-app/modules-structure.png)
    * if you try to use platform-specific APIs -> IDE will show a warning
  * _composeApp_
    * == Kotlin module / builds into Android application
    * uses 
      * Gradle
      * the shared module
  * _iosApp_
    * == Xcode project / builds into iOS application
      * uses the shared module -- as an -- iOS framework

    ![Basic Multiplatform project structure](/images/multiplatform-create-app/basic-project-structure.svg)

### Check out platform-specific implementations

* if you want to use platform specifics -> 
  * ❌NOT possible -- via -- ONLY Kotlin code❌
  * use
    * [interfaces](../development/multiplatform-connect-to-apis.md) &
    * [expect/actual](../development/multiplatform-connect-to-apis.md)

* code |
  * | `AndroidPlatform`
    * use Kotlin/JVM
    * _Example:_ `name` property -- via -- `android.os.Build` dependency
  * | `IOSPlatform`
    * use Kotlin/Native
      * == write iOS code | Kotlin
    * _Example:_ `name` property -- via -- `platform.UIKit.UIDevice` dependency

## Run your application

### Run your application | Android

1. | list of run configurations, select **composeApp**.
2. Choose an Android virtual device & click **Run**

   ![Run multiplatform app on Android](/images/compose-create-first/compose-run-android.png)

   ![First mobile multiplatform app on Android](/images/compose-create-first/first-compose-project-on-android-1.png)

### Run your application | iOS

1. launch Xcode 
2. | Android Studio's list of run configurations, select **iosApp** & click **Run**

   ![Run multiplatform app on iOS](/images/compose-create-first/compose-run-ios.png)

   ![First mobile multiplatform app on iOS](/images/compose-create-first/first-compose-project-on-ios-1.png)

## Next step

**[Proceed to the next part](multiplatform-update-ui.md)**
