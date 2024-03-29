package Model.Vehicles;

import java.awt.*;
import java.awt.geom.Point2D;

// only exist as a label
abstract class NormalCar implements IsVehicle {
    protected final GroundVehicle baseGroundVehicle;

    NormalCar(int nrDoors, double enginePower, String modelName, double x, double y, Color color, double w, double h) {
        baseGroundVehicle = new GroundVehicle(nrDoors, enginePower, modelName, x, y, color, w, h);
        setSpeedFactor();
    }

    NormalCar(int nrDoors, double enginePower, String modelName, Color color, double w, double h) {
        this(nrDoors, enginePower, modelName, 0, 0, color, w, h);
    }

    @Override
    public void brake(double amount) {
        baseGroundVehicle.brake(amount);
    }

    @Override
    public void gas(double amount) {
        baseGroundVehicle.gas(amount);
    }

    @Override
    public Color getColor() {
        return baseGroundVehicle.getColor();
    }

    @Override
    public double getCurrentSpeed() {
        return baseGroundVehicle.getCurrentSpeed();
    }

    @Override
    public double getEnginePower() {
        return baseGroundVehicle.getEnginePower();
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
    public boolean isEngineOn() {
        return baseGroundVehicle.isEngineOn();
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
    public double getDirection() {
        return baseGroundVehicle.getDirection();
    }

    @Override
    public Point2D.Double getPosition() {
        return baseGroundVehicle.getPosition();
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

    void setPosition(Point2D.Double newPosition) {
        baseGroundVehicle.setPosition(newPosition);
    }

    abstract void setSpeedFactor();

    @Override
    public double rBound() {
        return baseGroundVehicle.rBound();
    }

    @Override
    public double lBound() {
        return baseGroundVehicle.lBound();
    }

    @Override
    public double tBound() {
        return baseGroundVehicle.tBound();
    }

    @Override
    public double bBound() {
        return baseGroundVehicle.bBound();
    }

}
