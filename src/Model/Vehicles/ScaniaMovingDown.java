package Model.Vehicles;

public class ScaniaMovingDown implements ScaniaState {
    
    private static ScaniaMovingDown state;

    private ScaniaMovingDown(){}

    public static ScaniaMovingDown getState(){
        if (state == null) {
            state = new ScaniaMovingDown();
        }
        return state;
    }

    @Override
    public boolean raiseStorageBed() {
        System.out.println("Don't raise the storage of a moving vehicle D:<");
        return false;
    }

    @Override
    public boolean lowerStorageBed() {
        System.out.println("Storage bed is already down. ");
        return false;
    }

    @Override
    public boolean gasVehicle() {
        return true;
    }

}
