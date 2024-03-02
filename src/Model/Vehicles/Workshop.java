package Model.Vehicles;
public class Workshop<T extends IsVehicle> implements HasStorage<T>, Bumpable {
    private final Garage<T> garage;

    // needed since it implement Bumpable
    private final double x,y,width,height;
    
    public Workshop(int max_capacity, double x, double y, double width, double height) {
        garage = new Garage<>(max_capacity);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
        return x+width;
    }

    @Override
    public double lBound() {
        return x;
    }

    @Override
    public double tBound() {
        return y;
    }

    @Override
    public double bBound() {
        return y+height;
    }
}
