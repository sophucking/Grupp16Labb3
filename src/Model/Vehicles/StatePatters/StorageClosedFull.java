package Model.Vehicles.StatePatters;

public class StorageClosedFull implements StorageState {
    private static StorageClosedFull state;

    private StorageClosedFull() {
    }

    public static StorageClosedFull getState() {
        if (state == null) {
            state = new StorageClosedFull();
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
