package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import Application.VehicleUI;
import Controller.VehicleController;
import Model.ModelListener;
import Model.Vehicles.*;
import View.VehicleView;
import View.VisualVehicle;

public class VehicleSimulation {

    private static final int X = 800;
    private static final int Y = 400;
    private static final int PADD = 1;
    private final ArrayList<IsVehicle> vehicles;
    private final Workshop<IsVolvo> volvoWorkshop;
    private VehicleUI ui;

    // The delay 50 (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer; 
    private List<ModelListener> listeners;
    // The frame that represents this instance View of the MVC pattern
    // Start a new view and send a reference of self
    VehicleView view;

    public VehicleSimulation() {
        timer = new Timer(delay, new TimerListener());
        listeners = new ArrayList<>();
        view = new VehicleView("CarSim 1.0", X, Y, this);
        ui = new VehicleUI(view, new VehicleController(this));
        ui.initWidgets();
        addModelListener(view);

        vehicles = new ArrayList<>();
        volvoWorkshop = new Workshop<IsVolvo>(30, 300, 300, 100, 100);

        initWorkshop();

        view.initItems();
    }

    private void initWorkshop() {
        volvoWorkshop.openStorage();
        view.addWorkshop();
    }

    public void addModelListener(ModelListener listener) {
        listeners.add(listener);
    }

    public void addVehicle(IsVehicle vehicle) {
        vehicles.add(vehicle);
        view.addVehicle(vehicle);
    }

    public void gasAll(int amount) {
        for (IsVehicle v : vehicles) {
            v.gas(amount / 100.0);
        }
    }

    public void brakeAll(int amount) {
        for (IsVehicle v : vehicles) {
            v.brake(amount / 100.0);
        }
    }

    public void startAll() {
        for (IsVehicle v : vehicles) {
            v.startEngine();
        }
    }

    public void stopAll() {
        for (IsVehicle v : vehicles) {
            v.stopEngine();
        }
    }

    public void turboOnAll() {
        for (IsVehicle v : vehicles) {
            if(v instanceof HasTurbo) {
                ((HasTurbo) v).setTurboOn();
            }
        }
    }

    public void turboOffAll() {
        for (IsVehicle v : vehicles) {
            if (v instanceof HasTurbo) {
                ((HasTurbo) v).setTurboOff();
            }
        }
    }

    public void liftBedAll() {
        for (IsVehicle v : vehicles) {
            if (v instanceof Tippable<?>) {
                ((Tippable<?>) v).raiseStorage(70);
                ((Tippable<?>) v).openStorage();
            }
        }
    }

    public void lowerBedAll() {
        for (IsVehicle v : vehicles) {
            if (v instanceof Tippable<?>) {
                ((Tippable<?>) v).lowerStorage(70);
                ((Tippable<?>) v).closeStorage();
            }
        }
    }



    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
        }
    }

    private void informListeners() {
        for (ModelListener modelListener : listeners) {
            modelListener.onUpdate();
        }
    }

    public void start() {
        timer.start();
    }

    private boolean isOutOfBoundsY(IsVehicle v) {
        return v.tBound() < 0 - PADD || v.bBound() > Y + PADD;
    }

    private boolean isOutOfBoundsX(IsVehicle v) {
        return v.rBound() > X + PADD || v.lBound() < 0 - PADD;
    }

    public void update() {
        ArrayList<IsVehicle> enteredWorkshop = new ArrayList<>();
        for (IsVehicle v : vehicles) {
            v.move();
            worldHasBouncyWalls(v);
            ifEnterWorkshop(enteredWorkshop, v);
        }
        vehicles.removeAll(enteredWorkshop);
        view.removeAllEnteredWorkshop(enteredWorkshop);
        informListeners();
    }

    private void ifEnterWorkshop(ArrayList<IsVehicle> enteredWorkshop, IsVehicle v) {
        if (workshopInteraction(v)) {
            enteredWorkshop.add(v);
        }
    }

    private void worldHasBouncyWalls(IsVehicle v) {
        if (isOutOfBoundsX(v) || isOutOfBoundsY(v)) {
            v.turnLeft(Math.PI);
        }
    }

    private boolean workshopInteraction(IsVehicle v) {
        if (v.overlaps(volvoWorkshop)) {
            return enterWorkshopIfAllowed(v);
        }
        return false;
    }


    private boolean enterWorkshopIfAllowed(IsVehicle v) {
        if (canEnter(v)) {
            enterWorkshop(v);
            return true;
        }
        return false;
    }

    private void enterWorkshop(IsVehicle v) {
        System.out.println("A " + v.getModel() + " has entered the workshop for service!");
        volvoWorkshop.addToStorage((IsVolvo) v);
    }

    private boolean canEnter(IsVehicle v) {
        return v instanceof IsVolvo && volvoWorkshop.isStorageOpen();
    }

    public ArrayList<IsVehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    public ArrayList<Workshop<?>> getWorkshops() {
        ArrayList<Workshop<?>> list = new ArrayList<>();
        list.add(volvoWorkshop);
        return list;
    }

}