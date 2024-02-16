# Rafactorising plan

- Create a (Run)CarSimulation class containtning the main method and the Timer/TimerListener
- CarSimulation has both a CarView and a CarController object. 
- Create an addCar method in CarSimulation which adds a car to CarController and a graphical representation to the drawPanel. Same with the workshop. 
- TimerListener in CarSimulation calls CarView and CarController to update each timestep
- CarController no longer needs dependency of CarView
- Redo ImagePointPair (and possibly rename) to replaced pint with int x, y and create own move method

