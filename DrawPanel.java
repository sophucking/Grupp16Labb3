import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    private class ImagePointPair {
        private Point point;
        private BufferedImage image;

        private ImagePointPair(Point point, BufferedImage image) {
            this.point = point;
            this.image = image;
        }

        ImagePointPair(int x, int y, BufferedImage image) {
            this(new Point(x, y), image);
        }

        public int getX() {
            return point.x;
        }

        public int getY() {
            return point.y;
        }

        // public Point getPoint() {
        //     return point;
        // }

        public BufferedImage getImage() {
            return image;
        }

        public void move(int x, int y) {
            point.move(x, y);
        }
    }
Dra
    // Just a single image, TODO: Generalize
    // BufferedImage volvoImage;
    private ArrayList<GroundVehicle> carList;
    private ArrayList<ImagePointPair> imageList;

    private ImagePointPair workshop;
    // BufferedImage volvoWorkshopImage;
    // Point volvoWorkshopPoint = new Point(300,300);

    // TODO: Make this general for all cars
    void moveit(int ind, int x, int y) {
        imageList.get(ind).move(x, y);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.imageList = new ArrayList<>();
        this.carList = new ArrayList<>();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    public void addCar(GroundVehicle car) {
        int x = (int) car.getPosition().x;
        int y = (int) car.getPosition().y;
        String model = car.getModel();
        // volvoImage =
        // ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        // volvoWorkshopImage =
        // ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        imageList.add(
                createNewVisualItem(x, y, "pics/" + model + ".jpg"));
        carList.add(car);
    }

    public void addWorkshop(int x, int y, String imagePath) {
        workshop = createNewVisualItem(x, y, imagePath);
    }

    public void removeImage(GroundVehicle car) {
        int i = carList.indexOf(car);
        imageList.remove(i);
        carList.remove(i);
    }

    private ImagePointPair createNewVisualItem(int x, int y, String imagePath) {
        // Print an error message in case file is not found with a try/catch block
        // ImagePointPair newItem;
        try {
            return new ImagePointPair(x, y, ImageIO.read(
                    DrawPanel.class.getResourceAsStream(imagePath)));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawAllCars(g);
        drawImage(g, workshop);
    }

    private void drawAllCars(Graphics g) {
        for (ImagePointPair car : imageList) {
            drawImage(g, car);
        }
    }

    private void drawImage(Graphics g, ImagePointPair image) {
        g.drawImage(image.getImage(), image.getX(), image.getY(), null); // see javadoc for more info on the parameters
    }
}
