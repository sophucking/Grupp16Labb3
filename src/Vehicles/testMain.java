package Vehicles;

public class testMain {
    public static void main(String[] args) {
        // om du vill ha en Volvo exklusiv workshop får du skapa en tom interface som agerar som en "label"
        // till alla Volvo bilar.
        Workshop<Volvo240> volvo240Workshop = new Workshop<>(10);
        Workshop<IsVehicle> workshop = new Workshop<>(10);

        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        VolvoFL volvoTruck = new VolvoFL();

        workshop.storeThing(saab);
        workshop.storeThing(volvoTruck);
        workshop.storeThing(volvo);
        //volvo240Workshop.storeThing(saab);
        //volvo240Workshop.storeThing(volvoTruck);
        volvo240Workshop.storeThing(volvo);
    }
}
