# Birthdays app coding challenge
This app was created by Dmitry Guselnikov on Dec 9, 2021 for Chalkboard coding challenge.

## Tech stack:
This app uses\
MVVM architecture\
Live data\
Repository pattern for implementing SSOT\
Interactor pattern\
Retrofit for retrieving data\
Koin for dependency injections

## How to install the app:
Clone the repository\
In Android Studio go to File -> Open, then navigate to the folder you cloned the repo\
Click OK\
Wait until the build process and indexing complete\
Hit Run -> Run 'app'

## How to run the tests
Open terminal\
From the root folder run:
```bash
./gradlew test
```
Also you may want to choose Run -> Run 'PeopleRepositoryUnitTest' from the Android Studio menu

## If I had more time I would
Implement the remote repository with parameters for max number of people\
Implement pagination\
Make sure the code has no warnings\
Write more useful unit tests\
Improve error handling

## Why did I use those technologies
MVVM, LiveData and Repository pattern because it fast, well documented and recommended by Google\
Koin because it is very convenient for small and middle-size projects for changing implementations if needed

## You can find me here
On [Stackoverflow](https://stackoverflow.com/users/1005846/dmitry-guselnikov) \
On [Github](https://github.com/elf-zwolf)