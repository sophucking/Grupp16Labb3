package Model.Vehicles.StatePatters;

public class StorageClosedEmpty implements StorageState {

    private static StorageClosedEmpty state;

    private StorageClosedEmpty() {}
    
    public static StorageClosedEmpty getState() {
    if (state == null) {
        state = new StorageClosedEmpty();
    }
        return state;
    }
    
    @Override
    public boolean addToStorage() {
        return false;
    }

    @Override
    public boolean closeStorage() {
        return false;
    }

    @Override
    public boolean openStorage() {
        return true;
    }

    @Override
    public boolean removeFromStorage() {
        return false;
    }

}
