# REFACTORING PLANS

- (D) <- Done!
- (\<name\>) <- Assigned/Started by

- (Daniell) Använd decorator patterns i bil-paketet

- (Sophia, vilma) Visualitem har brutits ut från vehicle simulation -> skrivits om till att använda decorator pattern 
- - Imagepointpair byts mot av visualitem
- (Nikhil, on halt till visual is done) Bryt isär vehicle simulation och flytta main metoden samt alla icke model beteenden till en ny application.
- - Flytta CarView till application och gör till ApplicationWindow, ingen dependency mellan carview och vehiclecontroller längre
- - Delegera all kontroll till controller som sedan styr modellen
- Out of bounds, updatecars, move flyttas till modellen
- Låt application hålla i application window och hantera listener patterns
  