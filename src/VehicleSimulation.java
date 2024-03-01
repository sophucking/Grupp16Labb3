import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import Controller.VehicleController;
import Model.Vehicles.Cargo;
import Model.Vehicles.IsVehicle;
import Model.Vehicles.IsVolvo;
import Model.Vehicles.Saab95;
import Model.Vehicles.ScaniaV8;
import Model.Vehicles.Volvo240;
import Model.Vehicles.Workshop;
import View.CarView;

public class VehicleSimulation {
    private class VisualItem {
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
    }

    private static final int X = 800;
    private static final int Y = 400;
    private final ArrayList<VisualVehicle> vehicles;
    private final VisualWorkshop<IsVolvo> volvoWorkshop;
    private VehicleController controller;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10; // 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer; // move

    // The frame that represents this instance View of the MVC pattern
    // Start a new view and send a reference of self
    CarView view;

    VehicleSimulation() {
        timer = new Timer(delay, new TimerListener());
        controller = new VehicleController(X, Y, 100, 100);
        view = new CarView("CarSim 1.0", controller, X, Y);
        vehicles = new ArrayList<>();
        volvoWorkshop = new VisualWorkshop<>(new Workshop<>(30), 300, 300, "pics/VolvoBrand.jpg");

        addVehicle(new Volvo240(0, 0));
        addVehicle(new Saab95(0, 100));
        addVehicle(new ScaniaV8<Cargo>(0, 200));
        addVehicle(new Volvo240(0, 300));
        init();
    }

    private void addVehicle(IsVehicle vehicle) {
        vehicles.add(new VisualVehicle(vehicle, "pics/" + vehicle.getModel() + ".jpg"));
    }

    private void init() {
        for (VisualVehicle visualVehicle : vehicles) {
            initVehicle(visualVehicle);
        }
        volvoWorkshop.openStorage();
        drawVisualItem(volvoWorkshop);
    }

    private void initVehicle(VisualVehicle visualVehicle) {
        addVehicleToControll(visualVehicle);
        drawVisualItem(visualVehicle);
    }

    private void addVehicleToControll(VisualVehicle v) {
        controller.addVehicle(v.getVehicle());
    }

    private void drawVisualItem(VisualItem item) {
        view.addItem(item.getX(), item.getY(), item.getImagePath());
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

    private void start() {
        timer.start();
    }

    public void update() {
        VisualVehicle enteredWorkshop = null;
        for (VisualVehicle v : vehicles) {
            controller.update(v.getVehicle());
            v.update();
            if(workshopInteraction(v)) {
                enteredWorkshop = v;
            }
            drawVisualItem(v);
        }
        vehicles.remove(enteredWorkshop);
        drawVisualItem(volvoWorkshop);
        view.update();
    }

    private boolean workshopInteraction(VisualVehicle v) {
        if (collisionOccurs(v, volvoWorkshop)) {
            return enterWorkshopIfAllowed(v.getVehicle(), volvoWorkshop.getWorkshop());
        }
        return false;
    }

    private boolean collisionOccurs(VisualItem a, VisualItem b) {
        return a.overlaps(b);
    }

    private boolean enterWorkshopIfAllowed(IsVehicle v, Workshop<IsVolvo> w) {
        if (canEnter(v, w)) {
            enterWorkshop(v, w);
            return true;
        }
        return false;
    }

    private void enterWorkshop(IsVehicle v, Workshop<IsVolvo> w) {
        System.out.println("A " + v.getModel() + " has entered the workshop for service!");
        controller.removeVehicle(v);
        w.addToStorage((IsVolvo)v);
    }

    private boolean canEnter(IsVehicle v, Workshop<? extends IsVehicle> w) {
        return v instanceof IsVolvo && w.isStorageOpen();
    }

    public static void main(String[] args) {
        VehicleSimulation vSim = new VehicleSimulation();
        // Start the timer
        vSim.start();
    }

}