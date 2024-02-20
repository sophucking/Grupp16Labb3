package Vehicles;
public interface Tippable<T> extends HasStorage<T> {
    public double getStorageAngle();
    public void lowerStorage(double angle);
    public void raiseStorage(double angle);
}
