(Core) 
Uses Mvvm,Repository pattern,Dependency Injection with Hilt,RxJava,LiveData.
Mvvm for handling screen level states and surviving from configuration changes.
Repository pattern to easily replace the data sources (eg. network data sources like firebase/retrofit, local datasources room/realm).
Dependency Injection wipe out the boiler plate codes.
RxJava for asynchronous procedures and reactive codes (network calls).
LiveData for observable data holders with lifecycle awareness.

(Common)
Hiding Api key,Base url and end point in gradle.properties(to take more time for reverse engineering).
Avoid hard coded values.
Supporting offline mode with room persistence library and refresh with updated data when connection is back online.
