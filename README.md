# Shaadi.comAssignment

This project simulates a Matrimonial App similar to Shaadi.com. It displays user match cards using data fetched from a remote API, and allows users to accept or decline the matches. The decisions are stored locally using Room, enabling full offline support and persistent behavior across app launches.

## Features:-

1. Fetch and display match profiles using <b>Paging 3</b>

2. Accept or reject match suggestions with <b>persisted local storage</b>

3. Offline support via <b>Room database caching</b>

4. Clean MVVM architecture using <b>Presentation, Domain,</b> and <b>Data layers</b>

5. Dependency injection with <b>Hilt</b>

6. Efficient image loading with <b>Glide</b>

7. Built using <b>Kotlin</b> and <b>Android Jetpack libraries</b>

## Architecture:-

The project follows a clean <b>MVVM (Model-View-ViewModel)</b> architecture and is divided into three main layers:

  ### 1. Presentation Layer
     a.) UI (Activity, Adapter, XML layouts)
  
     b.) ViewModel
  
     c.) Observes LiveData<PagingData<Person>> and updates the RecyclerView accordingly
  
  ### 2. Domain Layer
     
     a.) Person model class
  
     b.) Repository interface abstracting data sources
  
  ### 3. Data Layer
     
     a.) Retrofit-based RemoteDataSource
  
     b.) Room-based LocalDataSource
  
     c.) Paging RemoteMediator to sync data
  
     d.) Repository implementation that integrates remote and local sources

## Libraries Used:-

| Library                  | Purpose                               |
| ------------------------ | ------------------------------------- |
| **Retrofit**             | Networking and API calls              |
| **Room**                 | Local database for offline storage    |
| **Paging 3**             | Efficient pagination and offline sync |
| **Hilt**                 | Dependency Injection                  |
| **Glide**                | Image loading and caching             |
| **LiveData & ViewModel** | Lifecycle-aware UI updates            |

## How to Run the App:-
1. Clone the repository:
git clone [https://github.com/Rahula-12/Shaadi.comAssignment](https://github.com/Rahula-12/Shaadi.comAssignment)
2. Import project to Android Studio.
3. Run the app on an emulator or physical device.
4. If you want to download the apk and run it on your device, you can download it from:- [https://github.com/Rahula-12/Shaadi.comAssignment/releases/download/v1/app-debug.apk
](https://github.com/Rahula-12/Shaadi.comAssignment/releases/download/v1/app-debug.apk)
## Persistent Behavior:-

1. Once a user accepts or rejects a match, the decision is stored using Room.

2. On subsequent launches or offline usage, user choices remain intact.

3. RemoteMediator ensures fresh data while preserving local state.

## Screenshots:-

<p>
<img src="img.png" width="100" height="300">
<img src="img_1.png" width="100" height="300">
<img src="img_2.png" width="100" height="300">
</p>

## License:-

This project is for educational/demo purposes only. Not affiliated with Shaadi.com.




