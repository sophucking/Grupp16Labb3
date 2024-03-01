package Model.Vehicles;
import java.util.*;
import Model.Vehicles.StatePatters.*;

import Model.Vehicles.StatePatters.StorageState;
public abstract class Storage<T> implements HasStorage<T> {

    protected final int max_capacity;
    private boolean storageOpen = false;
    protected List<T> storage = new ArrayList<>();
    private StorageState state;

    Storage(int max_capacity) {
        this.max_capacity = max_capacity;
        state = StorageClosedEmpty.getState();
    }

    @Override
    public void openStorage() {
        if (state.openStorage()) {
            storageOpen = true;
            stateOpen();
        }
    }

    private void stateOpen() {
        if (state instanceof StorageClosedEmpty) {
            state = StorageOpenEmpty.getState();
        } else if (state instanceof StorageClosedHasSpace) {
            state = StorageOpenHasSpace.getState();
        } else if (state instanceof StorageClosedFull) {
            state = StorageOpenFull.getState();
        }
    }

    @Override
    public void closeStorage() {
        if (state.closeStorage()) {
            storageOpen = false;
            stateClosed();
        }
    }

    private void stateClosed() {
        if (state instanceof StorageOpenEmpty) {
            state = StorageClosedEmpty.getState();
        } else if (state instanceof StorageOpenHasSpace) {
            state = StorageClosedHasSpace.getState();
        } else if (state instanceof StorageOpenFull) {
            state = StorageClosedFull.getState();
        }
    }

    @Override
    public boolean isStorageOpen() {
        return storageOpen;
    }

    @Override
    public void addToStorage(T tostore) {
        if (state.addToStorage()) {
            storeThing(tostore);
            stateFullness();
        }
    }

    protected abstract void storeThing(T toStore);

    @Override
    public T removeThing() {
        if (state.removeFromStorage()) {
            T removed = storage.removeFirst();
            stateFullness();
            return removed;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    private void stateFullness() {
        int size  = storage.size();
        if (size == 0) {
            state = StorageOpenEmpty.getState();
        } else if (size == max_capacity) {
            state = StorageOpenFull.getState();
        } else {
            state = StorageOpenHasSpace.getState();
        }
    }

    @Override
    public int countThings() {
        return storage.size();
    }
}
