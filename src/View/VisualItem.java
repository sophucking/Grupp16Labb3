package View;

import Model.Vehicles.IsVehicle;

public interface VisualItem {

    public double getX();

    public double getY();

    public String getImagePath();

    public double rBound();

    public double lBound();

    public double tBound();

    public double bBound();

}
