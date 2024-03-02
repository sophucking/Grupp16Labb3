package View;

import Model.Vehicles.IsVehicle;
import Model.Vehicles.Workshop;

public class VisualWorkshop<T extends IsVehicle> extends ConcreteVisualItem {
        private final Workshop<T> workshop;

        VisualWorkshop(Workshop<T> workshop, String imagePath) {
            super(workshop.getX(), workshop.getY(), imagePath, workshop.getWidth(),workshop.getHeight());
            this.workshop = workshop;
        }

        public Workshop<T> getWorkshop() {
            return workshop;
        }
        //volvoWorkshop = new VisualWorkshop<>(new Workshop<>(30), 300, 300, "pics/VolvoBrand.jpg");

        public void openStorage() {
            workshop.openStorage();
        }

    }

