package Application;

import Controller.VehicleController;
import Model.ModelListener;
import Model.VehicleSimulation;
import View.VehicleView;


public class Application {
    public static void main(String[] args) {
        VehicleSimulation vSim = new VehicleSimulation();
        VehicleView vehicleView = new VehicleView("CarSim 0.4", 800,400);
        VehicleController controller = new VehicleController();
        VehicleUI vehicleUI = new VehicleUI(vehicleView, controller);
        vehicleUI.initWidgets();
        vSim.addModelListener(vehicleView);
        // Start the timer
        vSim.start();
    }


}
