# Products App

This is a Kotlin Multiplatform project targeting Android, iOS, Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…


<div align="center">
  <img src="https://github.com/ahmedorabi94/ProductsKMP/assets/7644709/02ff92e8-5309-4a6e-a8fe-1b89cef7c148" width="250px" />  
  <img src="https://github.com/ahmedorabi94/ProductsKMP/assets/7644709/08f5742e-8fb8-45a1-aac7-8af0d88170c2" width="250px" />  
  <img src="https://github.com/ahmedorabi94/ProductsKMP/assets/7644709/3259eaa8-309f-4489-900e-57af1074a4ae" width="250px" />  
</div>

 ## Built With 🛠
 - Compose Multiplatform
 - Moko Shared View Model
 - Ktor
 - Koin
 - Voyager multiplatform navigation library


