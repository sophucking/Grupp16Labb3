package Model.Vehicles;
import java.awt.*;

public class Volvo240 extends NormalCar implements IsVolvo{

    private static final double TRIMFACTOR = 1.25;

    public Volvo240(double x, double y) {
        super(2, 100, Color.black, "Volvo240", x, y);
    }

    public Volvo240() {
        super(2, 100, Color.black, "Volvo240");
    }


    void setSpeedFactor() {
        baseGroundVehicle.setSpeedFactor(TRIMFACTOR);
    }
}
