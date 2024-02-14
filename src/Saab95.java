import java.awt.*;

public class Saab95 extends NormalCar {
    private boolean turboOn;

    
    public Saab95(double x, double y) {
        super(2,110, Color.red,"Saab95", x, y);
        turboOn = false;
    }
    public Saab95() {
        super(2,110, Color.red,"Saab95");
        turboOn = false;
    }


    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
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
