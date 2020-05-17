# LovooApp
Sample Application showing architecture usage.

# Build steps:
- add a file "cred.properties" in the top level 
containing the username and password in below format:
USERNAME="XXXX"
PASSWORD="XXXX"

# Architecture used:
Clean architecture with MVVM pattern.

# Components used:
- databinding to remove boiler plate code
- live data for updating UI from View Model
- Coroutines for background thread execution
- RoomDB for local data persistance
- OkHttp3 for remote data 
- Repository Pattern
- MVVM pattern 
- Koin for Dependency Injection
- Mockito and JUnit for unit testing
- Circle CI for Continous Integration

# Overview:
I tried to use S.O.L.I.D principles along with clean MVVM architecture pattern to design the application. A little overview of some principles used extensively:

Single Responsibility:
Each class is doing one responsibility, For example:
Fragment only observes and loads the data from viewmodel on UI.
ViewModel is only loading data from repository.
Repository calls local or remote data source.
LocalDataSource calls the RoomDao to fetch and insert
RemoteDataSource calls the OkHttp3 Api to fetch data from backend.

Open-Closed Principle:
For my view holders, I used an abstract class and every view holder is implementing it, thus enforcing each extended class to provide the functionality. A new view holder can not break the old functionality.

Liskov substitution:
View holders extends one base class and implementing the "doBind" function and all derived classes use that to bind the data, thus not breaking the parent functionality.



Dependency Inversion:
Entities depends on abstract definations. For example:
AppRepository uses IRemoteDataSource and ILocalDataSource without knowing the implementation under the hood.


# Development Process:
If you check the commit history, You will see:
I started with inner most layer i.e RemoteDataSource then worked my way up to Repository then Usecase then ViewModel and finally Fragment. Allowing me to write tests of each layer. Making the code independent of higher modules. 

# Note:
I've code this application just to show case the architecture designing and coding. some of the logic is ommitted for example: corrent booking time insertion in db.
UI is basic as it was not part of the scope.





