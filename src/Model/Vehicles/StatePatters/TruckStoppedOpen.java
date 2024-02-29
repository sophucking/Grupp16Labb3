package Model.Vehicles.StatePatters;

import Model.Vehicles.GroundVehicle;
import Model.Vehicles.Trailer;

public class TruckStoppedOpen implements TruckState{

    private static TruckStoppedOpen stateStoppedOpen;

    private TruckStoppedOpen(){

    }

    // @Override
    public static TruckStoppedOpen getState(){
        if(stateStoppedOpen == null){
            stateStoppedOpen = new TruckStoppedOpen();
        }
        return stateStoppedOpen;
    }

    @Override
    public boolean openTrailerStorage(Trailer<?> storage) {
        System.out.println("Storage trailer is already open");
        return false;
    }

    @Override
    public boolean closeTrailerStorage(Trailer<?> storage) {
        storage.closeStorage();
        return true;
    }

    @Override
    public boolean gasTruck(GroundVehicle vehicle, double amount) {
        System.out.println("Don't gas whilst the storage is open! D:<");
        return false;
    }

}
