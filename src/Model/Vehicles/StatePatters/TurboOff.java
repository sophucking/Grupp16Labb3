package Model.Vehicles.StatePatters;

public class TurboOff implements TurboState {

    private static TurboOff state;

    private TurboOff() {
    }

    public static TurboOff getState() {
        if (state == null) {
            state = new TurboOff();
        }
        return state;
    }

    @Override
    public boolean isTurboOn() {
        return false;
    }

    @Override
    public double getSpeedFactorMultiplier() {
        return 1.0;
    }

}
