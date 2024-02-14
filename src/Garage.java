public class Garage<T extends IsVehicle> extends Storage<T>{

    Garage(int max_capacity) {
        super(max_capacity);
    }
    @Override
    public void storeThing(T toStore) {
        if(isStorageOpen() && countThings() < max_capacity) {
            storage.add(toStore); // acts like a queue
        }
    }

}