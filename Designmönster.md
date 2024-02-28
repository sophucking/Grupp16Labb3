# Designmönster
## Observer pattern
### Vart används, avsiktligt eller oavsiktligt?
- Använder observers för att känna av när knappar trycks och när timern ger signaler. Inte vi som implementerade fanns i befintliga koden vi fick som del av projektet. 

#### Löser designproblem:
- Låter oss uppdatera vår view och modell sammtidigt som vi kan hålla oss till MVC
- Låter oss också följa DIP, observers/listeners är en abstraktion som vår model kan använda sig av utan att behöva veta vad för specifikt view vi har. 

### Kan använda för förbättra
- Varje gång modellen uppdateras vid varje nytt tidssteg kan en signal skickas till alla tillagda observers/listeners. 

#### Löser designproblem / varför ej använda:
- Låter oss följa SOC och MVC, kan separera model och view och behöver inte ha en klass som ser till att både model och grafik är synkade.


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



## State pattern
### Vart används, avsiktligt eller oavsiktligt?
- 

#### Löser designproblem:
- 

### Kan använda för förbättra
- 

#### Löser designproblem / varför ej använda:
- 



## Composite pattern
### Vart används, avsiktligt eller oavsiktligt?
- 

#### Löser designproblem:
- 

### Kan använda för förbättra
- 

#### Löser designproblem / varför ej använda:
- 



