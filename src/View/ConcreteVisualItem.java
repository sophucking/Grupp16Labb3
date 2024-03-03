package View;

import Model.Vehicles.IsVehicle;

public abstract class ConcreteVisualItem implements VisualItem{
    public final double width;
    public final double height;
    private final String imagePath;

    @Override
    public abstract double getX();

    @Override
    public abstract double getY();

    protected ConcreteVisualItem(String imagePath, double width, double height) {
        this.imagePath = imagePath;
        this.width = width;
        this.height = height;
    }


    public boolean overlaps(ConcreteVisualItem other) {
        return (this.xOverlap(other.lBound(), other.rBound()))
                && (this.yOverlap(other.tBound(), other.bBound()));
    }

    private boolean yOverlap(double otherTop, double otherBottom) {
        return (otherTop <= this.tBound() && this.tBound() <= otherBottom)
                || (otherTop <= this.bBound() && this.bBound() <= otherBottom);
    }

    private boolean xOverlap(double otherLeft, double otherRight) {
        return (otherLeft <= this.lBound() && this.lBound() <= otherRight)
                || (otherLeft <= this.rBound() && this.rBound() <= otherRight);
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }

    @Override
    public double rBound() {
        return getX() + width;
    }

    @Override
    public double lBound() {
        return getX();
    }

    @Override
    public double tBound() {
        return getY();
    }

    @Override
    public double bBound() {
        return getY() + height;
    }

}









