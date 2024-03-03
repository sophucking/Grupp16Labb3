package View;

import Model.Vehicles.IsVehicle;

public class VisualVehicle extends ConcreteVisualItem {
    private final IsVehicle vehicle;

    VisualVehicle(IsVehicle vehicle, String imagePath) {
        super(imagePath, 100, 100);
        this.vehicle = vehicle;
    }


    @Override
    public double getX() {
        return vehicle.getPosition().getX();
    }


    @Override
    public double getY() {
        return vehicle.getPosition().getY();
    }


    public boolean is(IsVehicle v){
        return v.equals(vehicle);
    }
}
