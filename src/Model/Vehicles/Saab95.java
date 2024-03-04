package Model.Vehicles;

import java.awt.*;

import Model.Vehicles.StatePatters.TurboOff;
import Model.Vehicles.StatePatters.TurboOn;
import Model.Vehicles.StatePatters.TurboState;

public class Saab95 extends NormalCar implements HasTurbo {
    private TurboState state;

    public Saab95(double x, double y, double width, double height) {
        super(2, 110, "Saab95", x, y, Color.red, width, height);
        state = TurboOff.getState();
    }

    public Saab95() {
        this(0, 0, 100, 100);
    }

    @Override
    public void setTurboOn() {
        state = TurboOn.getState();
        setSpeedFactor();
    }

    @Override
    public void setTurboOff() {
        state = TurboOff.getState();
        setSpeedFactor();
    }

    @Override
    public boolean isTurboOn() {
        return state.isTurboOn();
    }

    void setSpeedFactor() {
        try {
            baseGroundVehicle.setSpeedFactor(state.getSpeedFactorMultiplier());
        } catch (NullPointerException e) {
            baseGroundVehicle.setSpeedFactor(1);
        }
        
    }
}
