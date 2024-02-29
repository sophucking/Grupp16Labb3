package Model.Vehicles;

class TruckStillOpen implements TruckState{

    private static TruckStillOpen stillState;

    private TruckStillOpen(){

    }

    @Override
    public TruckStillOpen getState(){
        if(stillState == null){
            stillState = new TruckStillOpen();
        }
        return stillState;
    }

    @Override
    public void openTrailerStorage(Trailer<?> storage) {
        System.out.println("Storage trailer is already open");
    }

    @Override
    public void closeTrailerStorage(Trailer<?> storage) {
        storage.openStorage();
    }

    @Override
    public void gasTruck(GroundVehicle vehicle) {
        System.out.println("Don't gas whilst the storage is open! D:<");
    }

    @Override
    public void brakeVehicle(GroundVehicle vehicle) {
        System.out.println("Vehicle is already standing still");
    }

}
