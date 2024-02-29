package Model.Vehicles.StatePatters;

import Model.Vehicles.GroundVehicle;
import Model.Vehicles.Trailer;

public class TruckMovingClosed implements TruckState {
    
    private static TruckMovingClosed movingState;

    private TruckMovingClosed(){}

    
    // @Override
    public static TruckMovingClosed getState(){
        if (movingState == null) {
            movingState = new TruckMovingClosed();
        }
        return movingState;
    }

    @Override
    public boolean openTrailerStorage(Trailer<?> storage) {
        System.out.println("Can't open a moving trailer");
        return false;
    }

    @Override
    public boolean closeTrailerStorage(Trailer<?> storage) {
        System.out.println("Storage trailer is already closed");
        return false;
    }


    @Override
    public boolean gasTruck(GroundVehicle vehicle, double amount) {
        vehicle.gas(amount);
        return true;
    }

}
