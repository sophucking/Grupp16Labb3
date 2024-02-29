package Controller;
import java.util.ArrayList;

import Model.Vehicles.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class VehicleController {
    private final ArrayList<IsVehicle> cars;
    private final int worldWidth;
    private final int worldHeight;
    private final int vehicleWidth;
    private final int vehicleHeight;


    // methods:
    public VehicleController(int width, int height, int vehicleWidth, int vehicleHeight) {
        cars = new ArrayList<>();
        worldWidth = width;
        worldHeight = height;
        this.vehicleWidth = vehicleWidth;
        this.vehicleHeight = vehicleHeight;
    }

    public void addVehicle(IsVehicle car) {
        cars.add(car);
    }

    public void removeVehicle(IsVehicle car) {
        cars.remove(car);
    }

    public void update(IsVehicle car) {
        moveCar(car);
    }

    private void moveCar(IsVehicle car) {
        worldHasBouncyWalls(car);
        car.move();
    }

    private void worldHasBouncyWalls(IsVehicle car) {
        if (isOutOfBounds(car)) {
            car.turnLeft(Math.PI);
        }
    }

    private boolean isOutOfBounds(IsVehicle car) {
        return (car.getPosition().getX() < -5) || (worldWidth - vehicleWidth + 5 < car.getPosition().getX()) 
         || (car.getPosition().getY() < -5) || (worldHeight - vehicleHeight + 5< car.getPosition().getY());
    }

    private boolean hasTurbo(IsVehicle car) {
        return car instanceof HasTurbo;
    }

    private boolean isTippable(IsVehicle car) {
        return car instanceof Tippable;
    }

    private void enableTurbo(IsVehicle car) {
        ((HasTurbo) car).setTurboOn();
    }

    private void disableTurbo(IsVehicle car) {
        ((HasTurbo) car).setTurboOff();
    }

    private void liftBed(IsVehicle car) {
        ((Tippable<?>) car).openStorage();
        ((Tippable<?>) car).raiseStorage(70);
    }

    private void lowerBed(IsVehicle car) {
        ((Tippable<?>) car).lowerStorage(70);
        ((Tippable<?>) car).closeStorage();
    }


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

    public void turnTurboOn() {
        for (IsVehicle car : cars) {
            if (hasTurbo(car)) {
                enableTurbo(car);
            }
        }
    }

    public void turnTurboOff() {
        for (IsVehicle car : cars) {
            if (hasTurbo(car)) {
                disableTurbo(car);
            }
        }
    }

    public void liftBed() {
        for (IsVehicle car : cars) {
            if (isTippable(car)) {
                liftBed(car);
            }
        }
    }

    public void lowerBed() {
        for (IsVehicle car : cars) {
            if (isTippable(car)) {
                lowerBed(car);
            }
        }
    }


}
