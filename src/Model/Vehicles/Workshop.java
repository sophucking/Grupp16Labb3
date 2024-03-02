package Model.Vehicles;
public class Workshop<T extends IsVehicle> implements HasStorage<T>, Bumpable {
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
    public void addToStorage(T toStore) {
        garage.addToStorage(toStore);
    }

    @Override
    public T removeThing() {
        return garage.removeThing();
    }

    @Override
    public int countThings() {
        return garage.countThings();
    }

    @Override
    public double rBound() {
        return this.;
    }

    @Override
    public double lBound() {
        return 0;
    }

    @Override
    public double tBound() {
        return 0;
    }

    @Override
    public double bBound() {
        return 0;
    }
}
