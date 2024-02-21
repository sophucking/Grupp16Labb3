
import javax.swing.*;

import Vehicles.Cargo;
import Vehicles.IsVolvo;
import Vehicles.Saab95;
import Vehicles.ScaniaV8;
import Vehicles.Volvo240;
import Vehicles.Workshop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Vehicles.*;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10; // 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener()); // move

    // The frame that represents this instance View of the MVC pattern
    CarView frame; // move
    // A list of cars, modify if needed
    ArrayList<IsVehicle> cars = new ArrayList<>();

    GraphicalVolvoWorkshop volvoWorkshop;

    // methods:

    public static void main(String[] args) { // move
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(0, 0)); 
        cc.cars.add(new Saab95(0, 100));
        cc.cars.add(new ScaniaV8<Cargo>(0, 200));
        cc.cars.add(new Volvo240(0, 300));
        cc.initWorkshop(10, 300, 300, "pics/VolvoBrand.jpg");

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    private void initWorkshop(int capacity, int x, int y, String imagePath) {
        volvoWorkshop = new GraphicalVolvoWorkshop(capacity, x, y, imagePath);
        volvoWorkshop.openStorage();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // int i = 0;
            // for (GroundVehicle car : cars) {
            for (int i = 0; i < cars.size(); i++) {
                IsVehicle car = cars.get(i);
                moveCar(car);
                updateVisuals(i, car);
                workshopInteraction(car);
            }
        }
    }

    private void workshopInteraction(IsVehicle car) {
        if (IsVolvo(car)) {
            if (workshopCollision(car)) {
                storeIfOpen(car);
            }
        }
    }

    private void storeIfOpen(IsVehicle car) {
        if (volvoWorkshop.isStorageOpen()) {
            storeCarInWorkshop(car);
        }
    }

    private void storeCarInWorkshop(IsVehicle car) {
        volvoWorkshop.storeThing((IsVolvo) car);
        cars.remove(car);
        frame.drawPanel.removeImage(car); //give call to listener/observer
    }

    private boolean IsVolvo(IsVehicle car) {
        return car instanceof IsVolvo;
    }

    private void updateVisuals(int i, IsVehicle car) {
        int x = (int) Math.round(car.getPosition().getX());
        int y = (int) Math.round(car.getPosition().getY());

        frame.drawPanel.moveit(i, x, y);
        // repaint() calls the paintComponent method of the panel
        frame.drawPanel.repaint();
    }

    private void moveCar(IsVehicle car) {
        worldHasBouncyWalls(car);
        car.move();
    }

    private void worldHasBouncyWalls(IsVehicle car) {
        if (frame.isOutOfBounds((int) car.getPosition().x, (int) car.getPosition().y)) {
            car.turnLeft(Math.PI);
        }
    }

    private void enableTurboIfHas(IsVehicle car) {
        if (car instanceof HasTurbo) {
            ((HasTurbo)car).setTurboOn();
        }
    }

    private void disableTurboIfHas(IsVehicle car) {
        if (car instanceof HasTurbo) {
            ((HasTurbo)car).setTurboOff();
        }
    }


    private void lowerBedIfTippable(IsVehicle car) {
        if (car instanceof Tippable) {
            ((Tippable) car).lowerStorage(70);
        }
    }

    private void liftBedIfTippable(IsVehicle car) {
        if (car instanceof Tippable) {
            ((Tippable) car).raiseStorage(70);
        }
    }

    /* private <T extends IsVehicle> ArrayList<T> findAllOfType(T IsVehicle) {
        ArrayList<T> carList = new ArrayList<>();
        cars.forEach((IsVehicle car) -> {
            addIfMatchType(carList, car, IsVehicle);
        });
        return carList;
    } */

    /* private <T extends IsVehicle> void addIfMatchType(ArrayList<T> carList, IsVehicle car, T vehicleType) {
        if (carTypeMatch(car, vehicleType)) {
            carList.add((T) car);
        }
    } */

    /* private <T extends IsVehicle> boolean carTypeMatch(IsVehicle car, T vehicleType) {
        return vehicleType.getModel().equals(car.getModel());
    } */

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IsVehicle car : cars) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (IsVehicle car : cars) {
            car.brake(brake);
        }
    }

    public void startAllEngines() {
        for (IsVehicle car : cars) {
            car.startEngine();
        }
    }

    public void stopAllEngines() {
        for (IsVehicle car : cars) {
            car.stopEngine();
        }
    }

    // REDOTHESE
    public void turnTurboOn() { // instead check interface HasTurbo
        for (IsVehicle car : cars) { 
            enableTurboIfHas(car);
        }
    }

    public void turnTurboOff() { // instead check interface HasTurbo
        for (IsVehicle car : cars) { 
            disableTurboIfHas(car);
        }
    }

    public void liftBed() { // instead check interface Tippable
        for (IsVehicle car : cars) { 
            liftBedIfTippable(car);
        }
    }

    public void lowerBed() {// instead check interface Tippable
        for (IsVehicle car : cars) { 
            lowerBedIfTippable(car);
        }
    }

    private boolean workshopCollision(IsVehicle car) {
        int carLeftEdge = (int) car.getPosition().x;
        int carRightEdge = carLeftEdge + 110;
        int carTopEdge = (int) car.getPosition().y;
        int carBottomEdge = carTopEdge + 80;
        int shopLeftEdge = volvoWorkshop.getX();
        int shopRightEdge = volvoWorkshop.getX() + volvoWorkshop.getSize();
        int shopTopEdge = volvoWorkshop.getY();
        int shopBottomEdge = volvoWorkshop.getY() + volvoWorkshop.getSize();
        return (((shopLeftEdge < carRightEdge && carRightEdge < shopRightEdge)
                || (shopLeftEdge < carLeftEdge && carRightEdge < shopRightEdge)) &&
                ((shopTopEdge < carTopEdge && carTopEdge < shopBottomEdge)
                        || (shopTopEdge < carBottomEdge && carBottomEdge < shopBottomEdge)));
    }

    private class GraphicalVolvoWorkshop {
        private final Workshop<IsVolvo> workshop;
        private final int x;
        private final int y;
        private final String imagePath;
        private final int size;

        public GraphicalVolvoWorkshop(int capacity, int x, int y, String imagePath) {
            workshop = new Workshop<>(capacity);
            this.x = x;
            this.y = y;
            this.imagePath = imagePath;
            this.size = 100;
        }

        public void storeThing(IsVolvo car) {
            workshop.storeThing(car);
        }

        public boolean isStorageOpen() {
            return workshop.isStorageOpen();
        }

        public void openStorage() {
            workshop.openStorage();
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String getImagePath() {
            return imagePath;
        }

        public int getSize() {
            return size;
        }

    }

    public int getWorkshopX() {
        return volvoWorkshop.getX();
    }

    public int getWorkshopY() {
        return volvoWorkshop.getY();
    }

    public String getWorkshopImagePath() {
        return volvoWorkshop.getImagePath();
    }
}
