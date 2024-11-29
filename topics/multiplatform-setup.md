[//]: # (title: Set up an environment)

* goal
  * set up an environment -- for -- KMP development
    * == requirements to create your first Kotlin Multiplatform application

## Install the necessary tools

<table>
   <tr>
      <td>Tool</td>
      <td>Comments</td>
   </tr>
    <tr>
        <td><a href="https://developer.android.com/studio">Android Studio</a></td>
        <td>uses <br>&nbsp; 1. create your multiplatform applications <br>&nbsp; 2. run them | simulated or hardware devices</td>
    </tr>
    <tr>
        <td>
          <p><a href="https://apps.apple.com/us/app/xcode/id497799835">Xcode</a></p>
        </td>
        <td>
          <p> if you want to run iOS applications | simulated or real device -> you need it </p>
          uses <br>&nbsp; 1. add Swift or Objective-C code | your iOS application
          <p> Kotlin/Native sometimes does NOT support the newest Xcode -> see <a href="https://kotlinlang.org/docs/multiplatform-compatibility-guide.html#version-compatibility">compatibility guide</a>
          </p>   
      </td>
   </tr>
   <tr>
        <td><a href="https://www.oracle.com/java/technologies/javase-downloads.html">JDK</a></td>
   </tr>
   <tr>
        <td><a href="https://kotlinlang.org/docs/multiplatform-plugin-releases.html">Kotlin Multiplatform plugin</a></td>
        <td>install it | Android Studio</td>
   </tr>
   <tr>
        <td><a href="https://kotlinlang.org/docs/releases.html#update-to-a-new-release">Kotlin plugin</a></td>
        <td>
            <p>bundled and automatically updated / EACH Android Studio release</p>
        </td>
   </tr>
</table>

## Check your environment -- KDoctor -- 

* requirements
  * available ONLY | macOS
    * if you use another OS -> skip this section
* allows
  * checking everything works as expected
* steps
  * install kdoctor
    * -- via -- homebrew 
      ```bash
          brew install kdoctor
      ```
    * [another alternatives](https://github.com/Kotlin/kdoctor#installation)
  * run it

    ```bash
    kdoctor
    ```

    * if KDoctor diagnoses any problems ->
      * follow the suggestions
      * check [stackOverflow link](https://stackoverflow.com/questions/64901180/how-to-run-cocoapods-on-apple-silicon-m1/66556339#66556339)
   
## Possible issues and solutions

* TODO:
<deflist collapsible="true">
   <def title="Kotlin and Android Studio">
      <list>
         <li>Make sure that you have Android Studio installed. You can get it from its <a href="https://developer.android.com/studio">official website.</a></li>
         <li>You may encounter the <code>Kotlin not configured</code> error. It's a known issue in Android Studio Giraffe 2022.3 that doesn't affect building and running projects. To avoid the error, click <strong>Ignore</strong> or upgrade to Android Studio Hedgehog 2023.1.</li>
      </list>
   </def>
   <def title="Java and JDK">
         <list>
           <li>Make sure that you have JDK installed. You can get it from its <a href="https://www.oracle.com/java/technologies/javase-downloads.html">official website</a>.</li>
           <li>Android Studio uses a bundled JDK to execute Gradle tasks. To configure the Gradle JDK in Android Studio, select <strong>Settings/Preferences | Build, Execution, Deployment | Build Tools | Gradle</strong>.</li>
           <li>You might encounter issues related to <code>JAVA_HOME</code>. This environment variable specifies the location of the Java binary required for Xcode and Gradle. If so, follow KDoctor's tips to fix the issues.</li>
         </list>
   </def>
   <def title="Xcode">
      <list>
         <li>Make sure that you have Xcode installed. You can get it from its <a href="https://developer.apple.com/xcode/">official website</a>.</li>
         <li>If you haven't launched Xcode yet, open it in a separate window. Accept the license terms and allow it to perform some necessary initial tasks.</li>
         <li><p>You may encounter <code>Error: can't grab Xcode schemes</code> or other issues regarding command line tools selection. In this case, do one of the following:</p>
             <list>
               <li><p>In Terminal, run:</p>
                   <code style="block"
                         lang="bash">sudo xcode-select --switch /Applications/Xcode.app</code>
               </li>
               <li>Alternatively, in Xcode, select <strong>Settings | Locations</strong>. In the <strong>Command Line Tools</strong> field, select your Xcode version.
                   <img src="xcode-schemes.png" alt="Xcode schemes" width="500"/>
                   <p>Make sure that the path to <code>Xcode.app</code> is selected. Confirm the action in a separate window if required.</p>
               </li>
             </list>
         </li>
      </list>
   </def>
   <def title="Kotlin plugins">
         <snippet>
            <p><strong>Kotlin Multiplatform plugin</strong></p>
               <list>
                  <li>Make sure that the Kotlin Multiplatform plugin is installed and enabled. On the Android Studio welcome screen, select <strong>Plugins | Installed</strong>. Verify that you have the plugin enabled. If it's not in the <strong>Installed</strong> list, search <strong>Marketplace</strong> for it and install the plugin.</li>
                  <li>If the plugin is outdated, click <strong>Update</strong> next to the plugin name. You can do the same in the <strong>Settings/Preferences | Tools | Plugins</strong> section.</li>
                  <li>Check the compatibility of the Kotlin Multiplatform plugin with your version of Kotlin in the <a href="https://kotlinlang.org/docs/multiplatform-plugin-releases.html#release-details">Release details</a> table.</li>
               </list>
         </snippet>
         <snippet>
            <p><strong>Kotlin plugin</strong></p>
            <p>Make sure that the Kotlin plugin is updated to the latest version. To do that, on the Android Studio welcome screen, select <strong>Plugins | Installed</strong>. Click <strong>Update</strong> next to Kotlin.</p>
         </snippet>
   </def>
   <def title="Command line">
            <p>Make sure you have all the necessary tools installed:</p>
            <list>
              <li><code>command not found: brew</code> — <a href="https://brew.sh/">install Homebrew</a>.</li>
              <li><code>command not found: java</code> — <a href="https://www.oracle.com/java/technologies/javase-downloads.html">install Java</a>.</li>
           </list>
    </def>
   <def title="Still having trouble?">
            <p>Share your problems with the team by <a href="https://kotl.in/issue">creating a YouTrack issue</a>.</p>
            <p>For a smoother multiplatform experience, you can also try <a href="https://www.jetbrains.com/help/kotlin-multiplatform-dev/fleet.html">JetBrains Fleet</a>: it integrates with Compose Multiplatform and allows writing Swift code without switching to Xcode, with less IDE juggling overall.</p>
   </def>
</deflist>

## Get help

* **Kotlin Slack**. Get an [invite](https://surveys.jetbrains.com/s3/kotlin-slack-sign-up) and join the [#multiplatform](https://kotlinlang.slack.com/archives/C3PQML5NU) channel.
* **Kotlin issue tracker**. [Report a new issue](https://youtrack.jetbrains.com/newIssue?project=KT).
