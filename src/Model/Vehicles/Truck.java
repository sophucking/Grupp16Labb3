package Model.Vehicles;
import java.awt.Color;
import java.awt.geom.Point2D;

public class Truck<T> implements IsVehicle, HasStorage<T> {

    public static final double TOURQUE_FACTOR = 0.35;
    protected final GroundVehicle baseGroundVehicle;
    protected final Trailer<T> storage;

    public Truck(double enginePower, Color color, String modelName, int max_capacity, double x, double y) {
        baseGroundVehicle = new GroundVehicle(2, enginePower, color, modelName, x, y);
        setSpeedFactor();
        this.storage = new Trailer<>(max_capacity);
    }

    public Truck(double enginePower, Color color, String modelName, int max_capacity) {
        this(enginePower, color, modelName, max_capacity, 0, 0);
    }

    @Override
    public void openStorage() {
        if (Math.abs(getCurrentSpeed()) > 0.01) {
            return;
        }
        storage.openStorage();
    }

    @Override
    public void closeStorage() {
        if (Math.abs(getCurrentSpeed()) > 0.01) {
            return;
        }
        storage.closeStorage();
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
        if (storage.isStorageOpen()) {
            return;
        }
        baseGroundVehicle.gas(amount);
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
    }

    protected Point2D.Double getPositionRef() {
        return baseGroundVehicle.getPositionRef();
    }

    void setSpeedFactor() {
        baseGroundVehicle.setSpeedFactor(TOURQUE_FACTOR);
    }
}
