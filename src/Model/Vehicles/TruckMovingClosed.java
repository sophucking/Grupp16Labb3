package Model.Vehicles;

class TruckMovingClosed implements TruckState{
    
    private static TruckMovingClosed movingState;

    private TruckMovingClosed(){}

    
    @Override
    public TruckMovingClosed getState(){
        if (movingState == null) {
            movingState = new TruckMovingClosed();
        }
        return movingState;
    }

    @Override
    public void openTrailerStorage(Trailer<?> storage) {
        System.out.println("Can't open a moving trailer");
    }

    @Override
    public void closeTrailerStorage(Trailer<?> storage) {
        storage.closeStorage();// will never happen since truck cannot gas whilst storage is open
    }

}
