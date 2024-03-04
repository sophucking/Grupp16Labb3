package Model.Vehicles.StatePatters;

import java.util.function.Function;

public class TippableStoppedDown implements TippableState{

    private static TippableStoppedDown state;

    private TippableStoppedDown(){}

    public static TippableStoppedDown getState() {
        if (state == null) {
            state = new TippableStoppedDown();
        }
        return state;
    }

    @Override
    public void raiseStorageBed(Function<Double,Void> setStorageMethod, double amount) {
        setStorageMethod.apply(amount);
    }

    @Override
    public void lowerStorageBed(Function<Double,Void> setStorageMethod, double amount) {
        System.out.println("Storage bed is already down.");
    }

    @Override
    public void gasVehicle(Function<Double,Void> gasMethod, double amount) {
        gasMethod.apply(amount);
    }


}
