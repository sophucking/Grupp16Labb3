package View;

import Model.Vehicles.IsVehicle;

public class VisualVehicle extends ConcreteVisualItem {
    private final IsVehicle vehicle;

    VisualVehicle(IsVehicle vehicle, String imagePath) {
        super((int) vehicle.getPosition().getX(),
                (int) vehicle.getPosition().getY(),
                imagePath, 100, 60);
        this.vehicle = vehicle;
    }
}



