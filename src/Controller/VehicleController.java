package Controller;
import Model.VehicleSimulation;

/*
* This class represents the Controller part in the MVC pattern.
 */

public class VehicleController {

    private final VehicleSimulation vSim;
    // methods:
    public VehicleController(VehicleSimulation vSim) {
        this.vSim = vSim;
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        vSim.gasAll(amount);
    }

    public void brake(int amount) {
        vSim.brakeAll(amount);
    }

    public void startAllEngines() {
        vSim.startAll();
    }

    public void stopAllEngines() {
        vSim.stopAll();
    }

    public void turnTurboOn() {
        vSim.turboOnAll();
    }

    public void turnTurboOff() {
        vSim.turboOffAll();
    }

    public void liftBed() {
        vSim.liftBedAll();
    }

    public void lowerBed() {
        vSim.lowerBedAll();
    }
}
