package Application;

import Controller.VehicleController;
import Model.VehicleSimulation;
import View.VehicleView;
import Model.Vehicles.*;



public class Application {
    public static void main(String[] args) {
        int defaultWidth = 100;
        int defaultHeight = 100;
        VehicleSimulation vSim = new VehicleSimulation(10);
        vSim.addVehicle(new Volvo240(0, 0, defaultWidth, defaultHeight));
        vSim.addVehicle(new Saab95(0, 100, defaultWidth, defaultHeight));
        vSim.addVehicle(new ScaniaV8<Cargo>(0, 200, defaultWidth, defaultHeight));
        vSim.addVehicle(new Volvo240(0, 300, defaultWidth, defaultHeight));
        VehicleView vehicleView = new VehicleView("CarSim 0.4", 800,400, vSim);
        VehicleController controller = new VehicleController(vSim);
        VehicleUI vehicleUI = new VehicleUI(vehicleView, controller, defaultWidth, defaultHeight);
        vehicleUI.initWidgets();
        vSim.addModelListener(vehicleView);
        vehicleView.initItems();

        vSim.start();
    }


}
