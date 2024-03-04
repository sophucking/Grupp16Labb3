package Model.Vehicles.StatePatters;

import java.util.function.Function;

public interface TippableState {
    void raiseStorageBed(Function<Double,Void> setStorageMethod, double angle);
    void gasVehicle(Function<Double,Void> gasMethod, double amount);
    void lowerStorageBed(Function<Double,Void> setStorageMethod, double angle);
}
