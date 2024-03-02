package Model.Vehicles;
import java.awt.*;

public interface IsVehicle extends Movable, Bumpable{

    String getModel();

    int getNrDoors();

    double getEnginePower();

    double getCurrentSpeed();

    Color getColor();

    void setColor(Color clr);

    void startEngine();

    void stopEngine();

    boolean isEngineOn();

    void gas(double amount);

    void brake(double amount);
}
