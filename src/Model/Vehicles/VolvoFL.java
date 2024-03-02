package Model.Vehicles;
import java.awt.*;
import java.awt.geom.Point2D;

public class VolvoFL extends Truck<NormalCar> implements IsVolvo{
    public VolvoFL(double x, double y, double width, double height) {
        super(200,  "VolvoFL",10, x, y, Color.BLUE, width, height);
    }
    
    public VolvoFL() {
        super(200,  "VolvoFL",10, Color.BLUE,100,100);
    }


    private boolean closeEnough(Point2D.Double p) {
        double dist = p.distance(this.getPosition());
        return  1.0 >= dist;
    }
    
    @Override
    public void addToStorage(NormalCar thing) {
        boolean closeEnough = closeEnough(thing.getPosition());
        if(!closeEnough) {
            thing.setPosition(this.getPositionRef());
            super.addToStorage(thing);
        }
    }

    @Override
    public NormalCar removeThing() {
        NormalCar removedCar = super.removeThing();
        removedCar.setPosition(new Point2D.Double(this.getPosition().getX(),this.getPosition().getY()));
        return removedCar;
    }
}



