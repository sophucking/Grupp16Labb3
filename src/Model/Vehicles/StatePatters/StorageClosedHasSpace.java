package Model.Vehicles.StatePatters;

public class StorageClosedHasSpace implements StorageState {

    private static StorageClosedHasSpace state;

    private StorageClosedHasSpace() {
    }

    public static StorageClosedHasSpace getState() {
        if (state == null) {
            state = new StorageClosedHasSpace();
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
