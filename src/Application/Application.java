package Application;

import Controller.VehicleController;
import Model.VehicleSimulation;
import View.VehicleView;
import Model.Vehicles.*;



public class Application {
    public static void main(String[] args) {
        VehicleSimulation vSim = new VehicleSimulation(10);
        vSim.addVehicle(new Volvo240(0, 0, 100, 100));
        vSim.addVehicle(new Saab95(0, 100, 100, 100));
        vSim.addVehicle(new ScaniaV8<Cargo>(0, 200, 100, 100));
        vSim.addVehicle(new Volvo240(0, 300, 100, 100));
        VehicleView vehicleView = new VehicleView("CarSim 0.4", 800,400, vSim);
        VehicleController controller = new VehicleController(vSim);
        VehicleUI vehicleUI = new VehicleUI(vehicleView, controller);
        vehicleUI.initWidgets();
        vSim.addModelListener(vehicleView);
        vehicleView.initItems();

        vSim.start();
    }


}
