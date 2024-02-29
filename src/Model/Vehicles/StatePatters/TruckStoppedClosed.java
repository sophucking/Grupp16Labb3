package Model.Vehicles.StatePatters;

import Model.Vehicles.GroundVehicle;
import Model.Vehicles.Trailer;

public class TruckStoppedClosed implements TruckState{

    private static TruckStoppedClosed stateStoppedClosed;

    private TruckStoppedClosed(){

    }

    // @Override
    public static TruckStoppedClosed getState(){
        if(stateStoppedClosed == null){
            stateStoppedClosed = new TruckStoppedClosed();
        }
        return stateStoppedClosed;
    }

    @Override
    public boolean openTrailerStorage(Trailer<?> storage) {
        storage.openStorage();
        return true;
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
