package Model.Vehicles;

public interface Bumpable {
    public boolean overlaps(Bumpable b);
    public double rBound();

    public double lBound();

    public double tBound();

    public double bBound();
}
