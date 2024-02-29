package Model.Vehicles.StatePatters;

public interface ScaniaState {
    boolean raiseStorageBed();
    boolean lowerStorageBed();
    boolean gasVehicle();
}
