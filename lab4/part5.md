# Del 5 besvarad snabbt i text

## Kan vi lägga till denna funktionalitet utan att ändra existerande klasser?

Vi kan inte utöka våran funktionalitet utan att ändra I klassfilerna.
Detta är negativ sak eftersom det bryter mot OCP.
Vi hade helst haft en parameter till controller som bestämmer vilka knappar som fins för att undvika detta problem.
Vi hade också helst haft ett factory pattern som tillåter skapande av nya bilar utan att manuellt göra detta eller ändra i modellen.

Addendum: We *could* do this if we wrap all the existing classes in some new wrappers with more functionality,
possibly employing some decorator pattern. However this would be more work than its worth at this time.


### side-note:
Vi insåg efter implementering att vi kan ge vår view fler paneler eller knappar utan att behöva ändra i källkoden. JFrame och JPanel har inbyggd implementation att lägga till fler JComponent som inte döljs i vår kod. 

## relevant design patterns

- Factory method pattern: skapa bilar on the fly
- Composite pattern: let each part of the MVC model handle each thing on their own
- State pattern: Behaviour changes depending on the amount of cars already present

