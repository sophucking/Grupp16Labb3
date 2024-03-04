package Model.Vehicles.StatePatters;

import java.util.function.Function;

public class TippableStoppedUp implements TippableState{

    private static TippableStoppedUp state;

    private TippableStoppedUp(){}

    public static TippableStoppedUp getState() {
        if (state == null) {
            state = new TippableStoppedUp();
        }
        return state;
    }

    @Override
    public void gasVehicle(Function<Double,Void> gasMethod, double amount) {
        System.out.println("Don't gas when the storage bed is up!");
    }

    @Override
    public void lowerStorageBed(Function<Double,Void> setStorageMethod, double amount) {
        setStorageMethod.apply(amount);
    }

    @Override
    public void raiseStorageBed(Function<Double,Void> setStorageMethod, double amount) {
        setStorageMethod.apply(amount);
    }

    
}
