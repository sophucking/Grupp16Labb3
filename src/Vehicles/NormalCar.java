package Vehicles;
import java.awt.*;

// only exist as a label
public abstract class NormalCar extends GroundVehicle {
    public NormalCar(int nrDoors, double enginePower, Color color, String modelName, double x, double y) {
        super(nrDoors, enginePower, color, modelName, x, y);
    }

    NormalCar(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }
}
