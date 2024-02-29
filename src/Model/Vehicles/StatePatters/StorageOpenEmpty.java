package Model.Vehicles.StatePatters;

public class StorageOpenEmpty implements StorageState{

    private static StorageOpenEmpty state;

    public static StorageOpenEmpty getState() {
        if (state == null) {
            state = new StorageOpenEmpty();
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
        return false;
    }

    @Override
    public boolean removeFromStorage() {
        return false;
    }


    
}
