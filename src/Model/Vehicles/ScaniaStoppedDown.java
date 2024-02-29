package Model.Vehicles;

public class ScaniaStoppedDown implements ScaniaState{

    private static ScaniaStoppedDown state;

    private ScaniaStoppedDown(){}

    public static ScaniaStoppedDown getState() {
        if (state == null) {
            state = new ScaniaStoppedDown();
        }
        return state;
    }

    @Override
    public boolean raiseStorageBed() {
        return true;
    }

    @Override
    public boolean lowerStorageBed() {
        System.out.println("Storage bed is already down.");
        return false;
    }

    @Override
    public boolean gasVehicle() {
        return true;
    }


}
