package Vehicles;
import java.awt.geom.Point2D;

public interface Movable {

    void move();

    void turnLeft(double angle);

    void turnRight(double angle);

    double getDirection();

    Point2D.Double getPosition();
}
