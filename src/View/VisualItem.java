package View;

public interface VisualItem /* extends DrawPanel */ {

    public int getX();

    public int getY();

    public String getImagePath();

    public int rBound();

    public int lBound();

    public int tBound();

    public int bBound();

}
