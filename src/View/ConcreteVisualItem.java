package View;

public class ConcreteVisualItem implements VisualItem{
    protected double x;
    protected double y;
    public final double width;
    public final double height;
    private final String imagePath;

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    protected ConcreteVisualItem(int x, int y, String imagePath, int width, int height) {
        this.x = x;
        this.y = y;
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
        return x + width;
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
        return y + height;
    }

    @Override
    public void update() {
    }
}









