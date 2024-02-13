import java.awt.*;

public class Volvo240 extends NormalCar {

    private final static double TRIMFACTOR = 1.25;

    public Volvo240() {
        super(2, 100, Color.black, "Volvo240");
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * TRIMFACTOR;
    }
}
