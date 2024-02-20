package Vehicles;
import java.awt.*;

public class Saab95 extends NormalCar implements HasTurbo {
    private boolean turboOn;

    
    public Saab95(double x, double y) {
        super(2,110, Color.red,"Saab95", x, y);
        turboOn = false;
    }
    public Saab95() {
        super(2,110, Color.red,"Saab95");
        turboOn = false;
    }

    @Override
    public void setTurboOn() {
        turboOn = true;
    }

    @Override
    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    public boolean isTurboOn(){
        return turboOn;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) {
            turbo = 1.3;
        }
        return getEnginePower() * 0.01 * turbo;
    }
}
