import java.awt.*;
import java.awt.geom.Point2D;

public class VolvoFL extends Truck<NormalCar> {
    public VolvoFL(double x, double y) {
        super(200, Color.BLUE, "VolvoFL",10, x, y);
    }
    
    public VolvoFL() {
        super(200, Color.BLUE, "VolvoFL",10);
    }


    private boolean closeEnough(Point2D.Double p) {
        double dist = p.distance(this.getPosition());
        return  1.0 >= dist;
    }
    @Override
    public void storeThing(NormalCar thing) {
        boolean closeEnough = closeEnough(thing.getPosition());
        if(!closeEnough) {
            return;
        }
        thing.setPosition(this.getPositionRef());
        super.storeThing(thing);
    }

    @Override
    public NormalCar removeThing() {
        NormalCar removedCar = super.removeThing();
        removedCar.setPosition(new Point2D.Double(this.getPosition().getX(),this.getPosition().getY()));
        return removedCar;
    }
}



