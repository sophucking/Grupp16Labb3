package Model.Vehicles;

class TruckStill implements TruckState{

    private static TruckStill stillState;

    private TruckStill(){

    }

    @Override
    public TruckStill getState(){
        if(stillState == null){
            stillState = new TruckStill();
        }
        return stillState;
    }

    @Override
    public void openTrailerStorage(Trailer<?> storage) {
        storage.openStorage();
    }

    @Override
    public void closeTrailerStorage(Trailer<?> storage) {
        storage.openStorage();
    }

}
