package View;

import Model.Vehicles.IsVehicle;

public class VisualVehicle extends ConcreteVisualItem {
    private final IsVehicle vehicle;

    VisualVehicle(IsVehicle vehicle, String imagePath) {
        super((int) vehicle.getPosition().getX(),
                (int) vehicle.getPosition().getY(),
                imagePath, 100, 100);
        this.vehicle = vehicle;
    }

    @Override
    public void update() {
        this.x = (int) vehicle.getPosition().getX();
        this.y = (int) vehicle.getPosition().getY();
    }

    public boolean is(IsVehicle v){
        return v.equals(vehicle);
    }
}
