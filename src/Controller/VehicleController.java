package Controller;
import java.util.ArrayList;

import Model.ModelListener;
import Model.VehicleSimulation;
import Model.Vehicles.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
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
