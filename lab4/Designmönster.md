# Designmönster
 
- - <- klart!

## Observer pattern
### Vart används, avsiktligt eller oavsiktligt?
- Använder observers för att känna av när knappar trycks och när timern ger signaler. Inte vi som implementerade fanns i befintliga koden vi fick som del av projektet. 

#### Löser designproblem:
- Låter oss uppdatera vår view och modell sammtidigt som vi kan hålla oss till MVC
- Låter oss också följa DIP, observers/listeners är en abstraktion som vår model kan använda sig av utan att behöva veta vad för specifikt view vi har. 

### Kan använda för förbättra
- - Varje gång modellen uppdateras vid varje nytt tidssteg kan en signal skickas till alla tillagda observers/listeners. 

#### Löser designproblem / varför ej använda:
- Låter oss följa SOC och MVC, kan separera model och view och behöver inte ha en klass som ser till att både model och grafik är synkade.

- OpenClose-Principle/extensability? för att lägga till nya knappar?


## Factory Method
### Vart används, avsiktligt eller oavsiktligt?
- används ej, hade inte löst några problem

#### Löser designproblem:
- kan ge lägre coupling genom att en factory metod beror på utomstående klasser och innomstående klasser sedan beror på factory metoden

### Kan använda för förbättra
- inget för tillfället

#### Löser designproblem / varför ej använda:
- Factory method är användbar för att sänka coupling och höja cohesion.\
Men eftersom vi endast har en klass som beror på de tre bil-subklasserna där vi skulle kunna lägga en factory method mellan.\
Men eftersom det endast är en klass som har detta beroende gör en factory method inget för oss för tillfället.

- Open-Close principle: enklare att skapa nya bilar?

## State pattern
### Vart används, avsiktligt eller oavsiktligt?
- vi använder inte det i nuläget

#### Löser designproblem:
- inget just nu

### Kan använda för förbättra
- - Saab (olika gasmetoder beroende på turbon)
- - Storage various states (open closed/full empty)
- - Specialfall Scania 


#### Löser designproblem / varför ej använda:
- öka läsbarhet 
- minska buggrisk 
- höjer maintainability, extensability, och reusability)
- open/closed principle, underlättar extensability (t.ex. genom att lägga till nya states)

- SRP: de olika tillstånden separeras






## Composite pattern
### Vart används, avsiktligt eller oavsiktligt?
- alla fordon
- workshop
- application

#### Löser designproblem:
- ökar modularitet
- reusability
- readibility 
- höjer extensibility/OCP
- svagare dependencies 

### Kan använda för förbättra
- eventuellt bygga en fasad till model? 

#### Löser designproblem / varför ej använda:
- högre modularitet



