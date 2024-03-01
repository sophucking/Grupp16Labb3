package View;

public class ConcreteVisualItem implements VisualItem{
    protected int x;
    protected int y;
    public final int width;
    public final int height;
    private final String imagePath;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
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

    private boolean yOverlap(int otherTop, int otherBottom) {
        return (otherTop <= this.tBound() && this.tBound() <= otherBottom)
                || (otherTop <= this.bBound() && this.bBound() <= otherBottom);
    }

    private boolean xOverlap(int otherLeft, int otherRight) {
        return (otherLeft <= this.lBound() && this.lBound() <= otherRight)
                || (otherLeft <= this.rBound() && this.rBound() <= otherRight);
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public int rBound() {
        return x + width;
    }

    @Override
    public int lBound() {
        return x;
    }

    @Override
    public int tBound() {
        return y;
    }

    @Override
    public int bBound() {
        return y + height;
    }

    @Override
    public String getImage() {
        return imagePath;
    }

}









