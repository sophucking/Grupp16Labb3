package Model.Vehicles.StatePatters;

public class TurboOn implements TurboState {

    private static TurboOn state;

    private TurboOn() {
    }

    public static TurboOn getState() {
        if (state == null) {
            state = new TurboOn();
        }
        return state;
    }

    @Override
    public boolean isTurboOn() {
        return true;
    }

    @Override
    public double getSpeedFactorMultiplier() {
        return 1.3;
    }

}
