package Model.Vehicles;

import java.awt.*;

import Model.Vehicles.StatePatters.*;

public class ScaniaV8<T> extends Truck<T> implements Tippable<T> {
    private double storageAngle;
    private ScaniaState state;

    public ScaniaV8(double x, double y, double width, double height) {
        super(200,  "ScaniaV8", 10,x,y, Color.white, width, height);
        this.storageAngle = 0.0;
        state = ScaniaStoppedDown.getState();
    }

    public ScaniaV8() {
        this(0, 0,100,100);
    }

    @Override
    public double getStorageAngle() {
        return this.storageAngle;
    }

    private void setStorageAngle(double angle) {
        storageAngle = Math.clamp(angle, 0, 70);
        if (storageAngle <= 0.001) {
            state = ScaniaStoppedDown.getState();
        } else {
            state = ScaniaStoppedUp.getState();
        }
    }

    @Override
    public void lowerStorage(double angle) {
        if (state.lowerStorageBed()) {
            setStorageAngle(storageAngle - angle);
        }
    }

    @Override
    public void raiseStorage(double angle) {
        if (state.raiseStorageBed()) {
            setStorageAngle(storageAngle + angle);
        }
    }

    @Override
    public void gas(double ammount) {
        if (state.gasVehicle()) {
            super.gas(ammount);
            state = ScaniaMovingDown.getState();
        }
    }

    @Override public void brake(double amount) {
        super.brake(amount);
        if (getCurrentSpeed() < 0.001) {
            state = ScaniaStoppedDown.getState();
        }
    }
}
