# What is wrong and what can be improved

## part 2
### Dependency inversion principle, cohesion and coupling

- CarView måste bero på CarController och DrawPanel
- CarController och CarView och DrawPanel är så sammankopplade att de inte går emot SoC, de är dock separate klasser pga single responsibility
- CarController ska vara den enda som beror på GroundVehicle osv minimera beroenden utåt
- Se över en del variabler och göra private, public osv
- DiP is followed