package Model.Vehicles;

public interface Bumpable {
    default boolean overlaps(Bumpable b) {
        // this could all be reduced but this is more readable
        // no overlap in X axis
        if(this.lBound() > b.rBound() || this.rBound() < b.lBound()) {
            return false;
        }
        // no overlap in Y axis
        if(this.tBound() < b.bBound() || this.bBound() > b.tBound()) {
            return false;
        }
        return true;
    }
    public double rBound();

    public double lBound();

    public double tBound();

    public double bBound();
}
