# Model-View-Controller

- - <-means UML has been updated

## Avvikelser i ursprungliga användargränssnittet

- CarController: använder både CarView och DrawPanel, tar hand om uppdatering av model, har main-metoden
    - ansvarar för controll, view, model och application

- CarView: använder både CarController och DrawPanel, ritar knappar deligerar knapptryck till CarController, deligerar ritande av bilar till DrawPanel
    - ansvarar för view, (widgets kan vara antingen controller eller application beroende på, smaksak vart man vill ha dem)

- DrawPanel, ok, bara view

### Vad borde ha gjorsts smartare?

- uppdatering av modellens tillstånd bör hanteras i modellen inte controll

### Vad borde ha gjorsts dummare?

- widgets borde inte vara i view

### Vad borde ha gjorsts tunnare?

- CarController ska inte hantera view eller model, main metoden ska vara i en application

## Vad har åtgärdats och inte

### VehicleController

- \+ Har inget att göra med view längre
- \+ Main metod flyttad
- - \- Har fortfarande logik som bestämmer var världens kant är, detta bör hanteras av modellen

### CarView

- \+\- Inte ändrat mycket ur MVC synpunkt 

### DrawPanell

- \+\- ingen ändring ur MVC synpunkt

### Simulation (Application) <- (Changed to model)

- - \+ (FLYTTAD TILL EN NEW APPLICATION KLASS) Har nu main metod samt håller i alla andra delar
- - \- Har logik som hanterar workshops. Bör flyttas till modellen
- - \- Hanterar bilder åt view, bör göras med någon form av decorator pattern eller liknande
