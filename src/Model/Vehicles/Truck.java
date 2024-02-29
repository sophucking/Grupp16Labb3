package Model.Vehicles;
import java.awt.Color;
import java.awt.geom.Point2D;

public class Truck<T> implements IsVehicle, HasStorage<T> {

    public static final double TOURQUE_FACTOR = 0.35;
    protected final GroundVehicle baseGroundVehicle;
    protected final Trailer<T> storage;
    private TruckState state;

    public Truck(double enginePower, Color color, String modelName, int max_capacity, double x, double y) {
        baseGroundVehicle = new GroundVehicle(2, enginePower, color, modelName, x, y);
        setSpeedFactor();
        this.storage = new Trailer<>(max_capacity);
        state = TruckStoppedClosed.getState();
    }

    public Truck(double enginePower, Color color, String modelName, int max_capacity) {
        this(enginePower, color, modelName, max_capacity, 0, 0);
    }

    @Override
    public void openStorage() {
        if(state.openTrailerStorage(storage)) {
            state = TruckStoppedOpen.getState();
        }
    }

    @Override
    public void closeStorage() {
        if (state.closeTrailerStorage(storage)) {
            state = TruckStoppedClosed.getState();
        }
    }

    @Override
    public boolean isStorageOpen() {
        return storage.isStorageOpen();
    }

    @Override
    public void storeThing(T toStore) {
        storage.storeThing(toStore);
    }

    @Override
    public T removeThing() {
        return storage.removeThing();
    }

    @Override
    public int countThings() {
        return storage.countThings();
    }

    @Override
    public void gas(double amount) {
        if (state.gasTruck(baseGroundVehicle, amount)) {
            state = TruckMovingClosed.getState();
        }
    }

    @Override
    public void move() {
        baseGroundVehicle.move();
    }

    @Override
    public void turnLeft(double angle) {
        baseGroundVehicle.turnLeft(angle);
    }

    @Override
    public void turnRight(double angle) {
        baseGroundVehicle.turnRight(angle);
    }

    @Override
    public double getDirection() {
        return baseGroundVehicle.getDirection();
    }

    @Override
    public Point2D.Double getPosition() {
        return baseGroundVehicle.getPosition();
    }

    @Override
    public String getModel() {
        return baseGroundVehicle.getModel();
    }

    @Override
    public int getNrDoors() {
        return baseGroundVehicle.getNrDoors();
    }

    @Override
    public double getEnginePower() {
        return baseGroundVehicle.getEnginePower();
    }

    @Override
    public double getCurrentSpeed() {
        return baseGroundVehicle.getCurrentSpeed();
    }

    @Override
    public Color getColor() {
        return baseGroundVehicle.getColor();
    }

    @Override
    public void setColor(Color clr) {
        baseGroundVehicle.setColor(clr);
    }

    @Override
    public void startEngine() {
        baseGroundVehicle.startEngine();
    }

    @Override
    public void stopEngine() {
        baseGroundVehicle.stopEngine();
    }

    @Override
    public boolean isEngineOn() {
        return baseGroundVehicle.isEngineOn();
    }

    @Override
    public void brake(double amount) {
        baseGroundVehicle.brake(amount);
        if(baseGroundVehicle.getCurrentSpeed() <= 0.001) {
            state = TruckStoppedClosed.getState();
        }
    }

    protected Point2D.Double getPositionRef() {
        return baseGroundVehicle.getPositionRef();
    }

    void setSpeedFactor() {
        baseGroundVehicle.setSpeedFactor(TOURQUE_FACTOR);
    }
}
