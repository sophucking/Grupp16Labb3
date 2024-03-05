package Model;

import Model.Vehicles.*;

// A class to generate random cars. Makes dependencies nicer than putting this in Simulation
public class RandomVehicleFactory {
    public IsVehicle makeRandomVehicle(double vehicleWidth, double vehicleHeight, double worldWidth, double worldHeight) {
        double vehicleXPos = Math.random() * (worldWidth - vehicleWidth);
        double vehicleYPos = Math.random() * (worldHeight - vehicleHeight);
        switch ((int) (Math.random() * 3)) {
            case 0:
                return new Volvo240(vehicleXPos, vehicleYPos, vehicleWidth, vehicleHeight);
            case 1:
                return new Saab95(vehicleXPos, vehicleYPos, vehicleWidth, vehicleHeight);
            case 2:
                return new ScaniaV8<Cargo>(vehicleXPos, vehicleYPos, vehicleWidth, vehicleHeight);
            default:
                throw new RuntimeException("Factory method failed to generate valid case");
        }
    }
}
