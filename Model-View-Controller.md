# Model-View-Controller
## Avvikelser i ursprungliga användargränssnittet
- CarController: använder både CarView och DrawPanel, tar hand om uppdatering av model, har main-metoden
-- ansvarar för controll, view, model och application
- CarView: använder både CarController och DrawPanel, ritar knappar deligerar knapptryck till CarController, deligerar ritande av bilar till DrawPanel
-- ansvarar för view, (widgets, kan vara antingen view, controller eller application beroende på )
- DrawPanel, ok, bara view. 
### Vad borde ha gjorsts smartare?
- uppdatering av modellens tillstånd bör hanteras i modellen inte controll. 
### Vad borde ha gjorsts dummare?

### Vad borde ha gjorsts tunnare?
