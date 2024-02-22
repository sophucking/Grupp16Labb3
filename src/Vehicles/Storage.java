package Vehicles;
import java.util.*;
public abstract class Storage<T> implements HasStorage<T> {

    protected final int max_capacity;
    private boolean storageOpen = false;
    protected List<T> storage = new ArrayList<>();

    Storage(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    @Override
    public void openStorage() {
        storageOpen = true;
    }

    @Override
    public void closeStorage() {
        storageOpen = false;
    }

    @Override
    public boolean isStorageOpen() {
        return storageOpen;
    }

    @Override
    public abstract void storeThing(T toStore);

    @Override
    public T removeThing() {
        if (!isStorageOpen()) {
            throw new IllegalAccessError("Can't remove a thing from a closed storage");
        }
        return storage.removeFirst();
    }
    @Override
    public int countThings() {
        return storage.size();
    }
}
