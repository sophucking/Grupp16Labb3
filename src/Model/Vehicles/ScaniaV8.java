package Model.Vehicles;

import java.awt.*;

import Model.Vehicles.StatePatters.*;

public class ScaniaV8<T> extends Truck<T> implements Tippable<T> {
    private double storageAngle;
    private TippableState state;

    public ScaniaV8(double x, double y, double width, double height) {
        super(200,  "ScaniaV8", 10,x,y, Color.white, width, height);
        this.storageAngle = 0.0;
        updateState();
    }

    public ScaniaV8() {
        this(0, 0,100,100);
    }

    @Override
    public double getStorageAngle() {
        return this.storageAngle;
    }

    private Void setStorageAngle(double angle) {
        storageAngle = Math.clamp(angle, 0, 70);
        updateState();
        return null;
    }

    @Override
    public void lowerStorage(double angle) {
        state.lowerStorageBed(this::setStorageAngle, storageAngle - angle);
    }

    @Override
    public void raiseStorage(double angle) {
        state.raiseStorageBed(this::setStorageAngle, storageAngle + angle);
    }

    private Void gasVehicle(double amount) {
        super.gas(amount);
        return null;
    }


    @Override
    public void gas(double amount) {
        state.gasVehicle(this::gasVehicle, amount);
        updateState();
    }

    @Override public void brake(double amount) {
        super.brake(amount);
        updateState();
    }

    private void updateState() {
        boolean down = storageAngle <= 0.01;
        double speed = getCurrentSpeed();
        boolean stationary = speed <= 0.01;
        if (down && stationary) {
            state = TippableStoppedDown.getState();
        } else if (!stationary) {
            state = TippableMovingDown.getState();
        } else if (!down) {
            state = TippableStoppedUp.getState();
        } else {
            throw new IllegalStateException("Exception: ScaniaV8.state : TippableState, undefined state has been reached.");
        }
    }
}
