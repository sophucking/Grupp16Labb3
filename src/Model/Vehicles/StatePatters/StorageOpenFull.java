package Model.Vehicles.StatePatters;

public class StorageOpenFull implements StorageState {
    private static StorageOpenFull state;

    public static StorageOpenFull getState() {
        if (state==null) {
            state = new StorageOpenFull();
        }
        return state;
    }

    @Override
    public boolean addToStorage() {
        System.out.println("Storage is full!");
        return false;
    }

    @Override
    public boolean closeStorage() {
        return true;
    }

    @Override
    public boolean openStorage() {
        System.out.println("Storage is already open!");
        return false;
    }

    @Override
    public boolean removeFromStorage() {
        return true;
    }
    
    
}
