package Vehicles;
public class Workshop<T extends IsVehicle> implements HasStorage<T> {
    private final Garage<T> garage;
    public Workshop(int max_capacity) {
        garage = new Garage<>(max_capacity);
    }

    @Override
    public void openStorage() {
        garage.openStorage();
        System.out.println("We're open!!!");
    }

    @Override
    public void closeStorage() {
        garage.closeStorage();
        System.out.println("We're closed.");
    }

    @Override
    public boolean isStorageOpen() {
        return garage.isStorageOpen();
    }

    @Override
    public void storeThing(T toStore) {
        garage.storeThing(toStore);
    }

    @Override
    public T removeThing() {
        return garage.removeThing();
    }

    @Override
    public int countThings() {
        return garage.countThings();
    }
}
