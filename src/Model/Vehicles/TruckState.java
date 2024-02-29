package Model.Vehicles;

interface TruckState {
    TruckState getState();
    void openTrailerStorage(Trailer<?> storage);
    void closeTrailerStorage(Trailer<?> storage);
    void gasTruck(GroundVehicle vehicle);
    void brakeVehicle(GroundVehicle vehicle);
}
