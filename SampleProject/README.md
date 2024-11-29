## Goal
* use Flee
  * follow [fleet guides](/topics/tools/fleet.md)
* Kotlin Multiplatform project / -- targeting -- Android, iOS, Desktop

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
  * ⚠️ALTHOUGH you’re sharing your UI -- via -- Compose Multiplatform, you need it ⚠️
