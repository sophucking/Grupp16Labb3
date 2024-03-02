package Model.Vehicles;
import java.awt.*;

public class Volvo240 extends NormalCar implements IsVolvo{

    private static final double TRIMFACTOR = 1.25;

    public Volvo240(double x, double y, double width, double height) {
        super(2, 100, "Volvo240", x, y, Color.black, width, height);
    }

    public Volvo240() {
        super(2, 100, "Volvo240", Color.black, 100,100);
    }


    void setSpeedFactor() {
        baseGroundVehicle.setSpeedFactor(TRIMFACTOR);
    }


}
