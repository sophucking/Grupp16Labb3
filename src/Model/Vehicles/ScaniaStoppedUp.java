package Model.Vehicles;

public class ScaniaStoppedUp implements ScaniaState{

    private static ScaniaStoppedUp state;

    private ScaniaStoppedUp(){}

    public static ScaniaStoppedUp getState() {
        return state;
    }

    @Override
    public boolean gasVehicle() {
        System.out.println("Don't gas when the storage bed is up!");
        return false;
    }

    @Override
    public boolean lowerStorageBed() {
        return true;
    }

    @Override
    public boolean raiseStorageBed() {
        return true;
    }

    
}
