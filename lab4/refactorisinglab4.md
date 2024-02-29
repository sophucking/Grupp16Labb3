# MVC

- visualitem har brutits ut från vehicle simulation -> skrivits om till att använda decorator pattern 
- - imagepointpair hanteras av visualitem
- Flytta CarView till application och gör till ApplicationWindow, ingen dependency mellan carview och vehiclecontroller längre
- - Delegera all kontroll till controller.
- out of bounds, updatecars, move har flyttats till modellen
- bryt isär vehicle simulation och flytta main metoden samt alla icke model beteenden till en ny application.
- Låt application hålla i application window och hantera listener patterns 
- 