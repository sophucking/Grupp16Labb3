package View;

public interface VisualItem {

    public double getX();

    public double getY();

    public String getImagePath();

    public double rBound();

    public double lBound();

    public double tBound();

    public double bBound();

    //update any variables for any changes that may or may not happen
    public void update();

}
