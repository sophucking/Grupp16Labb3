package Model.Vehicles;
import java.awt.*;

public class Saab95 extends NormalCar implements HasTurbo {
    private boolean turboOn;

    
    public Saab95(double x, double y, double width, double height) {
        super(2,110, "Saab95", x, y, Color.red, width, height);
        turboOn = false;
    }
    public Saab95() {
        super(2,110, "Saab95", Color.red, 100,100);
        turboOn = false;
    }

    @Override
    public void setTurboOn() {
        turboOn = true;
        setSpeedFactor();
    }

    @Override
    public void setTurboOff() {
        turboOn = false;
        setSpeedFactor();
    }

    @Override
    public boolean isTurboOn(){
        return turboOn;
    }

    void setSpeedFactor() {
        double turbo = 1;
        if (turboOn) {
            turbo = 1.3;
        }
        baseGroundVehicle.setSpeedFactor(turbo);
    }
}
