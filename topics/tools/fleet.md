[//]: # (title: Use Fleet for Multiplatform development — tutorial)

* goal
  * work with Kotlin Multiplatform projects | [JetBrains Fleet](https://www.jetbrains.com/fleet/)

* Fleet
  * goal
    * provide a superior experience for Kotlin Multiplatform
      * 👀ONLY available | macOS👀
  * 's Smart Mode
    * -- automatically selects the -- appropriate code-processing engine
  * allows
    * quickly open & run multiplatform projects / target Android, iOS, web, and desktop platforms
    * 👀if you target iOS -> navigation, refactoring, and debugging are available ACROSS ALL languages / used | project👀
      * == easier to manage a mixed-language codebase
  
## Prepare your development environment

1. Install [JetBrains Toolbox](https://www.jetbrains.com/toolbox-app/) app
   1. allows
      1. easy upgrade path -- to -- NEW versions
      2. manage MULTIPLE versions of JetBrains products
2. Log into Toolbox with your [JetBrains account](https://account.jetbrains.com/login).
3. Install Java Development Kit v17.0+ 
   1. Reason: 🧠required by Fleet & Kotlin Multiplatform development
4. Click **Install** next to the **Fleet** icon.
5. Install [Android Studio](https://developer.android.com/studio) and [Xcode](https://apps.apple.com/us/app/xcode/id497799835)
   1. Reason: 🧠run your app | Android and iOS simulators 🧠
   2. see [Set up an environment](../multiplatform-setup.md)
      1. [how to create a virtual device | Android Studio](https://developer.android.com/studio/run/managing-avds#createavd)

## Get started with Fleet

* ways to create a Multiplatform project
  * -- via -- [Kotlin Multiplatform wizard](https://kmp.jetbrains.com/).
  * [Cloning an existing Git repository](https://www.jetbrains.com/help/fleet/workspace.html#clone-project)

### Create a project

* create a new project -- via -- web wizard
  1. Open the [Kotlin Multiplatform wizard](https://kmp.jetbrains.com).
  2. On the **New project** tab, change the project name to "SampleProject" and use "com.example.project" as the project's ID.
  3. Select the **Android**, **iOS**, and **Desktop** options as your platforms.
  4. For iOS, make sure that the **Share UI** option is selected.
  5. Click **Download** and unpack the resulting archive.

![Kotlin Multiplatform wizard](/images/fleet/fleet-web-wizard.png)

### Enable Smart Mode

1. Launch Fleet.
2. click **Open File or Folder** or select **File | Open** in the editor
3. Navigate to the unpacked "SampleProject" folder and click **Open**.

   ![Fleet project wizard](/images/fleet/fleet-project-wizard-1.png)

4. 💡Fleet gives you the option to enable [Smart Mode](https://www.jetbrains.com/help/fleet/smart-mode.html)💡
   1. Click **Trust and Open**:

      ![Smart mode in Fleet](/images/fleet/fleet-project-wizard-2.png)

   2. Fleet messages that the project is imported and indexed | top of the window
   3. 👀once it's enabled -> Fleet offers language-related features (code completion, navigation, debugging, and refactoring) 👀
      1. Fleet -- chooses the -- backend / use to process code 
         1. backend for Kotlin == code-processing engine used by IntelliJ IDEA
      2. if you want to check Smart Mode status -> click the lightning bolt icon | top
         
         ![Enabling Smart Mode in Fleet](/images/fleet/fleet-smart-mode.png) 
   4. once it's disabled -> Fleet works as a simple code editor

### Run your project

* Fleet [run configurations](https://www.jetbrains.com/help/fleet/run-configs.html)
  * for the targets / found | build file
  * created by Fleet | open a project
  * . To access run configurations, you can:

* way to run
  * <shortcut>⌘ R</shortcut> shortcut
  * Select **Run** | **Run & Debug** in the main menu.

![Run configurations](/images/fleet/fleet-run-configurations.png)

* choose the `iosApp` configuration 
  * -> application is executed | iPhone simulator

    ![Run the iOS app on the iPhone simulator](/images/fleet/fleet-run-ios-app.png)

## Work with multiplatform code

* see [Get started with the Compose Multiplatform](../compose-onboard/compose-multiplatform-explore-composables.md)

### cross-language navigation

* 👀== Fleet can navigate -- through -- files | != program languages👀
* navigating from Kotlin to Swift
  1. Open the `composeApp/src/commonMain/kotlin/App.kt`
     1. == center of the sample code
  2. select the `App()` -- to see -- files | it's invoked
     1. files -- to launch the -- Android, iOS, and desktop targets 

        ![Function show usages](/images/fleet/fleet-show-usages.png)

     2. 👀`MainViewController.kt` -- is invoked from -- Swift code👀

        <img src="/images/fleet/fleet-navigation.animated.gif" alt="Using cross-language navigation in Fleet" width="700" preview-src="fleet-navigation.png"/>

### Editing in multiple languages

* Fleet -- has support for -- editing Swift code
  * modify `ContentView.swift`
    1. add a new function | `ComposeView` type

       ```swift
       struct ComposeView: UIViewControllerRepresentable {
           // …
           func sumArray(input: [Int]) -> String {
               var total = 0
               for item in input {
                   total += item
               }
               return "Total value is \(total)"
           }
       }
       ```

    2. Update `makeUIViewController()` 

       ```swift
       func makeUIViewController(context: Context) -> UIViewController {
           MainViewControllerKt.MainViewController(text: sumArray(input: [10,20,30,40]))
       }
       ```

    3. Update the `MainViewController.kt`

       ```kotlin
       fun MainViewController(text: String) = ComposeUIViewController { App(text) }
       ```
       * `MainViewController()`
         * == function /
           * declared | Kotlin
           * invoked -- from -- Swift

    4. Adjust the `App` composable

       ```kotlin
       @Composable
       fun App(text: String? = null) {
           MaterialTheme {
               var showContent by remember { mutableStateOf(false) }
               val greeting = remember { Greeting().greet() }
               Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                   Button(onClick = { showContent = !showContent }) {
                       Text(text ?: greeting)
                   }
                   AnimatedVisibility(showContent) {
                       Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                           Image(painterResource(Res.drawable.compose_multiplatform), null)
                           Text("Compose: $greeting")
                       }
                   }
               }
           }
       }
       ```
    5. rerun the application | iOS

       ![Editing in multiple languages](/images/fleet/fleet-code-editing.png)

### cross-language refactoring

* refactoring
  * Fleet's feature / cross-language
    * 👀== if you refactor function or whatever in some language / invoked | other language -> ALSO refactored there 👀
  * _Example:_ rename `MainViewController()` & check that it's renamed | `MainSwiftUIViewController`

    <img src="/images/fleet/fleet-refactor-code.animated.gif" alt="Refactoring across multiple languages in Fleet" width="700" preview-src="fleet-refactor-code.png"/>

### cross-language Debugging

* 👀== Fleet can debug -- through -- files | != program languages👀
* _Example:_ 
  1. set a breakpoint | 
     1. `ContentView.swift.sumArray()`'s return expression
     2. `App.kt`'s line 23
  2. click **Debug**
  3. check how it stops through those files

     ![Refactoring across multiple languages in Fleet](/images/fleet/fleet-debug.png)

## What's next?

* see [JetBrains Fleet](https://www.jetbrains.com/help/fleet)
