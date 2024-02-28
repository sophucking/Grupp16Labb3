# Refactorising plan

- - <- these points are done
- (Name) <- these points are currently assigned

- - Remove inheritance in favor for composition in vehicle package.

- - Change CarView to only depend on DrawPanel instead of JPanel and DrawPanel(DrawPanel extends JPanel). 
- - Create a (Run)CarSimulation class containing the main method and the Timer/TimerListener. 
CarSimulation has both a CarView and a CarController object. 
- - TimerListener calls the update method in CarSimulation
- - Update in CarSimulation calls CarView and CarController to update each timestep
- - CarController no longer needs dependency of CarView
- - Redo ImagePointPair (and possibly rename) to replaced point with int x, y and create own move method
- (Daniel) Redo implementation of adding to workshop, image does not need to be removed? car can remain beneath workshop
- - TurnTurboOn/Off and Lift/LowerBed methods use interface instead of specifically Saab and Scania. 
- - Change the addCar method in CarView
- - CarView constructor (and CarController) should have the window size as input parameter

### Maybe

- - Create (abstract) VisualItem superclass with VisualCar and VisualWorkshop subclasses
Each of (sub)classes contains either a car or a workshop as well as the position of the items and the path to the corresponding image. 
CarSimulation can then have a list of VisualCars and loop over the elements calling on the separate classes and giving them the data needed to update. 
No longer necessary for DrawPanel and CarControl to have their own lists, ?CarControl then only need usage depenency on GroundVehicle. 
- - a list of cars need to be inside VehicleController for the buttons to work

## WHY?

- Less dependency on GroundVehicle (and vehicle package)
- Adding private everywhere possible to follow OCP
- Following DIP by depending on abstractions instead of concrete implementations
- Increasing SRP by moving storing cars and the Timer from CarController. The responsibility of CarController in now only to mutate the cars. 

- Using DrawPanel instead of JPanel increases cohesion and decreases coupling
- TimeListener should tell CarSimulation to update, not handle anything to do with how the update is performed
- Remove circular dependency (SRP) between CarController and CarView
- Removing unnecessary dependency on Point
- DIP make TurnTurboOn/Off abstract by using interface
- Decrease coupling (even DIP) by sending position and picture to CarView instead of GroundVehicle
