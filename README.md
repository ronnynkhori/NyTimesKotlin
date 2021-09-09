#  NY TIMES ARTICLES ANDROID APP (KOTLIN)

This is an Android mobile application that leverages NY times articles API and shows a list of articles in a master/detail flow pattern. The App is written in Kotlin using MVVM Clean Architecture 

## Dependencies
-   [Retrofit 2](https://square.github.io/retrofit/)  for API integration.
-   [Gson](https://github.com/google/gson)  for serialisation.
-   [Mockito](https://site.mockito.org/)  for implementing unit test cases.
-   [Glide](https://github.com/bumptech/glide)  for image loading.

## Package Structue
 - **Data** package contains classes relating to api, response and repository.
 - api
 - model
 - **UI** package contains classes for activities and adapters.
 - adapters
 - view
 - **Utils** package contains enums for activity states

## Setup & Installation
-   Download & Install  [Android Studio](https://developer.android.com/studio)
- Clone or download the project repository from github.
- Open project in Android Studio, wait for it  to build and sync sdk.
- Run the project using  `Run > Run 'app'`
- 
## Screenshots
![Screenshot_20210909_123742_com example nytimes](https://user-images.githubusercontent.com/17355327/132681979-bb46f17f-feaa-4bfc-a933-bfb7dae6365f.jpg)



## Unit Tests
Run the tests using either class by class `Right-Click > Run 'ArticlesActivityTest'` or by using the following command from terminal window `./gradlew test`


## Code Coverage
Code coverage report is deplayed on ArticlesActivityTest Report 
Report summary can be found at NYTimes/app/build/reports/tests/testDebugUnitTest/index.html


## Developer
Ronnie Nkhori [-ronnyrodneynkhori@gmail.com](mailto:-ronnyrodneynkhori@gmail.com) +(267) 77015757
