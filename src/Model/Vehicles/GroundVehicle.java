package Model.Vehicles;
import java.awt.*;
import java.awt.geom.Point2D;

public class GroundVehicle implements IsVehicle {

    private Point2D.Double position; // the position of the car
    private final double width, height; // width and height of the car
    private double directionAngle; // the current angle of the car in space
    private double[] direction; // cos and sin of directionAngle (in that order)
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private boolean engineOn;
    private double speedFactor;

    public GroundVehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y, double width, double height) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0.0;
        this.color = color;
        this.modelName = modelName;
        this.directionAngle = 0.0;
        this.direction = new double[] { Math.cos(directionAngle), Math.sin(directionAngle) };
        this.position = new Point2D.Double(x, y);
        this.width = width;
        this.height = height;
        setSpeedFactor(1);
        stopEngine();
    }
    public GroundVehicle(int nrDoors, double enginePower, Color color, String modelName, double width, double height) {
        this(nrDoors, enginePower, color, modelName, 0, 0, width, height);
    }

    @Override
    public String getModel() {
        return modelName;
    }

    @Override
    public int getNrDoors() {
        return nrDoors;
    }

    @Override
    public double getEnginePower() {
        return enginePower;
    }

    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color clr) {
        color = clr;
    }

    @Override
    public void startEngine() {
        engineOn = true;
    }

    @Override
    public void stopEngine() {
        engineOn = false;
    }

    @Override
    public boolean isEngineOn() {
        return engineOn;
    }

    void setSpeedFactor(double modifier) {speedFactor =  enginePower * 0.01 * modifier; }

    private void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + speedFactor * amount);
    }

    private void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor * amount);
    }

    private void setCurrentSpeed(double newSpeed) {
        currentSpeed = Math.clamp(newSpeed, 0, enginePower);
    }

    @Override
    public void gas(double amount) {
        if (amount < 0 || 1 < amount) {
            throw new IllegalArgumentException();
        }
        if (engineOn) {
            incrementSpeed(amount);
        }
    }

    @Override
    public void brake(double amount) {
        if (amount < 0 || 1 < amount) {
            throw new IllegalArgumentException();
        }
        // if (engineOn) {
            decrementSpeed(amount);
        // }
    }

    @Override
    public void move() {
        position.setLocation(position.getX() + currentSpeed * direction[0],
                position.getY() + currentSpeed * direction[1]);
    }

    @Override
    public double getDirection() {
        return directionAngle;
    }

    @Override
    public void turnLeft(double angle) {
        directionAngle -= angle;
        direction = new double[] { Math.cos(directionAngle), Math.sin(directionAngle) };
    }

    @Override
    public void turnRight(double angle) {
        directionAngle += angle;
        direction = new double[] { Math.cos(directionAngle), Math.sin(directionAngle) };
    }

    @Override
    public Point2D.Double getPosition() {
        return new Point2D.Double(this.position.x, this.position.y);
    }

    Point2D.Double getPositionRef() {return this.position;}

    void setPosition(Point2D.Double p) {
        this.position = p;
    }

    double getWidth() {return this.width;}
    double getHeight() {return this.height;}

    @Override
    public boolean overlaps(Bumpable b) {
        // this could all be reduced but this is more readable imo
        // no overlap in X axis
        if(this.lBound() > b.rBound() || this.rBound() < b.lBound()) {
            return false;
        }
        // no overlap in Y axis
        if(this.tBound() < b.bBound() || b.bBound() > this.tBound()) {
            return false;
        }
        return true;
    }

    @Override
    public double rBound() {
        return this.position.getX() + this.getWidth();
    }

    @Override
    public double lBound() {
        return this.position.getX();
    }

    @Override
    public double tBound() {
        return this.position.getY();
    }

    @Override
    public double bBound() {
        return this.getPosition().getY() + this.getHeight();
    }
}
