## Goal
* see [multiplatform create first app](../topics/multiplatfrom-onboard/multiplatform-create-first-app.md)
* Kotlin Multiplatform project / -- targeting -- Android, iOS
* `expect` & `actual` declarations

## How has it been created?
* Using [KMP wizard](https://kmp.jetbrains.com/)

## Structure
* `/composeApp`
  * 👀== code / -- will be shared ACROSS your -- Compose Multiplatform applications👀
    * `/commonMain`
      * == code / common for ALL targets
    * REST of folders (`/androidMain`, `/desktopMain`, `/iosMain`)
      * == Kotlin code / -- will be compiled for -- specific-platforms
* `/iosApp`
  * == iOS applications
    * == SwiftUI code -- for your -- project
* `/shared`
  * == code / shared | ALL project's targets
  * `/commonMain`
    * MOST important subfolder
    * ALTHOUGH, platform-specific code can be added here


## Notes
* You can find this project step by step of the guide | [this GitHub repository](https://github.com/kotlin-hands-on/get-started-with-kmp)