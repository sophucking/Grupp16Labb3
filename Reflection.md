# What is wrong and what can be improved

## part 2
### Dependency inversion principle, cohesion and coupling

- CarView måste bero på CarController och DrawPanel
- CarController och CarView och DrawPanel är så sammankopplade att de inte går emot SoC, de är dock separate klasser pga single responsibility
- CarController ska vara den enda som beror på GroundVehicle osv minimera beroenden utåt
- Se över en del variabler och göra private, public osv
- DiP is violated in car controller where we check for a Saab instead of having a HasTurbo interface (or something similar)
- 


## part 3
### Separation of Concern (SoC) och Single Responsibility Principle (SRP).

- DrawPanel: ritar ut bilder av bilar och workshop, vet vart de ska ritas ut och hur
- CarView: UI, om omjekt är utanför rutan, säger till DrawPanel vad som ska ritas och vart, säger till CarController att knappar används. 
- CarController: Har och kontrollerar bilarna, skickar signal att uppdatera grafiken uterfter att bilarna flyttas.  

- DrawPanel och CarView bör inte ha något beroende av GroundVehicle

- CarSimulation class (med main metod) som lägger till bilar i CarController samt DrawPanel separat. Har Timer och kallar metoderna som hanterar vad som händer vid varje tidssteg i varje separat class. 