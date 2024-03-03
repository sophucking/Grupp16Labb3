package Application;

import Controller.VehicleController;
import Model.VehicleSimulation;
import View.VehicleView;
import Model.Vehicles.*;


public class Application {
    public static void main(String[] args) {
        VehicleSimulation vSim = new VehicleSimulation();
        VehicleView vehicleView = new VehicleView("CarSim 0.4", 800,400);
        VehicleController controller = new VehicleController(vSim);
        VehicleUI vehicleUI = new VehicleUI(vehicleView, controller);
        vehicleUI.initWidgets();
        vSim.addModelListener(vehicleView);
        // Start the timer
        vSim.addVehicle(new Volvo240(0, 0, 100, 100));
        vSim.addVehicle(new Saab95(0, 100, 100, 100));
        vSim.addVehicle(new ScaniaV8<Cargo>(0, 200, 100, 100));
        vSim.addVehicle(new Volvo240(0, 300, 100, 100));


        vSim.start();


    }


}
