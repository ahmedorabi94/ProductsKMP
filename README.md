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
  <img src="https://github.com/ahmedorabi94/ProductsKMP/assets/7644709/8a756d66-3df3-4fb0-954e-ac4c2ea9f1f4" width="250px" /> 
  <img src="https://github.com/ahmedorabi94/ProductsKMP/assets/7644709/26d4d9f5-9539-45c3-9c4e-f89a1d21bde7" width="250px" />  
 <img src="https://github.com/ahmedorabi94/ProductsKMP/assets/7644709/b22302ce-44d3-4ece-9c86-2d1062035d81" width="250px" />  
</div>

 ## Built With 🛠
 - Compose Multiplatform
 - Moko Shared View Model
 - Ktor
 - Koin
 - Voyager multiplatform navigation library

# In progress


