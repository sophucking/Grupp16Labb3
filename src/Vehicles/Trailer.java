package Vehicles;
public class Trailer<T> extends Storage<T> {

    Trailer(int max_capacity) {
        super(max_capacity);
    }

    @Override
    public void storeThing(T toStore) {
        if (isStorageOpen() && countThings() < max_capacity) {
            storage.addFirst(toStore); // acts like a stack
        }
    }
}
