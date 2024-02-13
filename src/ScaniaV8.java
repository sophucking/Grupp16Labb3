import java.awt.*;

public class ScaniaV8<T> extends Truck<T> implements Tippable<T>{

    private double storageAngle;
    public ScaniaV8(double x, double y) {
        super(200, Color.white, "ScaniaV8",10, x, y);
        this.storageAngle = 0.0;
    }
    public ScaniaV8() {
        super(200, Color.white, "ScaniaV8",10);
        this.storageAngle = 0.0;
    }

    @Override
    public double getStorageAngle() {
        return this.storageAngle;
    }

    private void setStorageAngle(double angle) {
        if(Math.abs(getCurrentSpeed()) > 0.01) {
            return;
        }
        storageAngle = Math.clamp(angle,0,70);
    }

    @Override
    public void lowerStorage(double angle) {
        setStorageAngle(storageAngle - angle);
    }

    @Override
    public void raiseStorage(double angle) {
        setStorageAngle(storageAngle + angle);
    }

    @Override
    public void gas(double ammount) {
        if(Math.abs(storageAngle) > 0.01) {
            return;
        }
        super.gas(ammount);
    }
}
