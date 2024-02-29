package Model.Vehicles.StatePatters;

import Model.Vehicles.GroundVehicle;
import Model.Vehicles.Trailer;

public interface TruckState {
    // TruckState getState();
    boolean openTrailerStorage(Trailer<?> storage);
    boolean closeTrailerStorage(Trailer<?> storage);
    boolean gasTruck(GroundVehicle vehicle, double amount);
}
