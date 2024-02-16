# Rafactorising plan

- Create a (Run)CarSimulation class containing the main method and the Timer/TimerListener
- CarSimulation has both a CarView and a CarController object. 
- Create an addCar method in CarSimulation which adds a car to CarController and a graphical representation to the drawPanel. Same with the workshop. 
- TimerListener in CarSimulation calls CarView and CarController to update each timestep
- CarController no longer needs dependency of CarView
- Redo ImagePointPair (and possibly rename) to replaced pint with int x, y and create own move method
- Redo implementation of adding to workshop, image does not need to be removed? car can remain beneath workshop
- ? remove the 'removeImage' method form DrawPanel
- TurnTurboOn/Off and Lift/LowerBed methods use interface instead of specificly Saab and Scania. 
- Change the addCar method in CarView
- CarView constructor (and CarController) should have the window size as input parameter

- Create (abstract) VisualItem superclass with VisualCar and VisualWorkshop subclasses
Each of (sub)classes contains either a car or a workshop as well as the position of the items and the path to the corresponding image
CarSimulation can then have a list of VisualCars and loop over the elements calling on the seperate classes and giving them the data needed to update. 

No longer necessary for DrawPanel and CarControll to have their own lists, ?CarControll then only need usage depenency on GroundVehicle. 