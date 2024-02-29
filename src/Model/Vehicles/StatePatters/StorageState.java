package Model.Vehicles.StatePatters;

public interface StorageState {
    boolean addToStorage();

    boolean removeFromStorage();

    boolean openStorage();

    boolean closeStorage();
}
