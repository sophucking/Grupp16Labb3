package Model.Vehicles;

import java.awt.*;

public class ScaniaV8<T> extends Truck<T> implements Tippable<T> {

    private double storageAngle;
    private ScaniaState state;

    public ScaniaV8(double x, double y) {
        super(200, Color.white, "ScaniaV8", 10, x, y);
        this.storageAngle = 0.0;
    }

    public ScaniaV8() {
        super(200, Color.white, "ScaniaV8", 10);
        this.storageAngle = 0.0;
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
            state = ScaniaStoppedDown.getState();
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
        }
    }
}
