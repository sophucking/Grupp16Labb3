package Model.Vehicles.StatePatters;

public class StorageOpenHasSpace implements StorageState {

    private static StorageOpenHasSpace state;

    public static StorageOpenHasSpace getState() {
        if (state == null) {
            state = new StorageOpenHasSpace();
        }
        return state;
    }

    @Override
    public boolean addToStorage() {
        return true;
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
