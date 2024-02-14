import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<GroundVehicle> cars = new ArrayList<>();

    GraphicalVolvoWorkshop volvWorkshop;

    // methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(0, 0));
        cc.cars.add(new Saab95(0, 100));
        cc.cars.add(new ScaniaV8<Cargo>(0, 200));
        cc.initWorkshop(10, 300, 300, "pics/VolvoBrand.jpg");

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    private void initWorkshop(int capacity, int x, int y, String imagePath) {
        volvWorkshop = new GraphicalVolvoWorkshop(capacity, x, y, imagePath);
        volvWorkshop.workshop.openStorage();
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
                moveCar(cars.get(i));
                workshopInteraction(cars.get(i));
                updateVisuals(i, cars.get(i));
            }
        }
    }

    private void workshopInteraction(GroundVehicle car) {
        if (IsVolvo(car)) {
            if (workshopCollision(car)) {
                storeIfOpen(car);
            }
        }
    }

    private void storeIfOpen(GroundVehicle car) {
        if (volvWorkshop.workshop.isStorageOpen()) {
            storeCarInWorkshop(car);
        }
    }

    private void storeCarInWorkshop(GroundVehicle car) {
        volvWorkshop.workshop.storeThing((IsVolvo) car);
        cars.remove(car);
        frame.drawPanel.removeImage(car);
    }

    private boolean IsVolvo(GroundVehicle car) {
        return carTypeMatch(car, new Volvo240()) || carTypeMatch(car, new VolvoFL());
    }

    private void updateVisuals(int i, GroundVehicle car) {
        int x = (int) Math.round(car.getPosition().getX());
        int y = (int) Math.round(car.getPosition().getY());

        frame.drawPanel.moveit(i, x, y);
        // repaint() calls the paintComponent method of the panel
        frame.drawPanel.repaint();
    }

    private void moveCar(GroundVehicle car) {
        worldHasBouncyWalls(car);
        car.move();
    }

    private void worldHasBouncyWalls(GroundVehicle car) {
        if (frame.isOutOfBounds((int) car.getPosition().x, (int) car.getPosition().y)) {
            car.turnLeft(Math.PI);
        }
    }

    private <T extends GroundVehicle> ArrayList<T> findAllOfType(T groundVehicle) {
        ArrayList<T> carList = new ArrayList<>();
        cars.forEach((GroundVehicle car) -> {
            addIfMatchType(carList, car, groundVehicle);
        });
        return carList;
    }

    private <T extends GroundVehicle> void addIfMatchType(ArrayList<T> carList, GroundVehicle car, T vehicleType) {
        if (carTypeMatch(car, vehicleType)) {
            carList.add((T) car);
        }
    }

    private <T extends GroundVehicle> boolean carTypeMatch(GroundVehicle car, T vehicleType) {
        return vehicleType.getModel().equals(car.getModel());
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (GroundVehicle car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (GroundVehicle car : cars) {
            car.brake(brake);
        }
    }

    void startAllEngines() {
        for (GroundVehicle car : cars) {
            car.startEngine();
        }
    }

    void stopAllEngines() {
        for (GroundVehicle car : cars) {
            car.stopEngine();
        }
    }

    void turnTurboOn() {
        for (Saab95 saab95 : findAllOfType(new Saab95())) {
            saab95.setTurboOn();
        }
    }

    void turnTurboOff() {
        for (Saab95 saab95 : findAllOfType(new Saab95())) {
            saab95.setTurboOff();
        }
    }

    void liftBed() {
        for (ScaniaV8<Cargo> scaniaV8 : findAllOfType(new ScaniaV8<Cargo>())) {
            scaniaV8.raiseStorage(70);
        }
    }

    void lowerBed() {
        for (ScaniaV8<Cargo> scaniaV8 : findAllOfType(new ScaniaV8<Cargo>())) {
            scaniaV8.lowerStorage(70);
        }
    }

    boolean workshopCollision(GroundVehicle car) {
        int carLeftEdge = (int) car.getPosition().x;
        int carRightEdge = carLeftEdge + 110;
        int carTopEdge = (int) car.getPosition().y;
        int carBottomEdge = carTopEdge + 80;
        int shopLeftEdge = volvWorkshop.x;
        int shopRightEdge = volvWorkshop.x + volvWorkshop.size;
        int shopTopEdge = volvWorkshop.y;
        int shopBottomEdge = volvWorkshop.y + volvWorkshop.size;
        return (((shopLeftEdge < carRightEdge && carRightEdge < shopRightEdge) || (shopLeftEdge < carLeftEdge && carRightEdge < shopRightEdge)) &&
                ((shopTopEdge < carTopEdge && carTopEdge < shopBottomEdge) || (shopTopEdge < carBottomEdge && carBottomEdge < shopBottomEdge)));
    }

    class GraphicalVolvoWorkshop {
        Workshop<IsVolvo> workshop;
        int x;
        int y;
        String imagePath;
        int size;

        public GraphicalVolvoWorkshop(int capacity, int x, int y, String imagePath) {
            workshop = new Workshop<>(capacity);
            this.x = x;
            this.y = y;
            this.imagePath = imagePath;
            this.size = 100;
        }
    }
}
