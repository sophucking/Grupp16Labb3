package Model.Vehicles.StatePatters;

import java.util.function.Function;

public class TippableMovingDown implements TippableState {
    
    private static TippableMovingDown state;

    private TippableMovingDown(){}

    public static TippableMovingDown getState(){
        if (state == null) {
            state = new TippableMovingDown();
        }
        return state;
    }

    @Override
        public void raiseStorageBed(Function<Double,Void> setStorageMethod, double amount) {
        System.out.println("Don't raise the storage of a moving vehicle D:<");
    }

    @Override
    public void lowerStorageBed(Function<Double,Void> setStorageMethod, double amount) {
        System.out.println("Storage bed is already down. ");
    }

    @Override
    public void gasVehicle(Function<Double,Void> gasMethod, double amount) {
        gasMethod.apply(amount);
    }

}
