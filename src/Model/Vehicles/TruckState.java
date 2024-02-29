package Model.Vehicles;

interface TruckState {
    // TruckState getState();
    boolean openTrailerStorage(Trailer<?> storage);
    boolean closeTrailerStorage(Trailer<?> storage);
    boolean gasTruck(GroundVehicle vehicle, double amount);
}
