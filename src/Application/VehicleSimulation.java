package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import Controller.VehicleController;
import Model.ModelListener;
import Model.Vehicles.*;
import View.VehicleView;

public class VehicleSimulation {
    /* private class VisualItem {
        protected int x;
        protected int y;
        protected final int width;
        protected final int height;
        private final String imagePath;

        protected VisualItem(int x, int y, String imagePath, int width, int height) {
            this.x = x;
            this.y = y;
            this.imagePath = imagePath;
            this.width = width;
            this.height = height;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean overlaps(VisualItem other) {
            return (this.xOverlap(other.lBound(), other.rBound()))
                    && (this.yOverlap(other.tBound(), other.bBound()));
        }

        private boolean yOverlap(int otherTop, int otherBottom) {
            return (otherTop <= this.tBound() && this.tBound() <= otherBottom)
                    || (otherTop <= this.bBound() && this.bBound() <= otherBottom);
        }

        private boolean xOverlap(int otherLeft, int otherRight) {
            return (otherLeft <= this.lBound() && this.lBound() <= otherRight)
                    || (otherLeft <= this.rBound() && this.rBound() <= otherRight);
        }

        public String getImagePath() {
            return imagePath;
        }

        public int rBound() {
            return x + width;
        }

        public int lBound() {
            return x;
        }

        public int tBound() {
            return y;
        }

        public int bBound() {
            return y + height;
        }
    }

    private class VisualVehicle extends VisualItem {
        private final IsVehicle vehicle;

        VisualVehicle(IsVehicle vehicle, String imagePath) {
            super((int) vehicle.getPosition().getX(),
                (int) vehicle.getPosition().getY(),
                imagePath, 100, 60);
            this.vehicle = vehicle;
        }

        public IsVehicle getVehicle() {
            return vehicle;
        }

        public void update() {
            x = (int) vehicle.getPosition().getX();
            y = (int) vehicle.getPosition().getY();
        }
    }

    private class VisualWorkshop<T extends IsVehicle> extends VisualItem {
        private final Workshop<T> workshop;

        VisualWorkshop(Workshop<T> workshop, int x, int y, String imagePath) {
            super(x, y, imagePath, 101, 96);
            this.workshop = workshop;
        }

        public Workshop<T> getWorkshop() {
            return workshop;
        }

        public void openStorage() {
            workshop.openStorage();
        }
    } */

    private static final int X = 800;
    private static final int Y = 400;
    private final ArrayList<IsVehicle> vehicles;
    // private final ArrayList<VisualVehicle> vehicles;
    // private final VisualWorkshop<IsVolvo> volvoWorkshop;
    private final Workshop<IsVolvo> volvoWorkshop;
    private VehicleController controller;
    private VehicleUI ui;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10; // 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer; // move
    private List<ModelListener> listeners;
    // The frame that represents this instance View of the MVC pattern
    // Start a new view and send a reference of self
    VehicleView view;

    VehicleSimulation() {
        timer = new Timer(delay, new TimerListener());
        listeners = new ArrayList<>();
        controller = new VehicleController(/* X, Y, 100, 100 */);
        view = new VehicleView("CarSim 1.0", X, Y);
        ui = new VehicleUI(view, controller);
        ui.initWidgets();
        addModelListener(view);
        
        vehicles = new ArrayList<>();
        volvoWorkshop = new Workshop<IsVolvo>(30, 300,300,100,100);

        addVehicle(new Volvo240(0, 0,100,100));
        addVehicle(new Saab95(0, 100,100,100));
        addVehicle(new ScaniaV8<Cargo>(0, 200,100,100));
        addVehicle(new Volvo240(0, 300,100,100));

        initWorkshop();

        view.initVisuals();
        // init();
    }

    private void initWorkshop() {
        volvoWorkshop.openStorage();
        view.addWorkshop(volvoWorkshop, "Volvo");
    }

    public void addModelListener(ModelListener listener) {
        listeners.add(listener);
    }

    private void addVehicle(IsVehicle vehicle) {
        vehicles.add(vehicle);
        controller.addVehicle(vehicle);
        view.addVehicle(vehicle);
        // vehicles.add(new VisualVehicle(vehicle, "pics/" + vehicle.getModel() + ".jpg"));
    }


    // private void init() {
    //     for (VisualVehicle visualVehicle : vehicles) {
    //         initVehicle(visualVehicle);
    //     }
    //     volvoWorkshop.openStorage();
    //     drawVisualItem(volvoWorkshop);
    // }

    // private void initVehicle(VisualVehicle visualVehicle) {
    //     addVehicleToControll(visualVehicle);
    //     drawVisualItem(visualVehicle);
    // }

    // private void addVehicleToControll(VisualVehicle v) {
    //     controller.addVehicle(v.getVehicle());
    // }

    // private void drawVisualItem(VisualItem item) {
    //     view.addItem(item.getX(), item.getY(), item.getImagePath());
    // }

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

    public void update() {
        IsVehicle enteredWorkshop = null;
        for (IsVehicle v : vehicles) {
            controller.update(v);
            if(workshopInteraction(v)) {
                enteredWorkshop = v;
            }
        }
        vehicles.remove(enteredWorkshop);
        informListeners();
    }

    private boolean workshopInteraction(IsVehicle v) {
        if (v.overlaps(volvoWorkshop)) {
            return enterWorkshopIfAllowed(v);
        }
        return false;
    }

    // private void worldHasBouncyWalls(IsVehicle car) {
    //     if (isOutOfBounds(car)) {
    //         car.turnLeft(Math.PI);
    //     }
    // }

    // private boolean isOutOfBounds(IsVehicle car) {
    //     return (car.getPosition().getX() < -5) || (worldWidth - vehicleWidth + 5 < car.getPosition().getX()) 
    //      || (car.getPosition().getY() < -5) || (worldHeight - vehicleHeight + 5< car.getPosition().getY());
    // }

    private boolean enterWorkshopIfAllowed(IsVehicle v) {
        if (canEnter(v)) {
            enterWorkshop(v);
            return true;
        }
        return false;
    }

    private void enterWorkshop(IsVehicle v) {
        System.out.println("A " + v.getModel() + " has entered the workshop for service!");
        controller.removeVehicle(v);
        volvoWorkshop.addToStorage((IsVolvo)v);
    }

    private boolean canEnter(IsVehicle v) {
        return v instanceof IsVolvo && volvoWorkshop.isStorageOpen();
    }


}