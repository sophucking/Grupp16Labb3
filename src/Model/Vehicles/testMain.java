package Model.Vehicles;


public class testMain {
    public static void main(String[] args) {
        // om du vill ha en Volvo exklusiv workshop får du skapa en tom interface som
        // agerar som en "label"
        // till alla Volvo bilar.
        Workshop<Volvo240> volvo240Workshop = new Workshop<>(10,0,0,0,0);
        Workshop<IsVehicle> workshop = new Workshop<>(10,0,0,0,0);

        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        VolvoFL volvoTruck = new VolvoFL();

        workshop.addToStorage(saab);
        workshop.addToStorage(volvoTruck);
        workshop.addToStorage(volvo);
        // //volvo240Workshop.addToStorage(saab);
        // volvo240Workshop.addToStorage(volvoTruck);
        volvo240Workshop.addToStorage(volvo);
    }
}
